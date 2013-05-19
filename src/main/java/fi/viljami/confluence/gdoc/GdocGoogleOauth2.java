/*
 * Copyright (c) 2013 Viljami Peltola.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package fi.viljami.confluence.gdoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

/**
 * @author viljami
 *
 */
public class GdocGoogleOauth2 extends HttpServlet {

	public static final String CODE_URL_PARAM_NAME = "code";
	public static final String ERROR_URL_PARAM_NAME = "error";
	public static final String URL_MAPPING = "/oauth2callback";
	  
    private HttpTransport httpTransport = new NetHttpTransport();
    private JsonFactory jsonFactory = new JacksonFactory();
    
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
	    String[] error = req.getParameterValues(ERROR_URL_PARAM_NAME);
	    if (error != null && error.length > 0) {
	      res.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "There was an error: " + error[0] );
	      return;
	    }
	    
	    String[] code = req.getParameterValues(CODE_URL_PARAM_NAME);
	    if (code == null || code.length == 0) {
	      res.sendError(HttpServletResponse.SC_BAD_REQUEST, "The code URL parameter is missing");
	      return;
	    }
	    
	    // Authentication OK.
	    GoogleCredential googleCredential = null;
	    try { 
	        GoogleTokenResponse response = new GoogleAuthorizationCodeTokenRequest(
	            httpTransport,
	            jsonFactory,
	            OauthProperties.getClientId(),
	            OauthProperties.getClientSecret(),
	            code[0],
	            OauthProperties.getRedirectUri()).execute();
	        googleCredential = new GoogleCredential().setFromTokenResponse(response);
	      } catch (IOException e) {
	        new RuntimeException("An unknown problem occured while retrieving token");
	      }
	    
	    Drive drive = new Drive.Builder( httpTransport, jsonFactory, googleCredential).build();
	    List<File> files = retrieveAllFiles( drive );
	    
	    HttpSession session = req.getSession();
	    session.setAttribute( "files", files );
	    
	    try {
			res.getWriter().print("OK");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static List<File> retrieveAllFiles(Drive drive) throws IOException {
		List<File> result = new ArrayList<File>();
		Files.List request = drive.files().list();
		
		do {
			try {
				FileList files = request.execute();
				result.addAll(files.getItems());
				request.setPageToken(files.getNextPageToken());
			} catch (IOException e) {
				System.out.println("An error occurred: " + e);
				request.setPageToken(null);
			}
		} while (request.getPageToken() != null &&
		request.getPageToken().length() > 0);
		return result;
	}
}

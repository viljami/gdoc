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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * @author viljami
 *
 */
public class GdocServlet extends HttpServlet {

	private Gson gson = new Gson();
    
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		Object files = req.getSession().getAttribute("files");
		if( files == null ) {
			files = new Object();
		}
		sendJson( res, files );
	}
	
	protected void sendJson(HttpServletResponse res, int responceCode, Object obj) {
		try {
			res.setContentType("application/json");
			res.getWriter().print(gson.toJson(obj).toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void sendJson(HttpServletResponse res, Object obj) {
		sendJson(res, 200, obj);
	}
}

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

import java.util.Arrays;
import java.util.List;

public class OauthProperties {

    private static final String CLIENT_ID = "258701595351.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "yhKkvja6zsbB8mib03XZkuCO";
	private static final String REDIRECT_URI = "http://viljamipeltola.com/confluence/gdoc/oauth2callback";

	private static final String AUTH_URI = "https://accounts.google.com/o/oauth2/auth";
	private static final String TOKEN_URI = "https://accounts.google.com/o/oauth2/token";
	private static final List<String> SCOPES = Arrays.asList(
            "https://www.googleapis.com/auth/userinfo.email",
            "https://www.googleapis.com/auth/userinfo.profile",
            "https://www.googleapis.com/auth/drive.file");
	
	public static String getClientId() {
		return CLIENT_ID;
	}
	public static String getClientSecret() {
		return CLIENT_SECRET;
	}
	public static String getRedirectUri() {
		return REDIRECT_URI;
	}
	public static String getAuthUri() {
		return AUTH_URI;
	}
	public static String getTokenUri() {
		return TOKEN_URI;
	}
	public static List<String> getScopes() {
		return SCOPES;
	}
}

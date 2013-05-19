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

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.content.render.xhtml.XhtmlException;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.xhtml.api.MacroDefinition;
import com.atlassian.confluence.xhtml.api.MacroDefinitionHandler;
import com.atlassian.confluence.xhtml.api.XhtmlContent;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GdocMacro implements Macro
{
    private final XhtmlContent xhtmlUtils;
    private String googleConnectURL = "";

    public GdocMacro(XhtmlContent xhtmlUtils)
    {
        this.xhtmlUtils = xhtmlUtils;
    }

    @Override
    public BodyType getBodyType()
    {
        return BodyType.NONE;
    }

    @Override
    public OutputType getOutputType()
    {
        return OutputType.BLOCK;
    }

    @Override
    public String execute(Map<String, String> parameters, String bodyContent, ConversionContext conversionContext) throws MacroExecutionException
    {
        String body = conversionContext.getEntity().getBodyAsString();

        final List<MacroDefinition> macros = new ArrayList<MacroDefinition>();

        try
        {
            xhtmlUtils.handleMacroDefinitions(body, conversionContext, new MacroDefinitionHandler()
            {
                @Override
                public void handle(MacroDefinition macroDefinition)
                {
                    macros.add(macroDefinition);
                }
            });
        }
        catch ( XhtmlException e )
        {
            throw new MacroExecutionException(e);
        }

        StringBuilder builder = new StringBuilder();
        builder.append("<div id=\"gdoc-macro-container\">");
        builder.append("<p class=\"bold\">Google Documents On Confluence</p>");
        if ( !macros.isEmpty() )
        {
            builder.append("<p><a href=\"" + getConnectGoogleURL() + "\" target=\"_blank\">Google Authenticate.</a></p>");
        }
        builder.append("</div>");

        return builder.toString();
    }

    private String getConnectGoogleURL() {
    	
    	if( googleConnectURL.equals("") ) {
            GoogleAuthorizationCodeRequestUrl url = new GoogleAuthorizationCodeRequestUrl(
	    			OauthProperties.getClientId(),
	                OauthProperties.getRedirectUri(),
	                OauthProperties.getScopes());
	    	googleConnectURL = url.build();
            //googleConnectURL = "this-is-a-test-url";
    	}
    	System.out.println( googleConnectURL );
    	return googleConnectURL;	
    }
}

# GDOC

Google Documents On Confluence

## Setup

1. Setup Atlassian Plugin SDK 
 * https://developer.atlassian.com/display/DOCS/Set+up+the+Atlassian+Plugin+SDK+and+Build+a+Project
2. Create folder for your project e.g. confluence
3. Get this git repo into the folder in its own folder

Eclipse 
 * https://developers.google.com/drive/quickstart-java
 * https://developer.atlassian.com/display/DOCS/Set+Up+the+Eclipse+IDE+for+Linux

## Run

Here are the SDK commands you'll use immediately:

* atlas-run   -- installs this plugin into the product and starts it on localhost
* atlas-debug -- same as atlas-run, but allows a debugger to attach at port 5005
* atlas-cli   -- after atlas-run or atlas-debug, opens a Maven command line window:
                 - 'pi' reinstalls the plugin into the running product instance
* atlas-help  -- prints description for all commands in the SDK

Full documentation is always available at:

https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK

## TODO:
 * Smart user management for oauth
 * smart token management (refresh)
 * How macro will react when there is multiple macros on same page.
 * Save Gdocs to page (and let user to choose which)
 * Show fully embedded documents 
 * Edit embedded documents
 * Define a purpose for the plugin...

## Other

 * http://lsd.luminis.eu/en/developing-a-confluence-plugin/
 * https://developer.atlassian.com/display/JIRADEV/JIRA+REST+API+Example+-+OAuth+authentication

## Licence

Copyright (c) 2013 Viljami Peltola.
 
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except
in compliance with the License. You may obtain a copy of the License at
 
http://www.apache.org/licenses/LICENSE-2.0
 
Unless required by applicable law or agreed to in writing, software distributed under the License
is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
or implied. See the License for the specific language governing permissions and limitations under
the License.

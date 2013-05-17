# GDOC

Google Documents On Confluence

## Setup

1. Setup Atlassian Plugin SDK 
 * https://developer.atlassian.com/display/DOCS/Set+up+the+Atlassian+Plugin+SDK+and+Build+a+Project
2. Create folder for your project e.g. confluence
3. Get this git repo into the folder in its own folder

## Run

Here are the SDK commands you'll use immediately:

* atlas-run   -- installs this plugin into the product and starts it on localhost
* atlas-debug -- same as atlas-run, but allows a debugger to attach at port 5005
* atlas-cli   -- after atlas-run or atlas-debug, opens a Maven command line window:
                 - 'pi' reinstalls the plugin into the running product instance
* atlas-help  -- prints description for all commands in the SDK

Full documentation is always available at:

https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK

## Other

The work is based on these valuable links:
 * https://developer.atlassian.com/display/DOCS/Set+Up+the+Eclipse+IDE+for+Linux
 * https://developer.atlassian.com/display/CONFDEV/Writing+Macros+for+Pre-4.0+Versions+of+Confluence


## Licence

Google Documents On Confluence ( GDOC ) displays users google documents on Confluence.
Copyright (C) 2013  Viljami Peltola

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
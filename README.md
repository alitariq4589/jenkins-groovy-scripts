# jenkins-groovy-scripts
This repo includes the Groovy scripts which can be used in the Jenkins Script console for managing specific settings in Jenkins. 
I will also add Python scripts that will use the requests library to submit the Groovy scripts to the server.

## Why do you need Groovy scripts to change Jenkins settings?

You may want to automate a process in Jenkins which may include changing specific settings via script in Jenkins Global configuration. The easiest way that may come to your mind (because it came to my mind) is to use Python Requests Library to change the settings in Jenkins. The issue with that is, that you cannot change a specific setting this way because Jenkins will not accept incomplete JSON forms only for desired. So you will end up submitting the whole settings in the JSON form. But for this, you will first have to fetch the global configuration as JSON response from Jenkins, and as of today, Jenkins' REST API does not provide getting JSON form response of global configuration.

### What is the catch?

The catch is that, what if someday you use GUI to change the settings and your script is using an older version of the JSON form of Jenkins Global configuration?
Everything will be difficult to manage and will be inconsistent

## What do groovy scripts do?

You will be able to change the Jenkins settings by submitting these Groovy scripts as a Python POST request. As the part that you want to change will be independent of the other settings, this will be convenient for you to manage Jenkins settings via code. These scripts are based on the fact that most of the settings in the Jenkins Global configuration are part of the plugin and by using plugin classes you can change the settings.

## How to use

Each folder of the repository will include groovy script(s) (and possibly a Python file to submit a response). This will include a JSON file which will include the Jenkins URL, Jenkins Username, and Jenkins password settings of your instance. You just have to change the JSON file and any desired settings in the Groovy script, then you will be able to submit the script as a Python request.

## Contribute

Contributors are welcome to add any new scripts which they may find useful

#!/bin/bash
# This script deploys the Maven site.
#
# Make sure you have the deployment configuration ready before using it.
#
# It is triggered only commits to the master or develop branches, ignoring pulls.
#
# Also, it will only deploy if the DEPLOY_DOCS environment variable is set to 'true'.
#
# The following environmental variables are used:
# - PULL_REQUEST: boolean, indicates if this is a pull request, should be false for deployment
# - DEPLOY_DOCS: boolean, control flag for deployment, should be true to deploy
# - SCM_BRANCH: string, the CMS branch from which the code has been taken

if [ "$PULL_REQUEST" == "false" ] && [ "$DEPLOY_DOCS" == "true" ] && [[ "$SCM_BRANCH" == "master" || "$SCM_BRANCH" == "develop" ]]; then

   echo "Deploying Maven site"

   mvn site site:deploy --settings ~/settings.xml > site_output.txt
	  
   head -50 site_output.txt
   echo " "
   echo "(...)"
   echo " "
   tail -50 site_output.txt

else

   echo "Maven site won't be deployed"

fi

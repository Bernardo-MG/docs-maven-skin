#!/bin/bash
# This script deploys the Maven site.
#
# Make sure you have the deployment configuration ready before using it, including
# the environment variables which will indicate if the script is to be run or not.
#
# If everything is correct, the deployment will only occur with release or development
# versions. And any pull request, in case the code comes from SCM, will be ignored.
#
# Note that if required the DEPLOY_DOCS environment variable can be used to stop the script
# from running by setting it to 'false'.
#
# The following environmental variables are used:
# - DEPLOY_DOCS: boolean, control flag for deployment, should be true to deploy
# - PULL_REQUEST: boolean, indicates if this is a pull request, should be false for deployment
# - VERSION_TYPE: string, the type of version of the code. One of 'release', 'develop' or 'other'.

set -o nounset
set -e

if [ "$DEPLOY_DOCS" == "true" ] && [ "$PULL_REQUEST" == "false" ] && [ "$VERSION_TYPE" != "other" ]; then

   echo "Deploying Maven site"

   mvn site site:deploy -P deployment --settings ~/settings.xml > site_output.txt
	  
   head -50 site_output.txt
   echo " "
   echo "(...)"
   echo " "
   tail -50 site_output.txt
   
   exit 0

else

   echo "Maven site won't be deployed"
   
   exit 0

fi

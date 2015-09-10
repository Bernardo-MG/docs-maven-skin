#!/bin/bash
# This script deploys the project artifact.
#
# Make sure you have the deployment configuration ready before using it.
#
# It is triggered only commits to the master or develop branches, ignoring pulls.
#
# Also, it will only deploy if the DEPLOY environment variable is set to 'true'.
#
# The following environmental variables are used:
# - PULL_REQUEST: boolean, indicates if this is a pull request, should be false for deployment
# - DEPLOY: boolean, control flag for deployment, should be true to deploy
# - SCM_BRANCH: string, the CMS branch from which the code has been taken

if [ "$PULL_REQUEST" == "false" ] && [ "$DEPLOY" == "true" ] && [[ "$SCM_BRANCH" == "master" || "$SCM_BRANCH" == "develop" ]]; then

   echo "Deploying Java artifact to repository"

   mvn deploy --settings ~/settings.xml
   
else

   echo "Java artifact won't be deployed to repository"

fi

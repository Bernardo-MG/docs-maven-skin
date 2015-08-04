#!/bin/bash
# This script deploys the application using the POM configuration
# It is triggered only commits to the master or develop branches. Pulls are ignored
#
# Also, it will only deploy if the DEPLOY environment variable is set to 'true'

if [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$DEPLOY" == "true" ] && [[ "$TRAVIS_BRANCH" == "master" || "$TRAVIS_BRANCH" == "develop" ]]; then

   echo "Deploying Java artifact to repository"

   mvn deploy --settings ~/settings.xml
   
else

   echo "Java artifact won't be deployed to repository"

fi

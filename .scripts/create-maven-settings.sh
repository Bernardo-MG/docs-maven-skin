#!/bin/bash
#
# This script creates the Maven settings file for deployment, and is meant to be used
# as part of the CI process. Said file will be stored on the ~/settings.xml path, and
# its contents will be created from a series of environmental variables.
#
# The most important information it will contain will be the connection settings for all
# the repositories used during deployment.
#
# For security reasons the data stored in the generated file should not be shared. Never 
# print it on the console or let it be accessed in any way.
#
# The following environmental variables are required by the script:
# - DEPLOY_USER: string, user for the releases repo
# - DEPLOY_PASSWORD: string, password for the releases repo
# - DEPLOY_DEVELOP_USER: string, user for the development repo
# - DEPLOY_DEVELOP_PASSWORD: string, password for the development repo
# - DEPLOY_DOCS_USER: string, user for the releases documentation site repo
# - DEPLOY_DOCS_PASSWORD: string, password for the releases documentation site repo
# - DEPLOY_DOCS_DEVELOP_USER: string, user for the development documentation site repo
# - DEPLOY_DOCS_DEVELOP_PASSWORD: string, password for the development documentation site repo
# - VERSION_TYPE: string, the type of version of the code. One of 'release', 'develop' or 'other'.

set -o nounset
set -e

{
   echo "<settings>";
   
   # ----------------
   # Servers settings
   # ----------------
   echo "<servers>";
   
   # Releases artifacts server
   echo "<server>";
      echo "<id>releases</id>";
      echo "<username>\${env.DEPLOY_USER}</username>";
      echo "<password>\${env.DEPLOY_PASSWORD}</password>";
   echo "</server>";
   # Release site server
   echo "<server>";
      echo "<id>site</id>";
      echo "<username>\${env.DEPLOY_DOCS_USER}</username>";
      echo "<password>\${env.DEPLOY_DOCS_PASSWORD}</password>";
   echo "</server>";
   
   # Development artifacts server
   echo "<server>";
      echo "<id>snapshots</id>";
      echo "<username>\${env.DEPLOY_DEVELOP_USER}</username>";
      echo "<password>\${env.DEPLOY_DEVELOP_PASSWORD}</password>";
   echo "</server>";
   # Release site server
   echo "<server>";
      echo "<id>site-development</id>";
      echo "<username>\${env.DEPLOY_DOCS_DEVELOP_USER}</username>";
      echo "<password>\${env.DEPLOY_DOCS_DEVELOP_PASSWORD}</password>";
   echo "</server>";
   
   echo "</servers>";
   # ---------------------
   # Ends servers settings
   # ---------------------
   
   # --------------
   # Active profile
   # --------------
   
   # These profiles are used to set the site repository info
   if [ "$VERSION_TYPE" == "develop" ]; then
      # Development version
      echo "<activeProfiles>"
         echo "<activeProfile>deploy-site-development</activeProfile>"
      echo "</activeProfiles>"
   elif [ "$VERSION_TYPE" == "release" ]; then
      # Release version
      echo "<activeProfiles>"
         echo "<activeProfile>deploy-site-release</activeProfile>"
      echo "</activeProfiles>"
   fi
   
   # -------------------
   # Ends active profile
   # -------------------
   
   echo "</settings>";
} >> ~/settings.xml

echo "Created Maven settings file"

exit 0

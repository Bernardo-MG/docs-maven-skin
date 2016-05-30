#!/bin/bash
#
# Sets up the CI environment.
#
# It is prepared for the Travis CI service, and will set up the environmental
# variables for all the CI procedure, but mainly for deployment.
#
# As this script will set environmetal variables it should be run as part of the
# parent shell commands by using the 'source' command. For this reason no value is
# returned, and the 'set' command is not used.
#
# These variables will be used by the other scripts for flow control. Meaning
# that they will be used to know if the other scripts will be executed, and
# how.
#
# While the DEPLOY and DEPLOY_DOCS variables are set to a default value of false,
# they should be taken care in the Travis configuration file.
#
# The following environmental variables are required by the script:
# - TRAVIS_BRANCH: string, Travis variable with the name of the SCM branch from which the code was taken
# - TRAVIS_PULL_REQUEST: boolean, Travis CI flag indicating if this is a pull request
# - DEPLOY: boolean, flag indicating if the artifacts will be deployed
# - DEPLOY_DOCS: boolean, flag indicating if the documents will be deployed
#
# The following environmental variables will be set by the script:
# - VERSION_TYPE: string, indicates if this is a release or development version

# Flag to know if this is a pull request
export PULL_REQUEST=$TRAVIS_PULL_REQUEST

# Flag for deploying artifacts
if [ -z "$DEPLOY" ]; then
   export DEPLOY=false;
fi

# Flag for deploying documentation
if [ -z "$DEPLOY_DOCS" ]; then
   export DEPLOY_DOCS=false;
fi

# Flag to know if this is a release or a development version
if [ "$TRAVIS_BRANCH" == "master" ]; then
   export VERSION_TYPE=release;
elif [ "$TRAVIS_BRANCH" == "develop" ]; then
   export VERSION_TYPE=develop;
else
   export VERSION_TYPE=other;
fi

echo "CI environmental variables set:";
echo "PULL_REQUEST: $PULL_REQUEST";
echo "VERSION_TYPE: $VERSION_TYPE";
echo "DEPLOY: $DEPLOY";
echo "DEPLOY_DOCS: $DEPLOY_DOCS";

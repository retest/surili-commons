#!/bin/bash

source ci/defaults.sh

# compile with JDK 8
${MVN} clean package -DskipTests

# test with JDK 11
wget --quiet https://github.com/sormuras/bach/raw/master/install-jdk.sh && . ./install-jdk.sh -F 11

# disable SonarCloud for external PRs
if [ ${TRAVIS_SECURE_ENV_VARS} = "true" ]; then
    ${MVN} org.jacoco:jacoco-maven-plugin:prepare-agent test verify sonar:sonar
else
    ${MVN} org.jacoco:jacoco-maven-plugin:prepare-agent test verify
fi

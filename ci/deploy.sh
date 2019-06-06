#!/bin/bash

source ci/defaults.sh

${MVN} deploy -DskipTests -Psign

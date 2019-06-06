#!/bin/bash

set -o nounset
set -o errexit
set -o pipefail

export MVN='mvn --settings .travis.settings.xml'

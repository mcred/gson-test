#!/usr/bin/env bash

set -ex

native-image -cp ${PWD}/target/gson-0.1.0-jar-with-dependencies.jar\
    -H:Name=gson\
    -H:Class=test.gson.Test\
    -H:+ReportUnsupportedElementsAtRuntime\
    -H:ReflectionConfigurationFiles=${PWD}/config/reflect-config.json\
    -H:ResourceConfigurationFiles=${PWD}/config/resource-config.json\
    -H:+AddAllCharsets\
    --allow-incomplete-classpath\
    --enable-http\
    --enable-https

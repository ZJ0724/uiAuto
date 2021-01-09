#!/bin/bash

version="3.0.0"
packagePath=".release"
name="uiAuto"
resourcePath="build"

./gradlew clean
./gradlew build
./gradlew buildResource

rm -rf ${packagePath}
mkdir ${packagePath}

tar -cvf ${packagePath}/${name}-${version}.zip -C ${resourcePath} ${name}
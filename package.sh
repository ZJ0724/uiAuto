#!/bin/bash

version="4.0.0"
applicationName="uiAuto"
buildPath="build"

rm -rf ${buildPath}
./gradlew build
./gradlew buildResource

mkdir -p ${buildPath}/${applicationName}
mkdir -p ${buildPath}/${applicationName}/lib
cp -r build/libs/* ${buildPath}/${applicationName}
cp -r build/lib/* ${buildPath}/${applicationName}/lib

tar -cvf ${buildPath}/${applicationName}-${version}.zip -C ${buildPath} ${applicationName}
#!/bin/bash

packagePath=".release"
name="uiAuto"
resourcePath="build"

./gradlew clean
./gradlew build
./gradlew buildResource

rm -rf ${packagePath}
mkdir ${packagePath}

tar -cvf ${packagePath}/${name}.zip -C ${resourcePath} ${name}
#!/bin/bash

# 打包目录
releasePath="release"
# 包名
packageName=""
# maven打包存放目录
buildPath="target/build"
# 当前分支名
branchName=$(git branch | grep "*")

# 清除maven编译目录
mvn clean

# 根据分支名判断怎么进行打包
if [ "${branchName}" == "* dev" ]; then
    mvn package
else
    mvn package -P prod
fi

# 获取包名
for dirName in $(ls ${buildPath})
do
  packageName="${dirName}"
done

# 删除重新创建打包目录
rm -rf ${releasePath}
mkdir ${releasePath}

# 打包
tar -cvf ${releasePath}/${packageName}.zip -C ${buildPath} ${packageName}
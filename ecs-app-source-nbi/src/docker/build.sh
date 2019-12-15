#!/bin/bash
# http://wiki.obrienlabs.cloud/display/DEV/AWS+ECR+E2E+Architecture
# source from http://jira.obrienlabs.cloud/browse/ECS-1
# https://github.com/obrienlabs/ecs-app-source
# Michael O'Brien

BUILD_ID=10001
BUILD_DIR=builds
mkdir ../../$BUILD_DIR
TARGET_DIR=../../$BUILD_DIR/$BUILD_ID
mkdir $TARGET_DIR
CONTAINER_IMAGE=ecs-app-source-nbi

cp ../../target/*.jar $TARGET_DIR
cp DockerFile $TARGET_DIR
cp startService.sh $TARGET_DIR
cd $TARGET_DIR
docker build --no-cache --build-arg build-id=$BUILD_ID -t $CONTAINER_IMAGE -f DockerFile .
docker tag $CONTAINER_IMAGE:latest $CONTAINER_IMAGE:latest
docker stop $CONTAINER_IMAGE
docker rm $CONTAINER_IMAGE
echo "starting: $CONTAINER_IMAGE"
docker run --name $CONTAINER_IMAGE -d -p 8888:8080 -e os.environment.configuration.dir=/ -e os.environment.ecosystem=sbx $CONTAINER_IMAGE:latest

cd ../../src/docker


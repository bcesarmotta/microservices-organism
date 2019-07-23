# microservices-organism

## Stoping any possible running images
docker stop $(docker ps | awk 'NR > 1 {print $1}')

echo '===== Updating dependencies'
echo ''

sudo apt update


## Install Mongodb

echo '===== Installing mongodb'
echo ''

sudo apt install -y mongodb

## Start service

echo '===== Starting Mongodb Service'
echo ''

sudo service mongodb start

## Pull nexus repository from Docker Image

echo '===== pulling Nexus Repository'
echo ''

sudo docker pull sonatype/nexus3

## Run Nexus Image

echo '===== Starting Nexus Image'

sudo docker restart nexus &

echo '===== Running nexus Image'
echo ''

sudo docker run -d -p 8081:8081 --name nexus sonatype/nexus3

echo '===== Waiting Nexus start...'

while ! echo exit | nc localhost 8081; do sleep 10; done

echo '===== Nexus is running...'

## pull ActiveMQ from a Docker image

echo '===== Pulling ActiveMQ'
echo ''

sudo docker pull rmohr/activemq

## Run ActiveMQ Image

echo '===== Running ActiveMQ'
echo ''

sudo docker run -p 61616:61616 -p 8161:8161 rmohr/activemq &

## deploy commons

echo '===== Deploying Commons'
echo ''

cd commons
mvn clean package install deploy

cd ../

## run discovery server

echo '==== Running Discovery Server'
echo ''

cd discovery-server
mvn spring-boot:run

cd ../

## run gateway

echo '===== Running Gateway'
echo ''

cd gateway
mvn spring-boot:run

cd ../

## run campaign service

echo '===== Runnign Campaign Service'
echo ''

cd campaign
mvn spring-boot:run

cd ../

## run football-team

echo '===== Running Football Team Service'
echo ''

cd football-team
mvn spring-boot:run

cd ../

## run supporter-member

echo '=====Running Supporter Member Service'
echo ''

cd supporter-member
mvn spring-boot:run

cd ../


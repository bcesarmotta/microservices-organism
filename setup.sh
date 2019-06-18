# microservices-organism

sudo apt update

## Install Mongodb
sudo apt install -y mongodb

## Start service
sudo service mongodb start

## Pull nexus repository from Docker Image
sudo docker pull sonatype/nexus3

## Run Nexus Image
sudo docker run -d -p 8081:8081 --name nexus sonatype/nexus3

## pull ActiveMQ from a Docker image
sudo docker pull rmohr/activemq

## Run ActiveMQ Image
sudo docker run -p 61616:61616 -p 8161:8161 rmohr/activemq

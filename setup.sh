# microservices-organism

sudo apt update

## Install Mongodb
sudo apt install -y mongodb

## Start service
sudo service mongodb start

## Start nexus repository by Docker Image
sudo docker pull sonatype/nexus3

## Run Docker Image
sudo docker run -d -p 8081:8081 --name nexus sonatype/nexus3

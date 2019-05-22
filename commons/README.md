# microservices-organism

## Start nexus repository by Docker Image
docker pull sonatype/nexus3

## Run Docker Image
docker run -d -p 8081:8081 --name nexus sonatype/nexus3

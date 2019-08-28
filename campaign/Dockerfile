# Install JDK 11
FROM openjdk:11

# Add Maintainer Info
LABEL maintainer="bcesarmotta@yahoo.com.br"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8083 available to the world outside this container
EXPOSE 8083

# The application's jar file
ARG JAR_FILE=target/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} campaign-service.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/campaign-service.jar"]


# Building the image
# docker build -t microservices-organism/campaign-service .

# Running container
# we have specified that the port 8083 (on right) on the container should be mapped to the port 8083 (on left) on the Host OS.
# docker run -p 8083:8083 --name campaign-service microservices-organism/campaign-service

# Install JDK 11
FROM openjdk:11

# Add Maintainer Info
LABEL maintainer="bcesarmotta@yahoo.com.br"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8084 available to the world outside this container
EXPOSE 8084

# The application's jar file
ARG JAR_FILE=target/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} footbal-team.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/footbal-team.jar"]


# Building the image
# docker build -t microservices-organism/footbal-team .

# Running container
# we have specified that the port 8084 (on right) on the container should be mapped to the port 8084 (on left) on the Host OS.
#  docker run --name footbal-team -p 8084:8084 microservices-organism/footbal-team
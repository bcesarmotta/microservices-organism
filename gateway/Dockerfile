# Install JDK 11
FROM openjdk:11.0.4-jre-slim

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8084 available to the world outside this container
EXPOSE 8111

# The application's jar file
ARG JAR_FILE=target/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} gateway.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/gateway.jar"]

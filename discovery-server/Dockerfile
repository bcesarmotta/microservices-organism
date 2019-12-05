# Add Maintainer Info
LABEL maintainer="bcesarmotta@yahoo.com.br"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8761 available to the world outside this container
EXPOSE 8761

# The application's jar file
ARG JAR_FILE=target/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} service-discovery.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/service-discovery.jar"]


# Building the image
# docker build -t microservices-organism/service-discovery .

# Running container
# we have specified that the port 8761 (on right) on the container should be mapped to the port 8761 (on left) on the Host OS.
# docker run --name service-discovery -p 8761:8761 --network microservices-organism microservices-organism/service-discovery
# docker run --name service-discovery -p 8761:8761 --network host microservices-organism/service-discovery
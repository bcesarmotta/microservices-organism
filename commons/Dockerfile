# build image
FROM maven:3.6.1-jdk-11-slim AS maven

RUN echo 'Create build directory...'

WORKDIR /build

COPY ./* ./

CMD mkdir -p /root/.m2/

COPY ./settings.xml /usr/share/maven/ref/

RUN mvn clean package #deploy
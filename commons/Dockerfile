# build image
FROM maven:3.6.3-jdk-11-slim AS maven

WORKDIR /build

COPY . .

RUN mkdir -p $MAVEN_CONFIG

RUN mkdir -p $MAVEN_CONFIG/repository/

COPY ./settings.xml $MAVEN_HOME/conf/

COPY ./settings.xml $MAVEN_CONFIG

COPY ./settings-security.xml $MAVEN_CONFIG

RUN mvn clean package deploy
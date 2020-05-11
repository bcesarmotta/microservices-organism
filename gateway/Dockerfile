# Install JDK 11
FROM maven:3.6.3-jdk-11-slim AS maven

WORKDIR /build

COPY . .

RUN mkdir -p $MAVEN_CONFIG

RUN mkdir -p $MAVEN_CONFIG/repository/

COPY ./settings.xml $MAVEN_HOME/conf/

COPY ./settings.xml $MAVEN_CONFIG

COPY ./settings-security.xml $MAVEN_CONFIG

RUN mvn clean package deploy

COPY . .

# Install JDK 11
FROM openjdk:11.0.4-jre-slim

WORKDIR /build

RUN mkdir -p /build/target/

COPY --from=maven /build/target/*.jar /build/target/

EXPOSE 8111

ARG JAR_FILE=/build/target/*.jar

RUN cp ${JAR_FILE} /build/target/gateway.jar

RUN ls -la /build/target/

ENTRYPOINT ["java","-jar","/build/target/gateway.jar"]
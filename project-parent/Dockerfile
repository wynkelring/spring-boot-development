FROM maven:3.9.5-eclipse-temurin-21-alpine as parent-builder

WORKDIR /app

ENV MAVEN_DIRECTORY "/root/.m2"

COPY .m[2]/ $MAVEN_DIRECTORY
ADD pom.xml .

RUN mvn clean deploy

ENV MAVEN_REPOSITORY "/root/.m2/repository"

RUN mv target $MAVEN_DIRECTORY
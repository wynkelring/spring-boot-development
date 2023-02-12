FROM maven:3.8.7-openjdk-18-slim as parent-builder

WORKDIR /app

ENV MAVEN_DIRECTORY "/root/.m2"

COPY .m[2]/ $MAVEN_DIRECTORY
ADD pom.xml .

RUN mvn clean deploy

ENV MAVEN_REPOSITORY "/root/.m2/repository"

RUN mv target $MAVEN_DIRECTORY
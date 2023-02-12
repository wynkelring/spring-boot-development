FROM project-parent:latest as parent-loader
FROM maven:3.8.7-openjdk-18-slim as libs-builder

WORKDIR /app

ENV MAVEN_DIRECTORY "/root/.m2"

COPY --from=parent-loader ${MAVEN_DIRECTORY} ${MAVEN_DIRECTORY}
COPY .m[2]/ $MAVEN_DIRECTORY
ADD cqs/ cqs
ADD datastore/ datastore
ADD exception/ exception
ADD feign-configuration/ feign-configuration
ADD pom.xml .

RUN mvn clean deploy

RUN mv target $MAVEN_DIRECTORY/repository
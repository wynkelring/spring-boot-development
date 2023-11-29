FROM project-parent:latest as parent-loader
FROM common-lib:latest as libs-loader
FROM maven:3.9.5-eclipse-temurin-21-alpine AS build

WORKDIR /usr/src/app

ENV MAVEN_DIRECTORY "/root/.m2"

COPY --from=parent-loader ${MAVEN_DIRECTORY} ${MAVEN_DIRECTORY}
COPY --from=libs-loader ${MAVEN_DIRECTORY} ${MAVEN_DIRECTORY}

COPY .m[2]/ $MAVEN_DIRECTORY

ADD feign-client-usage/ feign-client-usage
ADD hibernate-cache-ehcache/ hibernate-cache-ehcache
ADD work-on-database/ work-on-database
ADD steps-domain-usage/ steps-domain-usage
ADD starter/ starter
ADD pom.xml .

RUN mvn package

FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

COPY --from=build /usr/src/app/target/development-features.jar /app/development-features.jar
ENTRYPOINT ["java", "-jar", "/app/development-features.jar"]
FROM project-parent:latest as parent-loader
FROM common-lib:latest as libs-loader
FROM ghcr.io/graalvm/graalvm-ce:ol9-java17-22.3.1 as project-builder

RUN microdnf update -y oraclelinux-release-el9 \
    && microdnf --enablerepo ol9_codeready_builder install -y zip unzip \
    && microdnf clean all

RUN curl -s "https://get.sdkman.io" | bash
RUN source "$HOME/.sdkman/bin/sdkman-init.sh"  \
    && sdk install maven
#RUN source "$HOME/.sdkman/bin/sdkman-init.sh"  \
#    && sdk install java 22.3.1.r19-grl
RUN gu install native-image

WORKDIR /app

ENV MAVEN_DIRECTORY "/root/.m2"

COPY --from=parent-loader ${MAVEN_DIRECTORY} ${MAVEN_DIRECTORY}
COPY --from=libs-loader ${MAVEN_DIRECTORY} ${MAVEN_DIRECTORY}
COPY .m[2]/ $MAVEN_DIRECTORY
ADD feign-client-usage/ feign-client-usage
ADD hibernate-cache-ehcache/ hibernate-cache-ehcache
ADD starter/ starter
ADD work-on-database/ work-on-database
ADD pom.xml .

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" \
   && mvn clean package

FROM ghcr.io/graalvm/jdk:latest

WORKDIR /app

COPY --from=project-builder /app/starter/target/development-features.jar .

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "development-features.jar"]

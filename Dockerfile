# syntax=docker/dockerfile:experimental
FROM maven:3.6.3-jdk-11 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN --mount=type=cache,target=/root/.m2/repository mvn clean package -DskipTests


FROM openjdk:11-jre
ENV JAVA_OPTS=""
EXPOSE 8082
WORKDIR /app
CMD exec java $JAVA_OPTS -jar agrobaires.jar
COPY --from=build /build/target/user-api-*.jar /app/agrobaires.jar
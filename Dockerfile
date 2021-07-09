FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1

ARG PROFILE=""

WORKDIR /opt

COPY ./target/demo-0.0.1-SNAPSHOT.jar /opt/app.jar

ENTRYPOINT  java -jar app.jar -Dspring.profiles.active=$PROFILE

EXPOSE 8080
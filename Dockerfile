FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1

ENV JAVA_OPTS=""

VOLUME /tmp

COPY target/demo-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT  java $JAVA_OPTS -jar app.jar -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE

EXPOSE 8080

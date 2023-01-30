FROM openjdk:17
ARG WAR_FILE=./target/poker-*.war
COPY ${WAR_FILE} app.war
EXPOSE 8080
FROM openjdk:17
ARG WAR_FILE=./target/Patient-Appointment-0.0.1-SNAPSHOT.war
COPY ${WAR_FILE} app.war
EXPOSE 8080
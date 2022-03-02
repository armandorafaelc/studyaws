FROM openjdk:8-jdk-alpine
COPY target/studyaws-0.0.1.jar studyaws-0.0.1.jar
ENTRYPOINT ["java","-jar","/studyaws-0.0.1.jar"]
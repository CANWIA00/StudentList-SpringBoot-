FROM openjdk:11
WORKDIR /app
COPY target/StudentList-0.0.1-SNAPSHOT.jar StudentList-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","StudentList-0.0.1-SNAPSHOT.jar"]



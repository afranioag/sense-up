FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/desafio-0.0.1-SNAPSHOT.jar minisense.jar
ENTRYPOINT ["java","-jar","/minisense.jar"]

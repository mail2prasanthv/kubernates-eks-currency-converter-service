FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=./build/libs/currency-converter-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} currency-converter.jar
ENTRYPOINT ["java","-jar","/currency-converter.jar"]

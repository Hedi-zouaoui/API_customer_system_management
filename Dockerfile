FROM openjdk:8-jre-alpine

EXPOSE 8083

COPY ./target/demo-*.jar /usr/app/
WORKDIR /usr/app

CMD java -jar java-maven-app-*.jar

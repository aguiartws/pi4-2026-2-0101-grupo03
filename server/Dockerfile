FROM openjdk:17-jdk-slim

WORKDIR /app

COPY src/Server.java .

RUN javac Server.java

EXPOSE 12345

CMD ["java", "Server"]

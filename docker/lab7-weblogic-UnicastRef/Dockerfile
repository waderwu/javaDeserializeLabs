From openjdk:8u222-slim

RUN apt-get update -y \
    && apt-get install curl -y \
    && useradd ctf \
    && mkdir /opt/app

COPY lab7-weblogic-UnicastRef.jar /opt/app
COPY flag /flag

WORKDIR /opt/app

EXPOSE 8080

USER ctf
CMD ["java", "-Djdk.serialFilter=!javax.management.BadAttributeValueExpException", "-jar", "/opt/app/lab7-weblogic-UnicastRef.jar"]

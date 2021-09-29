FROM openjdk:11

VOLUME /tmp
ADD api-feiras-livres.jar /opt/api-feiras-livres/
EXPOSE 8080
WORKDIR /opt/api-feiras-livres/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "api-feiras-livres.jar"]

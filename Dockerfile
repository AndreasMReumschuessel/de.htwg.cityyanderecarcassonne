FROM gradle:jdk10 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test

FROM openjdk:10-jre-slim
COPY --from=builder /home/gradle/src/build/distributions/de.htwg.cityyanderecarcassonne.tar /app/
WORKDIR /app
#COPY ./build/distributions/de.htwg.cityyanderecarcassonne.tar /app/
RUN tar -xvf de.htwg.cityyanderecarcassonne.tar
EXPOSE 8080
WORKDIR /app/de.htwg.cityyanderecarcassonne/
CMD ["bin/de.htwg.cityyanderecarcassonne", "--microservice"]
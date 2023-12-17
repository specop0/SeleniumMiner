# Build
FROM maven as build
WORKDIR /src
COPY SeleniumMiner/src/main src/main
COPY SeleniumMiner/pom.xml pom.xml

# Publish
FROM build as publish
WORKDIR /src
RUN mvn clean compile assembly:single

# Run
FROM instrumentisto/geckodriver
RUN apt-get update && apt-get install default-jre -y

WORKDIR /app
COPY --from=publish /src/target/SeleniumMiner-1.0-SNAPSHOT-jar-with-dependencies.jar SeleniumMiner.jar
COPY SeleniumMiner/geckodriver geckodriver

ENTRYPOINT [ "java" ]
CMD [ "-jar", "SeleniumMiner.jar"]

EXPOSE 5022
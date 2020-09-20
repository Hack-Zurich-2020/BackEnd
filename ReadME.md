# HackZurich_backend

This project is based on [Spring Boot](https://github.com/spring-projects/spring-boot) version 2.2.4.

## Build

Run `mvn clean package` creating jar file. Go to `<rootDir>/taraget`. There will be a jar file. Copy `application.properties`
and `application-prod.properties` files at `<rootDir>/src/main/resources` and paste them near the jar file.
Now you can run the server with command `java -jar <jar-file-name>.jar application.properties`.

## Configs

You can config `server.port` and `datasource` in `application-prod.properties`.
There are also some environmental variables you should config in `application.properties`
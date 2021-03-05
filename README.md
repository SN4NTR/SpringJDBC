# Spring JDBC Application

### Built With
* [Java 11](https://docs.oracle.com/en/java/javase/11/)
* [Spring Framework](https://spring.io/projects/spring-framework)

## Getting Started
### Prerequisites
1. Install Java 11
* Go to the [JDK 11 Download Page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html), download it and install.
* Make sure Java has been installed correctly, just open terminal and write the following line:
```shell script
java -version
```
2. Install [Maven](https://maven.apache.org/download.cgi)
3. Install [Docker](https://www.docker.com/products/docker-desktop)
4. Prepare your IDE (e.g. Intellij IDEA, Eclipse and so on)
5. Clone the repository
```shell script
git clone https://github.com/SN4NTR/SpringJDBC.git
```
6. Build the project
```shell script
mvn clean package
```

## Local Run
### Setup
1. Setup the *Run/Debug* configuration in IDE (e.g. [For Intellij IDEA](https://www.jetbrains.com/help/idea/spring-boot.html))
2. Start docker container with PostgreSQL Database by docker-compose:
```shell script
docker-compose up
```
3. Start the project
4. Open the http://localhost:8080/ in browser

### API

API can be tested using Postman collection from `postman` folder.
HTTP request example from Postman collection:
```
GET http://localhost:8080/cats - Get all cats
```

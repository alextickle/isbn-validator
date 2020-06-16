# isbn-validator
React frontend with Spring Boot backend

#### Run frontend and backend separately

##### Start frontend
```bash
cd isbn-cra
yarn install
yarn start
```
React app will run on port 3000

##### Start backend
```bash
mvn clean install -P !default-profile,backend-only
java -jar target/isbn-spring-boot-0.0.1-SNAPSHOT.jar
```
Spring Boot app will run on port 8080

#### Run backend with production frontend build
Used for heroku deployment
```bash
mvn clean install
java -jar target/isbn-spring-boot-0.0.1-SNAPSHOT.jar
```
React app will run on port 3000

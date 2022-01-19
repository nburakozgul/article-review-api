# article-review-api
Rest api example with Spring Boot and MySql

## Authentication
### Basic Auth

User : user

Password : password

## Resources

 - ```GET /articles``` - Retrieves a list of articles
 - ```GET /articles/12``` - Retrieves a specific articles
 - ```POST /articles``` - Creates a new articles
 - ```PUT /articles/12``` - Updates articles #12
 - ```DELETE /articles/12``` - Deletes articles #12


 - ```GET /reviews``` - Retrieves a list of reviews
 - ```GET /reviews/12``` - Retrieves a specific reviews
 - ```POST /reviews``` - Creates a new reviews
 - ```PUT /reviews/12``` - Updates reviews #12
 - ```DELETE /reviews/12``` - Deletes reviews #12

## Searching

 - ```GET /articles?field=value``` - Search with field name
 - ```GET /reviews?field=value``` - Search with field name

## Health

 - ```GET /actuator/health``` - Health Check
 
 More options found : https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints
 
 ## Docker

 Run :   ```mvn clean package -DskipTests``` in src dir
 
 Jar will be created under src/target copy that jar to src/main/docker
 
 Run : ```docker-compose up``` in src/main/docker

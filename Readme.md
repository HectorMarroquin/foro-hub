# Getting Started

### Guides
The following guides illustrate how to configure the project:

1. git clone [forohub](https://gitlab.com/HectorMarroquin/foro-hub-api.git)
2. Create Database
3. Create file with name "application-local.properties" in the same path
4. Install dependencies witch command `mvn clean install`
5. Add the next properties:

   - `spring.datasource.url=jdbc:mysql://localhost/yourdb`
   - `spring.datasource.username=yourname`
   - `spring.datasource.password=yourpassword`
   - `spring.jpa.hibernate.ddl-auto=update`
   - `spring.jpa.show-sql=true api.security.secret=${JWT_SECRET}`

 > El JWT_SECRET remplazarlo por cualquier palabra, si no se desea manejar veriables de entorno

6. Create record in the database table with your credential
7. Execute the project.


### Tecnologies Use

| Group ID                     | Artifact ID                               | Version   | Scope      | Optional |
|------------------------------|-------------------------------------------|-----------|------------|----------|
| org.springframework.boot     | spring-boot-starter-data-jpa             | -         | -          | -        |
| org.springframework.boot     | spring-boot-starter-security             | -         | -          | -        |
| org.springframework.boot     | spring-boot-starter-validation           | -         | -          | -        |
| org.springframework.boot     | spring-boot-starter-web                  | -         | -          | -        |
| org.flywaydb                 | flyway-core                              | -         | -          | -        |
| org.flywaydb                 | flyway-mysql                             | -         | -          | -        |
| org.springframework.boot     | spring-boot-devtools                     | -         | runtime    | true     |
| com.mysql                    | mysql-connector-j                        | -         | runtime    | -        |
| org.projectlombok            | lombok                                   | -         | -          | true     |
| org.springframework.boot     | spring-boot-starter-test                 | -         | test       | -        |
| org.springframework.security | spring-security-test                     | -         | test       | -        |
| org.springdoc                | springdoc-openapi-starter-webmvc-ui      | 2.8.3     | -          | -        |
| com.auth0                    | java-jwt                                 | 4.4.0     | -          | -        |

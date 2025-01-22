# Getting Started

### Guides
The following guides illustrate how to configure the project:

1. git clone [forohub](https://gitlab.com/HectorMarroquin/foro-hub-api.git)
2. Create Database
3. Create File with name "application-local.properties"
4. Fill file content with:

`
spring.datasource.url=jdbc:mysql://localhost/yourdb
spring.datasource.username=yourname
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
api.security.secret=${JWT_SECRET}
`
5. Create record in users, with your credentials
5. Install Maeven dependencies
6. Run Project.

### Tecnologies Use

* JDK 17
* Maven
* Spring boot 3.4.1
* Spring Security
* Spring web
* Spring boot devtools
* Mysql Driver
* Lombok
* Spring Data JPA
* Flyway Migration
* Bean Validations
* Spring Docs
* Auth0

# Spring Boot maven project
- uses spring-jdbc to connect to data base
- Exclude JdbcTemplateAutoConfiguration.class , DataSourceAutoConfiguration.class
- create beans of JDBCTemplate & DataSource in config class
- set up mysql RDBMS (server) & MySql workbench 8.0 as GUI
- add connection info in .properties file

### Prerequisites
- Java 17
- spring boot 3.5.4
- spring-boot-starter-data-jpa
-spring-boot-starter-jdbc
- mysql-connector-j 9.1.0
- IDE (Eclips)

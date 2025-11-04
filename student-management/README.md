# Spring-mvc maven project
- This is spring-mvc java-based configuration project 
- uses spring-jdbc to connect to data base
- apply Dao layer to contains any operations we want to apply on data inside DB
- create beans of JDBCTemplate & DataSource
- useing custom RowMapper(StudentRowMapper) & spring RowMapper(BeanPropertyRowMapper) to map rows from database to java objects

## Prerequisites
- Java 21
- spring-webmvc 6.2.9
- spring-jdbc 6.2.9
- jakarta.servlet-api 6.1.0
- mysql-connector-j 9.1.0
- jakarta.servlet.jsp.jstl  2.0.0
- IDE (Eclips)

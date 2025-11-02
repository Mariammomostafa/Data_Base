# JDBC project
- This is initial way to connect java project to mysql RDBMS(Relational Data Base Management System )
- uses standered 7 steps to connect to Data Base

  ### import the package java.sql
  ### load & register mysql driver
  ### stablish the connection
  ### create statement obj
  ### execute query
  ### process the result set
  ### close the Connection
  
- uses java.sql as specification & mysql connector-j (driver) as implementation
- apply Dao layer to separate the connection & any operations we want to apply on data inside DB
- set up mysql RDBMS (server) & MySql workbench 8.0 as GUI


 ### Prerequisites
- Java 8
- mysql-connector-j 9.3.0
- IDE (Eclips)

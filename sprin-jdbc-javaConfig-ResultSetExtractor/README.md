# Spring maven project
- This is java-based configuration project without using any xml files
- uses spring-jdbc to connect to data base
- apply Dao layer to contains any operations we want to apply on data inside DB
- create beans of JDBCTemplate & DataSource 
- set up mysql RDBMS (server) & MySql workbench 8.0 as GUI
- uses ResultSetExtractor interface to extracting results/records from ResultSet (convert each record to java object)

## CRUD operations : 
 - #### Update list of students using batchUpdate() method with 2 ways :
    - using batchUpdate(sql ,List<Object[]>) method
    - using batchUpdate(sql , BatchPreparedStatementSetter anonymous inner class ) method 
 - #### Insert
    - one student
    - list of students using batchUpdate() method 
 - #### Delete
   - by id
   - ByNameOrAddress
   - delete all
 - #### fetch
   - by id
   - by Name
   - group them based on their address

## Prerequisites
- Java 17
- spring-context 6.2.9
- spring-jdbc 6.2.9
- spring-tx 6.2.9
- mysql-connector-j 9.1.0
- IDE (Eclips)

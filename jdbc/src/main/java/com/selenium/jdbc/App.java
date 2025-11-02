package com.selenium.jdbc;

import java.sql.SQLException;



public class App 

{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        System.out.println( "Hello World!" );
        
  
            DaoLayer daoLayer = new DaoLayer();
            
            daoLayer.connection();
            daoLayer.getStudents();
     
    }
}

package com.selenium.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoLayer {

	Connection con= null ;
	
	public void connection() throws ClassNotFoundException, SQLException {
		
		 String url ="jdbc:mysql://localhost:3306/spring-jpa-hibernate";
	        String username ="root";
	        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url ,username , password);

	}
	
	public List<Student> getStudents() throws SQLException {
		
		List<Student> list = new ArrayList<>(); 
		
		String query = "select * from employee ";
	   Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(query);
        
        while (rs.next()) {
			
			Student stud = new Student();
			
			stud.setId(rs.getInt(1));
			stud.setMarks(rs.getInt(2));
			stud.setName(rs.getString(3));
			
			System.out.println(stud);
			
			list.add(stud);
		}
        
	   return list;
	   
	}
	
}

package com.selenium.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student s = new Student();
		
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setMobile(rs.getString("mobile"));
		s.setCountry(rs.getString("country"));
		
		return s;
	}

	
}

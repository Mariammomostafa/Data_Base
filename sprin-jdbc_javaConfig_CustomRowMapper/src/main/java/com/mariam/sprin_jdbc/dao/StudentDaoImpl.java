package com.mariam.sprin_jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mariam.sprin_jdbc.entity.Student;
import com.mariam.sprin_jdbc.mapper.StudentRowMapper;

@Repository
public class StudentDaoImpl implements StudentDao{

	
	@Autowired
	 private JdbcTemplate jdbcTemplate ; 
	 	 
	@Override
	public void insert(Student student) {
		
		String sql = "insert into student values(? ,? ,?)";
		Object[] args = {student.getId() , student.getName() , student.getAddress()};
		
		jdbcTemplate.update(sql,args);
		System.out.println("student saved successfully...");
	}

	//using custom RowMapper
	
	@Override
	public List<Student> findAllStudents() {

        String sql = "select * from student";
        List<Student> students= jdbcTemplate.query(sql , new StudentRowMapper());
        
		return students;
	}
 	
	@Override
	public int updateStudent(Student student) {
		
		String sql = "update student set name=? , address =? where id=?";
		Object[]args = {student.getName() ,student.getAddress() , student.getId()};
		
		int NoOfUpdatedCol=  jdbcTemplate.update(sql, args);
		
		return NoOfUpdatedCol;
	}

	@Override
	public boolean deletStudentById(int id) {
		
		String sql ="delete from student where id=?";
		int NoOfUpdatedCol= jdbcTemplate.update(sql , id);
		return NoOfUpdatedCol == 1;
	}
	
	@Override
	public boolean delete() {
		
		String sql ="delete from student ";
		int NoOfUpdatedCol= jdbcTemplate.update(sql);
		return NoOfUpdatedCol == 1;
	}


	@Override
	public int deleteBynameOrAddress(String name, String address) {
		
		String sql = "DELETE FROM student WHERE  name=? OR address=?";
		Object[] args= {name , address};
		
		int NoOfDeletedCols =	jdbcTemplate.update(sql , args);
		
	     System.out.println("No of deleted rows is : "+ NoOfDeletedCols);

		
		return NoOfDeletedCols;
	}

	@Override
	public void insert(List<Student> students) {
		
		List<Object[]> argsList = new ArrayList<>();
		
		String sql = "insert into student values(? ,? ,?)";
		
		for (Student student : students) {
			
			Object[] args = {student.getId() , student.getName() , student.getAddress()};
			argsList.add(args);
		}
		
	   jdbcTemplate.batchUpdate(sql, argsList);
	   
	   System.out.println(" batch of rows are  inserted successfully ....");
		
	}

	
	//using custom RowMapper
	
	@Override
	public Student findById(int id) {
		
		String sql ="select * from student where id =?";
		Student student=  jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}

	
}

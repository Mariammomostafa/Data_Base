package com.selenium.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.selenium.model.Student;
import com.selenium.model.StudentRowMapper;


@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> loadStudents() {
		
		String sql ="SELECT * FROM student_mvc_jdbc";
		List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
		
		return students;
	}

	@Override
	public void saveStudent(Student student) {
		
		String sql ="insert into student_mvc_jdbc (name , mobile , country) values(?,?,?)";
		Object[] args = {student.getName() , student.getMobile() , student.getCountry()};
		
		 int updateRow = jdbcTemplate.update(sql, args);
		 
		 System.out.println("Number of affected row is : " + updateRow);
	}

	@Override
	public List<Student> getStudent(int id) {
		
		String sql ="SELECT * FROM student_mvc_jdbc where id =?";

		List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), id );
		return studentList;
	}

	@Override
	public void updateStudent(Student student) {
		
		String sql ="update student_mvc_jdbc set name =? , mobile=? , country=? where id=?";
        Object[] args= {student.getName() , student.getMobile() , student.getCountry() ,student.getId()};
		int updateRow = jdbcTemplate.update(sql, args);
		
		 System.out.println("Number of affected row is : " + updateRow);

		
	}

	@Override
	public void deleteStudent(int id) {
		
		String sql = "delete from student_mvc_jdbc where id =?";
		int updateRow = jdbcTemplate.update(sql,id);
		
		 System.out.println("Number of deleted row is : " + updateRow);

	}

}

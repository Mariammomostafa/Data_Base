package com.mariam.sprin_jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mariam.sprin_jdbc.entity.Student;
import com.mariam.sprin_jdbc.mapper.CustomResultSetExtractor;
import com.mariam.sprin_jdbc.mapper.CustomResultSetExtractor_Student;
import com.mariam.sprin_jdbc.mapper.CustomResultSetExtractor_getByAddress;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(Student student) {

		String sql = "insert into student values(? ,? ,?)";
		Object[] args = { student.getId(), student.getName(), student.getAddress() };

		jdbcTemplate.update(sql, args);
		System.out.println("student saved successfully...");
	}

	// using CustomResultSetExtractor for return list of students
	@Override
	public List<Student> findAllStudents() {

		String sql = "select * from student ";
		List<Student> students = jdbcTemplate.query(sql, new CustomResultSetExtractor());

		return students;
	}

	// using CustomResultSetExtractor for return ONLY one student
	@Override
	public Student findById(int id) {

		String sql = "select * from student where id =?";
		Student student = jdbcTemplate.query(sql, new CustomResultSetExtractor_Student(), id);
		return student;
	}

	

	@Override
	public boolean deletStudentById(int id) {

		String sql = "delete from student where id=?";
		int NoOfUpdatedCol = jdbcTemplate.update(sql, id);
		return NoOfUpdatedCol == 1;
	}

	@Override
	public boolean delete() {

		String sql = "delete from student ";
		int NoOfUpdatedCol = jdbcTemplate.update(sql);
		return NoOfUpdatedCol == 1;
	}

	@Override
	public int deleteBynameOrAddress(String name, String address) {

		String sql = "DELETE FROM student WHERE  name=? OR address=?";
		Object[] args = { name, address };

		int NoOfDeletedCols = jdbcTemplate.update(sql, args);

		System.out.println("No of deleted rows is : " + NoOfDeletedCols);

		return NoOfDeletedCols;
	}

	@Override
	public void insert(List<Student> students) {

		List<Object[]> argsList = new ArrayList<>();

		String sql = "insert into student values(? ,? ,?)";

		for (Student student : students) {

			Object[] args = { student.getId(), student.getName(), student.getAddress() };
			argsList.add(args);
		}

		jdbcTemplate.batchUpdate(sql, argsList);

		System.out.println(" batch of rows are  inserted successfully ....");

	}

	@Override
	public List<Student> findStudentsByName(String name) {

		String sql = "select * from student where name =?";
		List<Student> students = jdbcTemplate.query(sql, new CustomResultSetExtractor(), name);

		System.out.println(students);

		return students;
	}

	@Override
	public Map<String, List<String>> getStudentNamesByAddress() {

		String sql = "select * from student ";
		Map<String, List<String>> map = jdbcTemplate.query(sql, new CustomResultSetExtractor_getByAddress());

		System.out.println(map.get("fayoum"));
		return map;
	}

	
	@Override
	public int updateStudent(Student student) {

		String sql = "update student set name=? , address =? where id=?";
		Object[] args = { student.getName(), student.getAddress(), student.getId() };

		int NoOfUpdatedCol = jdbcTemplate.update(sql, args);

		return NoOfUpdatedCol;
	}
	
	
	
	
	// update list of students using BatchPreparedStatementSetter anonymous inner class

	@Override
	public int updateStudentList(List<Student> list) {
		
		String sql = "update student set address =? where id=?";
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				ps.setString(1, list.get(i).getAddress());
				ps.setInt(2, list.get(i).getId());
			}
			
			@Override
			public int getBatchSize() {
				return list.size();
			}
		});

		
		return list.size();
	}
	
	
	// update list of students using batchUpdate() method
	
		@Override
		public int updateStudentList2(List<Student> list) {

			String sql = "update student set address =? where id=?";
			
			List<Object[]> argsList = new ArrayList<>();
			
			for(Student student : list) {
				
				Object[] args = { student.getAddress(), student.getId() };
				argsList.add(args);
			}

			int[] batchUpdate = jdbcTemplate.batchUpdate(sql, argsList);

			return batchUpdate.length;
		}

}

package com.mariam.sprin_jdbc.dao;

import java.util.List;
import java.util.Map;

import com.mariam.sprin_jdbc.entity.Student;

public interface StudentDao {
	
	void insert(Student student);
	
	Student findById(int id);
	
	List<Student> findAllStudents();
	
	int updateStudent(Student student);
	
	int updateStudentList(List<Student> list);
	
	boolean deletStudentById(int id);
	
	int deleteBynameOrAddress(String name , String address);
	
	void insert(List<Student> students);
	
	List<Student> findStudentsByName(String name);
	
	Map<String, List<String>> getStudentNamesByAddress();

	boolean delete();

	int updateStudentList2(List<Student> list);

}

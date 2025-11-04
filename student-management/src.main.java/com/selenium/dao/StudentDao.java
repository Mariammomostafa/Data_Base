package com.selenium.dao;

import java.util.List;

import com.selenium.model.Student;

public interface StudentDao {
	
	List<Student> loadStudents();
	
	void saveStudent(Student student);
	
    List<Student> getStudent(int id);

    void updateStudent(Student student);
    
    void deleteStudent(int id);

}

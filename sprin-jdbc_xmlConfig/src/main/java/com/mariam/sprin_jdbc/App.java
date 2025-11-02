package com.mariam.sprin_jdbc;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mariam.sprin_jdbc.dao.StudentDaoImpl;
import com.mariam.sprin_jdbc.entity.Student;
import com.mariam.sprin_jdbc.entity.StudentDaoHelper;

public class App {
	
	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		
		StudentDaoImpl studentDaoImpl = container.getBean("studentDao", StudentDaoImpl.class);
		
		StudentDaoHelper daoHelper = container.getBean("studentDaoHelper" ,StudentDaoHelper.class);

		System.out.println("*******************************");
		studentDaoImpl.deleteAllStudents();
		daoHelper.setStudentTable();
		
		System.out.println("*******************************");

		
		List<Student> students = studentDaoImpl.findAllStudents();

		for (Student s : students) {

			System.out.println(s.getId() + " - " + s.getName() + " - " + s.getAddress());
		}

		System.out.println("*******************************");

		System.out.println("*******************************");

		List<Student> students2 = studentDaoImpl.findStudentsByName("ganna");

		for (Student s : students2) {

			System.out.println(s.getId() + " - " + s.getName() + " - " + s.getAddress());
		}

		container.close();

	}

}

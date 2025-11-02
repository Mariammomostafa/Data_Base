package com.mariam.sprin_jdbc;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mariam.sprin_jdbc.dao.StudentDaoImpl;
import com.mariam.sprin_jdbc.entity.Student;
import com.mariam.sprin_jdbc.entity.StudentDaoHelper;

public class App 
{
	
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext applicationContext = 
        		
        		            new AnnotationConfigApplicationContext(AppConfig.class);
       
        StudentDaoImpl studentDaoImpl = applicationContext.getBean(StudentDaoImpl.class);
        StudentDaoHelper daoHelper = applicationContext.getBean(StudentDaoHelper.class);

        studentDaoImpl.delete();
        
        daoHelper.setStudentTable();
    	
        System.out.println("*******************************");
 
        Student student = studentDaoImpl.findById(3);
        
        System.out.println(student);
        
        System.out.println("*******************************");
        
        List<Student> students = studentDaoImpl.findAllStudents();
        
        for (Student s : students) {
        	
            System.out.println(s.getId() + " - " + s.getName() + " - " + s.getAddress());
		}
        
        System.out.println("*******************************");
         
    }
    
    
}

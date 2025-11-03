package com.mariam.sprin_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        System.out.println(" All Students");
       List<Student> students = studentDaoImpl.findAllStudents();
       
       for (Student s : students) {
       	
           System.out.println(s.getId() + " - " + s.getName() + " - " + s.getAddress());
		}
       
       Student s1 = students.get(0);
       s1.setAddress("Holanda");
       
       Student s2 = students.get(1);
       s2.setAddress("tanta");
       
       Student s3 = students.get(2);
       s3.setAddress("USA");
       
       
       List<Student> list = new ArrayList<>();
       list.add(s1);
       list.add(s2);
       list.add(s3);
       
        System.out.println("*******************************");
        
        System.out.println(" group Students based on their address ");
        
        Map<String, List<String>> map = studentDaoImpl.getStudentNamesByAddress();
        
        Set<String> set = map.keySet();
        
        for(String key : set) {
        	
        	System.out.println(key +" : "+ map.get(key));
        }
        
        System.out.println("*******************************");
        System.out.println(" Number of students have been updated using batchUpdate() method");
        
        int number = studentDaoImpl.updateStudentList2(list);
        System.out.println(" Number os updated Students is : "+ number);
        
        System.out.println("*******************************");
        System.out.println(" Number of students have been updated BatchPreparedStatementSetter anonymous inner class");
        
        int numberOfUpdatedStudent = studentDaoImpl.updateStudentList(list);
        System.out.println( " Number os updated Students is : "+ numberOfUpdatedStudent);

        
    }
    
    
}

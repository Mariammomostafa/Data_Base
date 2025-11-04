package com.selenium.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.selenium.dao.StudentDao;
import com.selenium.model.Student;
import com.selenium.model.StudentDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
	
	
	@GetMapping("/register")
	public String register(@ModelAttribute("dto") Student dto) {
		
		return "register";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "welcome";
	}


	@PostMapping("/process-registeration")
	public String process_register(@ModelAttribute("dto") Student student) {
			
		if(student.getId() == 0) {
			
			studentDao.saveStudent(student);
		}else {
			
			studentDao.updateStudent(student);
		}
	
	
		return "redirect:/welcome";
	}
	
	
	@GetMapping("/update")
	public String updateStudent(@RequestParam("userId") int id , Model model) {
			
	List<Student> student = studentDao.getStudent(id);
	model.addAttribute("dto", student.get(0));
	
		return "register";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("userId") int id ) {
			
	 studentDao.deleteStudent(id);
		
		return "redirect:/showStudents";
	}
	
	
	@GetMapping("/showStudents")
	public String showStudent(Model model) {
		
		List<Student> students = studentDao.loadStudents();
		
		for (Student student : students) {
			System.out.println(student);
		}
		model.addAttribute("studs",students);
		
		
		return "showStudentList";
	}
}

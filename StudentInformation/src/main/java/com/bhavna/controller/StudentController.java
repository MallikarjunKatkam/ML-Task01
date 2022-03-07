package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.CourseEntity;
import com.bhavna.model.StudentEntity;
import com.bhavna.service.StudentServiceI;

@RestController
public class StudentController {
	@Autowired
	private StudentServiceI studentService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome";
	}

	@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
	public List<CourseEntity> getAllStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping("/getStudentById/{studentId}")
	public StudentEntity getStudentById(@PathVariable Integer studentId) {
		return studentService.getStudentById(studentId);	
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody StudentEntity student) {
		 studentService.addStudent(student);
		 return "Student Details was added succefully";
	}
	
	@PutMapping("/updateStudent/{studentId}")
	public String updateStudent(@PathVariable int studentId,@RequestBody StudentEntity student) {
		 studentService.updateStudentById(studentId,student);
		 return "Student Details was updated succefully";
		
	}
}

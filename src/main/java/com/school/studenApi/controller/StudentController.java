package com.school.studenApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.studenApi.model.Student;
import com.school.studenApi.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/api/student")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@PostMapping("/api/student")
	public String addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}
	
	@GetMapping("/api/student/{id}")
	public Optional<Student> findStudentById(@PathVariable Long id) {
		return studentService.findStudentById(id);
	}
	
	@PutMapping("/api/student/{id}")
	public String updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
		return studentService.updateStudent(id, updatedStudent);
	}
	
	@DeleteMapping("/api/student/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
	
		
}

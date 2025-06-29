package com.school.studenApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.studenApi.dto.MarksSheetDTO;
import com.school.studenApi.model.Student;
import com.school.studenApi.model.Subject;
import com.school.studenApi.service.MarksSheetService;
import com.school.studenApi.service.StudentService;
import com.school.studenApi.service.SubjectService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private MarksSheetService marksSheetService;
	
	@GetMapping("/home")
	public String homePage(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "home";
	}
	
	@GetMapping("/editStudent/{id}")
	public String editStudent (@PathVariable Long id,Model model) {
		Optional<Student> optionalStudent = studentService.findStudentById(id);
		if(optionalStudent.isPresent()) {
			Student student = optionalStudent.get();
		model.addAttribute("student",student);
		return "editStudent";
		}else {
			return "redirect:/error";
		}
	}
	
	@GetMapping("/subjectList")
	public String subjectList (Model model) {
		List<Subject> subject = subjectService.getAllSubjects();
		model.addAttribute("subjects", subject);
		return "subjectList";
	}
	
	@GetMapping("/addNewStudent")
	public String addNewStudent() {
		return "addNewStudent";
	}
	
	@GetMapping("/viewMarks/{studentId}")
	public String viewMarks(@PathVariable Long studentId, Model model) {
		List<MarksSheetDTO> marksSheets = marksSheetService.getMarksForStudent(studentId);

		Optional<Student> optionalStudent = studentService.findStudentById(studentId);
		List <Subject> subject = marksSheetService.getAllSubject();
		
			
			if(marksSheets.isEmpty()) {
				System.out.println("marksSheets is empty "+marksSheets);
				if(optionalStudent.isPresent()) {
					Student student = optionalStudent.get();
				model.addAttribute("student",student);
				model.addAttribute("subjects",subject);
				}
				return "addMarks";
			}else {
				model.addAttribute("marksSheets", marksSheets);
				return "viewMarks";
			}
			
		
	}

}

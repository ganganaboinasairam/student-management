package com.school.studenApi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.studenApi.dto.MarksSheetDTO;
import com.school.studenApi.model.Subject;
import com.school.studenApi.service.MarksSheetService;

@RestController
@RequestMapping("/api/markSheet/")
public class MarksSheetController {
	@Autowired
	private MarksSheetService marksSheetService;
	
	
	@PostMapping("/addMarks")
	public String createMarksSheet(@RequestBody List<MarksSheetDTO> request) {

		return marksSheetService.createMarksSheet(request);
    }
	
	@PutMapping("/updateMarks")
	public String updateMarksSheet(@RequestBody List<MarksSheetDTO> request) {

		return marksSheetService.updateMarksSheet(request);
    }
	
	@GetMapping("getMarks/{studentId}")
	public List<MarksSheetDTO> getMarksForStudent(@PathVariable Long studentId){
		return  marksSheetService.getMarksForStudent(studentId);
	}
	
	@GetMapping("getSubjects")
	public List<Subject> getAllSubject(){
		return marksSheetService.getAllSubject();
	}
	
	@DeleteMapping("deleteMarks/{studentId}")
	public String deletemarksSheet(@PathVariable Long studentId) {
		return marksSheetService.deletemarksSheet(studentId);
	}
	
}

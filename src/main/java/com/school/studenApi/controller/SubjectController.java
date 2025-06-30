package com.school.studenApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.studenApi.model.Subject;
import com.school.studenApi.service.SubjectService;

@RestController
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@PostMapping("/api/addSubject")
	public String addStudent(@RequestBody Subject subject){
		return subjectService.addSubject(subject);
	}

}

package com.school.studenApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.studenApi.model.Subject;
import com.school.studenApi.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	 public List<Subject> getAllSubjects() {
	        return subjectRepository.findAll();
	    }
	 
	 public String addSubject(Subject subject) {
		 try {
			subjectRepository.save(subject);
			 return "Subject added successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Somthing went wrong, subject is not added";
		}
	 }
	
	

}

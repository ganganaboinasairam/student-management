package com.school.studenApi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq")
	@SequenceGenerator(name = "subject_seq", sequenceName = "SUBJECT_SEQ", allocationSize = 1)
	private Long subjectId;
	
	private String subjectName;
	
	@OneToMany(mappedBy = "subject")
	private List<MarksSheet> marksSheet;
	
	public Subject() {}
	
	public Subject (Long subjectId, List<MarksSheet> marksSheet, String subjectName) {
		this.subjectId = subjectId;
		this.marksSheet = marksSheet;
		this.subjectName = subjectName;
				
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<MarksSheet> getMarksSheet() {
		return marksSheet;
	}

	public void setMarksSheet(List<MarksSheet> marksSheet) {
		this.marksSheet = marksSheet;
	}
	
	
	
	
	

}

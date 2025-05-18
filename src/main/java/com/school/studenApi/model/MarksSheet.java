package com.school.studenApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class MarksSheet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marks_seq")
	@SequenceGenerator(name = "marks_seq", sequenceName = "MARKS_SEQ", allocationSize = 1)
	private Long marks_id;
	
	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "subjectId")
	private Subject subject;
	
	private int marks;
	
	public MarksSheet() {}
	
	public MarksSheet(Long marks_id,Subject subject,int marks, Student student) {
		this.marks_id = marks_id;
		this.subject = subject;
		this.marks = marks;
		this.student = student;
	}

	public Long getId() {
		return marks_id;
	}

	public void setId(Long id) {
		this.marks_id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	
	
}

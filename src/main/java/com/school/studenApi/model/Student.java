package com.school.studenApi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	@SequenceGenerator(name = "student_seq", sequenceName = "STUDENT_SEQ", allocationSize = 1)
	private Long studentId;
	private String name;
	private String email;
	private String dept;
	private Long phone;
	
	

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public List<MarksSheet> getMarksSheet() {
		return marksSheet;
	}

	public void setMarksSheet(List<MarksSheet> marksSheet) {
		this.marksSheet = marksSheet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student() {}
	
	public Student ( Long studentId, String name, String email, String dept, Long phone) {
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.phone = phone;
	}
	
	@OneToMany(mappedBy = "student")
    private List<MarksSheet> marksSheet;

	public List<MarksSheet> getMarkssheet() {
		return marksSheet;
	}

	public void setMarkssheet(List<MarksSheet> markssheet) {
		this.marksSheet = markssheet;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	

}

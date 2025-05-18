package com.school.studenApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.studenApi.model.Student;
import com.school.studenApi.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	 // Get All Users
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

	public String addStudent(Student student) {
		try {
			studentRepository.save(student);
			return "Student added Sucessfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Somthing went wrong ,Student is not added";
		}
	}

	public Optional<Student> findStudentById(Long studentId) {
		return studentRepository.findById(studentId);
	}

	public String updateStudent(Long studentId, Student updatedStudent) {
		try {
			Student existingStudent = studentRepository.findById(studentId)
			.orElseThrow( () -> new RuntimeException("Student not exists with id "+ studentId));
			
			existingStudent.setName(updatedStudent.getName());
			existingStudent.setEmail(updatedStudent.getEmail());
			existingStudent.setDept(updatedStudent.getDept());
			existingStudent.setPhone(updatedStudent.getPhone());
			// TODO Auto-generated method stub
			studentRepository.save(existingStudent);
			return "Student updated Sucessfully for id :"+studentId;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			return "Student is not found with id: "+studentId;

		}
	}

	public String deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		try {
			Student existingStudent = studentRepository.findById(studentId)
					.orElseThrow(() -> new RuntimeException("Student is not found with id: "+studentId));
			
			studentRepository.deleteById(existingStudent.getStudentId());
			return "Student record Deleted Sucessfully";
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Student is not found with id: "+studentId;
		}
	}
}

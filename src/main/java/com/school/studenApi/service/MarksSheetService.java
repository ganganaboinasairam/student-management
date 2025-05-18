package com.school.studenApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.studenApi.dto.MarksSheetDTO;
import com.school.studenApi.model.MarksSheet;
import com.school.studenApi.model.Student;
import com.school.studenApi.model.Subject;
import com.school.studenApi.repository.MarksSheetRepository;
import com.school.studenApi.repository.StudentRepository;
import com.school.studenApi.repository.SubjectRepository;

@Service
public class MarksSheetService {
	@Autowired
	private MarksSheetRepository marksSheetRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<MarksSheetDTO> getMarksForStudent(Long studentId){
		List<MarksSheet> marksSheets = marksSheetRepository.findByStudentStudentId(studentId);
		return marksSheets.stream()
				.map(marksSheet -> new MarksSheetDTO(
						marksSheet.getId(),
						marksSheet.getMarks(),
						marksSheet.getStudent().getStudentId(),
						marksSheet.getStudent().getName(),
						marksSheet.getSubject().getSubjectId(),
						marksSheet.getSubject().getSubjectName()
						))
				.collect(Collectors.toList());
	}
	
	public String createMarksSheet(List<MarksSheetDTO> requestList) {
		
		for (MarksSheetDTO request : requestList) {
        // 1. Fetch Student
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // 2. Fetch Subject
        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        
        Boolean exists = marksSheetRepository.existsByStudentAndSubject(student,subject);
        
        if(exists) {
            throw new RuntimeException("Marks for student " + student.getName() + " and subject " + subject.getSubjectName() + " already exist.");
        }

        // 3. Create new MarksSheet
        MarksSheet marksSheet = new MarksSheet();
        marksSheet.setMarks(request.getMarks());
        marksSheet.setStudent(student);
        marksSheet.setSubject(subject);

        // 4. Save and return

		marksSheetRepository.save(marksSheet);
		}
        return "Marks Record inserted sucessfully";
    }

	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	public String updateMarksSheet(List<MarksSheetDTO> requestList) {
		// TODO Auto-generated method stub
		for (MarksSheetDTO request : requestList) {
			
			// 1. Fetch Student
	        Student student = studentRepository.findById(request.getStudentId())
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        // 2. Fetch Subject
	        Subject subject = subjectRepository.findById(request.getSubjectId())
	                .orElseThrow(() -> new RuntimeException("Subject not found"));
			// 3. Create new MarksSheet
	        MarksSheet marksSheet = new MarksSheet();
	        marksSheet.setMarks(request.getMarks());
	        marksSheet.setStudent(student);
	        marksSheet.setSubject(subject);

	        // 4. Save and return

			marksSheetRepository.save(marksSheet);
			}
	        return "Marks Record updated sucessfully";
	}

	public String deletemarksSheet(Long studentId) {
		// TODO Auto-generated method stub
		marksSheetRepository.deleteById(studentId);
		return null;
	}

}

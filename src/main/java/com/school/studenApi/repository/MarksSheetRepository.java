package com.school.studenApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.studenApi.model.MarksSheet;
import com.school.studenApi.model.Student;
import com.school.studenApi.model.Subject;

@Repository
public interface MarksSheetRepository extends JpaRepository<MarksSheet, Long>{
	
	List<MarksSheet> findByStudentStudentId(Long studentId);


    // Custom query to check if a MarksSheet already exists for the student and subject
    @Query("SELECT CASE WHEN COUNT(ms) > 0 THEN true ELSE false END FROM MarksSheet ms WHERE ms.student = :student AND ms.subject = :subject")
    boolean existsByStudentAndSubject(@Param("student") Student student, @Param("subject") Subject subject);
}

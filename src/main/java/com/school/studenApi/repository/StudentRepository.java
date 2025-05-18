package com.school.studenApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.studenApi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}

package com.school.studenApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.studenApi.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}

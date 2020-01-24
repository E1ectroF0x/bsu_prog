package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.SubjectTeacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTeacherRepository extends CrudRepository<SubjectTeacher, Long> {
}

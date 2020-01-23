package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.LessonTeacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonTeacherRepository extends CrudRepository<LessonTeacher, Long> {
}

package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.StudentLesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLessonRepository extends CrudRepository<StudentLesson, Long> {
}

package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.LessonDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDateRepository extends CrudRepository<LessonDate, Long> {
}

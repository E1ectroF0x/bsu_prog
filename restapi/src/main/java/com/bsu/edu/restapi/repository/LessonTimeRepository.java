package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.LessonTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonTimeRepository extends CrudRepository<LessonTime, Long> {
}

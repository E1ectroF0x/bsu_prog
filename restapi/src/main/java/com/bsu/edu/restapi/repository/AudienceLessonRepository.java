package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.AudienceLesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudienceLessonRepository extends CrudRepository<AudienceLesson, Long> {
}

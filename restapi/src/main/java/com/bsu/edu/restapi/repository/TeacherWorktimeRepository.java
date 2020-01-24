package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.TeacherWorktime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherWorktimeRepository extends CrudRepository<TeacherWorktime, Long> {
}

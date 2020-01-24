package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.AudienceFaculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudienceFacultyRepository extends CrudRepository<AudienceFaculty, Long> {
}

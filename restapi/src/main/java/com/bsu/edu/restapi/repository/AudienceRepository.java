package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.Audience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudienceRepository extends CrudRepository<Audience, Long> {
}

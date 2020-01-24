package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.SubjectGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectGroupRepository extends CrudRepository<SubjectGroup, Long> {
}

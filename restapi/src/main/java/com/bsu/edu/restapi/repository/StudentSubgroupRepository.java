package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.StudentSubgroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSubgroupRepository extends CrudRepository<StudentSubgroup, Long> {
}

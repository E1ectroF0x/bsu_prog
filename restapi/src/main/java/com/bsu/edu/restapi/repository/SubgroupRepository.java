package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.Subgroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubgroupRepository extends CrudRepository<Subgroup, Long> {
}

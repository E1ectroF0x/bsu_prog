package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.SubGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubgroupRepository extends CrudRepository<SubGroup, Long> {
}

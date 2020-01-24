package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.BuildingWorktime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingWorktimeRepository extends CrudRepository<BuildingWorktime, Long> {
}

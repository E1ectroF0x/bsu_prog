package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}

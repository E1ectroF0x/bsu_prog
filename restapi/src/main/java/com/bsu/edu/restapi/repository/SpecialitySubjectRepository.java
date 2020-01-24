package com.bsu.edu.restapi.repository;

import com.bsu.edu.restapi.entity.SpecialitySubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialitySubjectRepository extends CrudRepository<SpecialitySubject, Long> {
}

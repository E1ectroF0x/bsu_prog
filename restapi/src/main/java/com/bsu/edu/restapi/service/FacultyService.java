package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.FacultyDTO;
import com.bsu.edu.restapi.entity.Faculty;

public interface FacultyService {

    public FacultyDTO getFacultyById(Long id);
    public Faculty getFacultyByName(String name);

}

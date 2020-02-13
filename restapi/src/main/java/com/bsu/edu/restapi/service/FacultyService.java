package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.FacultyDTO;
import com.bsu.edu.restapi.entity.Faculty;

import java.util.List;

public interface FacultyService {

    public FacultyDTO getFacultyById(Long id);
    public Faculty getFacultyByName(String name);
    public List<FacultyDTO> getAll();

}

package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.SpecialityDTO;

import java.util.List;

public interface SpecialityService {

    public SpecialityDTO findById(Long id);
    public List<SpecialityDTO> getAllSpecialitiesByFacultyName(String name);
}

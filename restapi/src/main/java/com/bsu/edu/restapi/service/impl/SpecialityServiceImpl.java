package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.SpecialityDTO;
import com.bsu.edu.restapi.entity.Speciality;
import com.bsu.edu.restapi.repository.SpecialityRepository;
import com.bsu.edu.restapi.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public SpecialityDTO findById(Long id) {
        return null;
    }

    private SpecialityDTO convert(Speciality speciality) {
        return null;
    }
}

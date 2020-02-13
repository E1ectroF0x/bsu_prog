package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.DepartmentDTO;
import com.bsu.edu.restapi.DTO.FacultyDTO;
import com.bsu.edu.restapi.entity.Department;
import com.bsu.edu.restapi.entity.Faculty;
import com.bsu.edu.restapi.repository.FacultyRepository;
import com.bsu.edu.restapi.service.BuildingService;
import com.bsu.edu.restapi.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private BuildingService buildingService;

    @Override
    public FacultyDTO getFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id).orElse(null);
        return convert(faculty);
    }

    @Override
    public Faculty getFacultyByName(String name) {
        List<Faculty> faculties = (List<Faculty>) facultyRepository.findAll();
        return faculties.stream().filter(faculty -> faculty.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<FacultyDTO> getAll() {
        List<Faculty> faculties = (List<Faculty>) facultyRepository.findAll();
        List<FacultyDTO> _faculties = new ArrayList<>();
        faculties.forEach(faculty -> _faculties.add(convert(faculty)));
        return _faculties;
    }

    private FacultyDTO convert(Faculty faculty) {
        if (faculty == null) {
            return null;
        }
        return new FacultyDTO(faculty.getName(),
                buildingService.getBuildingById(faculty.getBuilding_id()).getAddress());
    }

}

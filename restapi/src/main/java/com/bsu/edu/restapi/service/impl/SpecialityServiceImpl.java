package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.FacultyDTO;
import com.bsu.edu.restapi.DTO.SpecialityDTO;
import com.bsu.edu.restapi.entity.Building;
import com.bsu.edu.restapi.entity.Faculty;
import com.bsu.edu.restapi.entity.Speciality;
import com.bsu.edu.restapi.repository.BuildingRepository;
import com.bsu.edu.restapi.repository.FacultyRepository;
import com.bsu.edu.restapi.repository.SpecialityRepository;
import com.bsu.edu.restapi.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public SpecialityDTO findById(Long id) {
        return null;
    }

    @Override
    public List<SpecialityDTO> getAllSpecialitiesByFacultyName(String name) {
        List<Faculty> faculties = (List<Faculty>) facultyRepository.findAll();
        List<Speciality> specialities = (List<Speciality>) specialityRepository.findAll();
        List<SpecialityDTO> specialityDTOS = new ArrayList<>();
        Faculty _faculty = faculties.stream().filter(faculty -> faculty.getName().equals(name)).findFirst().orElse(null);
        specialities.stream().filter(speciality -> speciality.getFaculty_id().equals(_faculty.getId()))
                .forEach(speciality -> specialityDTOS.add(convert(speciality)));
        return specialityDTOS;
    }

    private SpecialityDTO convert(Speciality model) {

        SpecialityDTO specialityDTO = new SpecialityDTO();
        Faculty faculty = facultyRepository.findById(model.getFaculty_id()).orElse(null);
        Building building = buildingRepository.findById(faculty.getBuilding_id()).orElse(null);

        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setName(faculty.getName());
        facultyDTO.setBuildingAddress(building.getAddress());

        specialityDTO.setFaculty(facultyDTO);
        specialityDTO.setName(model.getName());

        return specialityDTO;
    }
}

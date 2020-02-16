package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.DepartmentDTO;
import com.bsu.edu.restapi.entity.Department;
import com.bsu.edu.restapi.repository.DepartmentRepository;
import com.bsu.edu.restapi.service.DepartmentService;
import com.bsu.edu.restapi.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyService facultyService;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>(Collections.emptyList());
        departments.forEach(department -> departmentDTOs.add(convert(department)));
        return departmentDTOs;
    }

    @Override
    public List<DepartmentDTO> getAllDepartmentsByFaculty(String facultyName) {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>(Collections.emptyList());
        departments.stream().filter(department ->
                facultyName.equals(facultyService.getFacultyById(department.getFaculty_id()).getName()))
                .forEach(department -> departmentDTOs.add(convert(department)));
        return departmentDTOs;
    }

    @Override
    public void saveDepartment(DepartmentDTO model) {
        departmentRepository.save(new Department(model.getName(),
                facultyService.getFacultyByName(model.getFacultyName()).getId()));
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElse(new Department());
        return convert(department);
    }

    @Override
    public Department getDepartmentByName(String name) {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        return departments.stream().filter(item -> item.getName().equals(name)).findFirst().orElse(new Department());
    }

    private DepartmentDTO convert(Department department) {
        if (department == null) {
            return null;
        }
        return new DepartmentDTO(department.getName(),
                facultyService.getFacultyById(department.getFaculty_id()).getName());
    }
}

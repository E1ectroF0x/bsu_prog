package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.DepartmentDTO;
import com.bsu.edu.restapi.entity.Department;

import java.util.List;

public interface DepartmentService {

    public List<DepartmentDTO> getAllDepartments();
    public List<DepartmentDTO> getAllDepartmentsByFaculty(String facultyName);
    public void saveDepartment(DepartmentDTO model);
    public DepartmentDTO getDepartmentById(Long id);
    public Department getDepartmentByName(String name);
}

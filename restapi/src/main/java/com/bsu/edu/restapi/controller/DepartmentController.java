package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.DTO.DepartmentDTO;
import com.bsu.edu.restapi.entity.Department;
import com.bsu.edu.restapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/{id}")
    public DepartmentDTO getById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping(value = "/all")
    public List<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping(value = "/all/{faculty}")
    public List<DepartmentDTO> getAllDepartmentsByFaculty(@PathVariable String faculty){
        return  departmentService.getAllDepartmentsByFaculty(faculty);
    }

    //??
   /* @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
    }*/

    @PostMapping
    public void save(@RequestBody DepartmentDTO department){
        departmentService.saveDepartment(department);
    }


}

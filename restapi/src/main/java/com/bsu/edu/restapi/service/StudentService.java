package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.GroupDTO;
import com.bsu.edu.restapi.DTO.StudentDTO;

import java.util.List;

public interface StudentService {

    public List<StudentDTO> getStudentsByGroup(GroupDTO group);
    public void saveStudent(StudentDTO model);

}

package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.TeacherDTO;
import com.bsu.edu.restapi.entity.Teacher;

import java.util.List;

public interface TeacherService {

    //public TeacherDTO getTeacherById(Long id);
    //public TeacherDTO getTeacherByFIO(TeacherDTO model);
    public List<TeacherDTO> getAllTeachers();
    public void saveTeacher(TeacherDTO teacher);
    //public void deleteTeacherById(Long id);
    public void deleteTeacher(TeacherDTO model);

}

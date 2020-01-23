package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.entity.Teacher;

import java.util.List;

public interface TeacherService {

    public Teacher getTeacherById(Long id);
    public List<Teacher> getAllTeachers();
    public void saveTeacher(Teacher teacher);
    public void deleteTeacherById(Long id);

}

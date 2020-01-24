package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.entity.Teacher;
import com.bsu.edu.restapi.entity.User;
import com.bsu.edu.restapi.repository.TeacherRepository;
import com.bsu.edu.restapi.service.TeacherService;
import com.bsu.edu.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserService userService;

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacher.setUser_id(27L);
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }
}

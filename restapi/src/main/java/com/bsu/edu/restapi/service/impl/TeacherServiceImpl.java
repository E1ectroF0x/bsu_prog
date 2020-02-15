package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.TeacherDTO;
import com.bsu.edu.restapi.entity.Teacher;
import com.bsu.edu.restapi.entity.User;
import com.bsu.edu.restapi.repository.TeacherRepository;
import com.bsu.edu.restapi.service.DepartmentService;
import com.bsu.edu.restapi.service.TeacherService;
import com.bsu.edu.restapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private Teacher teacher = null;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    public TeacherServiceImpl() {
        this.teacher = new Teacher();
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findAll();
        List<TeacherDTO> teacherModels = new java.util.ArrayList<>(Collections.emptyList());
        teachers.forEach(teacher -> teacherModels.
                        add(new TeacherDTO(teacher.getName(), teacher.getSurname(), teacher.getFathername(),
                                teacher.getBirthdate(),
                                departmentService.getDepartmentById(teacher.getDepartment_id()).getName())));
        return teacherModels;
    }

    @Override
    public void saveTeacher(TeacherDTO model) {
        String username = "rct." + model.getSecondName() + model.getName().substring(0, 1).toUpperCase()
                + model.getLastName().substring(0, 1).toUpperCase();

        // TODO: make password generation
        User savedUser = userService.saveUser(new User(username,"1111111", null, 10, null,""));
        this.teacher.setName(model.getName());
        this.teacher.setSurname(model.getSecondName());
        this.teacher.setFathername(model.getLastName());
        this.teacher.setBirthdate(model.getBirthday());
        this.teacher.setDepartment_id(departmentService.getDepartmentByName(model.getDepartmentName()).getId());
        this.teacher.setUser_id(savedUser.getId());
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(TeacherDTO model) {
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findAll();
        Teacher _teacher = teachers.stream()
                .filter(teacher -> (teacher.getName().equals(model.getName())
                    && teacher.getSurname().equals(model.getLastName())
                    && teacher.getFathername().equals(model.getSecondName())))
                .findFirst().orElse(null);
        if (_teacher != null) {
            teacherRepository.delete(_teacher);
            userService.deleteUserById(_teacher.getUser_id());
        }
    }
}

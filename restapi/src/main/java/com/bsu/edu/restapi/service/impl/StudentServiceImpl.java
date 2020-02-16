package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.GroupDTO;
import com.bsu.edu.restapi.DTO.StudentDTO;
import com.bsu.edu.restapi.entity.Student;
import com.bsu.edu.restapi.entity.User;
import com.bsu.edu.restapi.repository.StudentRepository;
import com.bsu.edu.restapi.service.GroupService;
import com.bsu.edu.restapi.service.StudentService;
import com.bsu.edu.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private Student student = null;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GroupService groupService;

    @Autowired
    UserService userService;

    public StudentServiceImpl() {
        this.student = new Student();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = (List<Student>) studentRepository.findAll();
        List<StudentDTO> _students = new ArrayList<>();
        students.forEach(student -> _students.add(convert(student)));
        return _students;
    }

    @Override
    public List<StudentDTO> getStudentsByGroup(GroupDTO group) {
        List<Student> students = (List<Student>) studentRepository.findAll();
        List<StudentDTO> _students = new ArrayList<>();
        students.stream().filter(student -> student.getGroup_id().equals(groupService.getGroupByDTO(group).getId()))
                .forEach(student -> _students.add(convert(student)));
        return _students;
    }

    @Override
    public void saveStudent(StudentDTO model) {
        String username = "rct." + model.getSecondName() + model.getName().substring(0, 1).toUpperCase()
                + model.getLastName().substring(0, 1).toUpperCase();
        User savedUser = userService.saveUser(new User(username,"1111111", null, 10, null, ""));
        this.student.setName(model.getName());
        this.student.setSurname(model.getSecondName());
        this.student.setFathername(model.getLastName());
        this.student.setAddress(model.getAddress());
        this.student.setEmail(model.getEmail());
        this.student.setTicket_num(model.getTicketNumber());
        this.student.setCourse(model.getCourse());
        this.student.setForm(model.getForm());
        this.student.setBirthdate(model.getBirthday());
        this.student.setGroup_id(groupService.getGroupByDTO(model.getGroup()).getId());
        this.student.setUser_id(savedUser.getId());
        this.studentRepository.save(this.student);
    }

    private StudentDTO convert(Student student) {
        return new StudentDTO(student.getName(), student.getFathername(), student.getSurname(),
                        student.getAddress(), student.getEmail(), student.getTicket_num(),
                student.getCourse(), student.getForm(), student.getBirthdate(), groupService.getGroupById(student.getGroup_id()));
    }
}

package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.IOSStudentDTO;
import com.bsu.edu.restapi.DTO.LoginDTO;
import com.bsu.edu.restapi.DTO.StudentDTO;
import com.bsu.edu.restapi.entity.*;
import com.bsu.edu.restapi.repository.*;
import com.bsu.edu.restapi.service.IOSStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOSStudentServiceImpl implements IOSStudentService {

    Student student = null;

    public IOSStudentServiceImpl(){
        this.student = new Student();
    }

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public IOSStudentDTO getStudent(LoginDTO model) {
        List<User> users = (List<User>) userRepository.findAll();
        User _user = users.stream().filter(user -> model.getLogin().equals(user.getUsername())
                                            && model.getPassword().equals(user.getPassword_hash()))
                                                .findFirst().orElse(null);
        Student _student = studentRepository.findById(_user.getId()).orElse(null);
        Group _group = groupRepository.findById(_student.getGroup_id()).orElse(null);
        Speciality _speciality = specialityRepository.findById(_group.getSpeciality_id()).orElse(null);
        Faculty _faculty = facultyRepository.findById(_speciality.getFaculty_id()).orElse(null);
        IOSStudentDTO iosStudentDTO = new IOSStudentDTO();
        iosStudentDTO.setFaculty(_faculty.getName());
        iosStudentDTO.setSpeciality(_speciality.getName());
        iosStudentDTO.setCourse(String.valueOf(_student.getCourse()));
        iosStudentDTO.setGroup_number(_group.getNumber_group());
        iosStudentDTO.setForm(_student.getGroup_id() == 1 ? ("Бюджет") : ("Платное"));
        iosStudentDTO.setEmail(_student.getEmail());
        iosStudentDTO.setAddress(_student.getAddress());
        iosStudentDTO.setName(_student.getName());
        iosStudentDTO.setFathername(_student.getFathername());
        iosStudentDTO.setSurname(_student.getSurname());
        iosStudentDTO.setImage(_user.getImage());
        return iosStudentDTO;
    }
}

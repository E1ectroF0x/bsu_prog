package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.entity.Group;
import com.bsu.edu.restapi.entity.Subject;

import java.util.List;

public interface SubjectService {
    public Subject getSubjectById(Long id);
    public Group getSubjectByName(String name);
    public List<Subject> getAllSubjects();
    public void saveSubject(Subject subject);
    public void deleteSubjectById(Long id);
}

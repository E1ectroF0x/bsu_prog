package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.GroupDTO;
import com.bsu.edu.restapi.DTO.LessonDTO;

import java.util.List;

public interface LessonService {

    public List<LessonDTO> getLessonByGroup(GroupDTO group);
    public void saveLesson(LessonDTO model);

    /*
    public Lesson getLessonById(Long id);
    public List<Lesson> getAllLessons();
    public void saveLesson(Lesson lesson);
    public void deleteLessonById(Long id);
    */
}

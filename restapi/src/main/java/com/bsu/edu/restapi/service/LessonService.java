package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.entity.Lesson;

import java.util.List;

public interface LessonService {

    public Lesson getLessonById(Long id);
    public List<Lesson> getAllLessons();
    public void saveLesson(Lesson lesson);
    public void deleteLessonById(Long id);

}

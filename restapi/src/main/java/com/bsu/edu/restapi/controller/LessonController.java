package com.bsu.edu.restapi.controller;


import com.bsu.edu.restapi.entity.Lesson;
import com.bsu.edu.restapi.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping(value = "/all")
    public List<Lesson> getAll() {
        return lessonService.getAllLessons();
    }
//+
    @GetMapping(value = "/{id}")
    public Lesson get(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        lessonService.deleteLessonById(id);
    }

    @PostMapping
    public void save(@RequestBody Lesson lesson) {
        lessonService.saveLesson(lesson);
    }

}

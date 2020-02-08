package com.bsu.edu.restapi.controller;


import com.bsu.edu.restapi.DTO.GroupDTO;
import com.bsu.edu.restapi.DTO.LessonDTO;
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

    @GetMapping
    public List<LessonDTO> getLessonByGroup(@RequestBody GroupDTO group){
        return lessonService.getLessonByGroup(group);
    }

    @PostMapping
    public void save(@RequestBody LessonDTO lesson ){
        lessonService.saveLesson(lesson);
    }

    @DeleteMapping
    public void delete(@RequestBody LessonDTO lesson){
        lessonService.deleteLesson(lesson);
    }
}

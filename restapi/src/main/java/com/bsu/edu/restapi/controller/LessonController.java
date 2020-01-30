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



}

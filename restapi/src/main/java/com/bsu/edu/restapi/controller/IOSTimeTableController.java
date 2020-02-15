package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.DTO.IOSDTO;
import com.bsu.edu.restapi.service.IOSTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/timetable")
public class IOSTimeTableController {

    @Autowired
    private IOSTimeTableService iosTimeTableService;

    @GetMapping(value = "/{month}")
    public List<IOSDTO> getTimeTable(@PathVariable int month) {
        return iosTimeTableService.getAllLessonsByMonth(month);
    }

}

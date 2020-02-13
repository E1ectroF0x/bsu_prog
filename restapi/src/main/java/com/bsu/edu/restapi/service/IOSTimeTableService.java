package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.IOSLessons;

import java.util.List;

public interface IOSTimeTableService {

    public List<IOSLessons> getAllLessonsByMonth(int month);
}

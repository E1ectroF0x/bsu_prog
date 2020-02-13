package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.IOSDTO;

import java.util.List;

public interface IOSTimeTableService {

    public List<IOSDTO> getAllLessonsByMonth(int month);
}

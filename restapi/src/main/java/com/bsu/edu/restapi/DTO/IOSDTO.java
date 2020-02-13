package com.bsu.edu.restapi.DTO;

import java.util.List;

public class IOSDTO {

    private int day;
    private List<IOSLesson> lessons;

    public IOSDTO() { }

    public IOSDTO(int day, List<IOSLesson> lessons) {
        this.day = day;
        this.lessons = lessons;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<IOSLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<IOSLesson> lessons) {
        this.lessons = lessons;
    }
}

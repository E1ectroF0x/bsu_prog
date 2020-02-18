package com.bsu.edu.restapi.DTO;

import java.util.List;

public class IOSDTO {

    private int day;
    private List<IOSLesson> data;

    public IOSDTO() { }

    public IOSDTO(int day, List<IOSLesson> data) {
        this.day = day;
        this.data = data;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<IOSLesson> getData() {
        return data;
    }

    public void setData(List<IOSLesson> data) {
        this.data = data;
    }
}

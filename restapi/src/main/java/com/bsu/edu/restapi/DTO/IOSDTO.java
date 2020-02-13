package com.bsu.edu.restapi.DTO;

public class IOSDTO {

    private int day;
    private String time_start;
    private String time_end;
    private String building;
    private String audience;
    private String surname;
    private String name;
    private String fathername;
    private String subject;
    private String type;

    public IOSDTO() {}

    public IOSDTO(int day, String time_start, String time_end, String building,
                  String audience, String surname, String name, String fathername, String subject, String type) {
        this.day = day;
        this.time_start = time_start;
        this.time_end = time_end;
        this.building = building;
        this.audience = audience;
        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
        this.subject = subject;
        this.type = type;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

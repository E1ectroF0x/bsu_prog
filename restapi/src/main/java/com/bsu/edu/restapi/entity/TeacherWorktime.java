package com.bsu.edu.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "teacher_worktime")
public class TeacherWorktime {
    private Long id;
    private int day;
    private String worktime_from;
    private String worktime_to;
    private Long teacher_id;

    public TeacherWorktime(){}

    public TeacherWorktime(int day, String worktime_from, String worktime_to, Long teacher_id) {
        this.day = day;
        this.worktime_from = worktime_from;
        this.worktime_to = worktime_to;
        this.teacher_id = teacher_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getWorktime_from() {
        return worktime_from;
    }

    public void setWorktime_from(String worktime_from) {
        this.worktime_from = worktime_from;
    }

    public String getWorktime_to() {
        return worktime_to;
    }

    public void setWorktime_to(String worktime_to) {
        this.worktime_to = worktime_to;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }
}

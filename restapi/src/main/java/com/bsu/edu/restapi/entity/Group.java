package com.bsu.edu.restapi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Group {
    private long id;
    private String number_group;
    private int course;
    private int max_student_amount;
    private int min_student_amount;
    private Long speciality;

    public Group(){}

    public Group(String number_group, int course, int max_student_amount, int min_student_amount, Long speciality) {
        this.number_group = number_group;
        this.course = course;
        this.max_student_amount = max_student_amount;
        this.min_student_amount = min_student_amount;
        this.speciality = speciality;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber_group() {
        return number_group;
    }

    public void setNumber_group(String number_group) {
        this.number_group = number_group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getMax_student_amount() {
        return max_student_amount;
    }

    public void setMax_student_amount(int max_student_amount) {
        this.max_student_amount = max_student_amount;
    }

    public int getMin_student_amount() {
        return min_student_amount;
    }

    public void setMin_student_amount(int min_student_amount) {
        this.min_student_amount = min_student_amount;
    }

    public Long getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Long speciality) {
        this.speciality = speciality;
    }
}

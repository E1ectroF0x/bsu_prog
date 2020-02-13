package com.bsu.edu.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "groupp")
public class Group {
    private long id;
    private String number_group;
    private int course;
    private int max_students_amount;
    private int current_student_amount;
    private Long speciality_id;

    public Group(){}

    public Group(String number_group, int course, int max_students_amount, int current_student_amount, Long speciality_id) {
        this.number_group = number_group;
        this.course = course;
        this.max_students_amount = max_students_amount;
        this.current_student_amount = current_student_amount;
        this.speciality_id = speciality_id;
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

    public int getMax_students_amount() {
        return max_students_amount;
    }

    public void setMax_students_amount(int max_student_amount) {
        this.max_students_amount = max_student_amount;
    }

    public int getCurrent_student_amount() {
        return current_student_amount;
    }

    public void setCurrent_student_amount(int min_student_amount) {
        this.current_student_amount = min_student_amount;
    }

    public Long getSpeciality_id() {
        return speciality_id;
    }

    public void setSpeciality_id(Long speciality) {
        this.speciality_id = speciality;
    }
}

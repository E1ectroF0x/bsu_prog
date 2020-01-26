package com.bsu.edu.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "speciality_subject")
public class SpecialitySubject {
    private Long id;
    private Long speciality_id;
    private Long subject_id;
    private int hours;

    public SpecialitySubject(){}

    public SpecialitySubject(Long speciality_id, Long subject_id, int hours) {
        this.speciality_id = speciality_id;
        this.subject_id = subject_id;
        this.hours = hours;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpeciality_id() {
        return speciality_id;
    }

    public void setSpeciality_id(Long speciality_id) {
        this.speciality_id = speciality_id;
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}

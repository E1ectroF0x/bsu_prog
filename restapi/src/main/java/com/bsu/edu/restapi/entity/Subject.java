package com.bsu.edu.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "subject")
public class Subject {

    private Long id;
    private String name;
    private Long subject_type_id;

    public Subject() { }

    public Subject(String name, Long subject_type_id) {
        this.name = name;
        this.subject_type_id = subject_type_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSubject_type_id() {
        return subject_type_id;
    }

    public void setSubject_type_id(Long subject_type_id) {
        this.subject_type_id = subject_type_id;
    }
}

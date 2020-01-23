package com.bsu.edu.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "audience_faculty")
public class AudienceFaculty {
    private Long id;
    private Long audience_id;
    private Long faculty_id;

    public AudienceFaculty() {}

    public AudienceFaculty(Long audience_id, Long faculty_id) {
        this.audience_id = audience_id;
        this.faculty_id = faculty_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAudience_id() {
        return audience_id;
    }

    public void setAudience_id(Long audience_id) {
        this.audience_id = audience_id;
    }

    public Long getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(Long faculty_id) {
        this.faculty_id = faculty_id;
    }
}

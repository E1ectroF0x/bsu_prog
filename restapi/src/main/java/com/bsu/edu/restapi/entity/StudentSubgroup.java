package com.bsu.edu.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "student_subgroup")
public class StudentSubgroup {
    private Long id;
    private Long student_id;
    private Long subgroup_id;

    public StudentSubgroup(){}

    public StudentSubgroup(Long student_id, Long subgroup_id) {
        this.student_id = student_id;
        this.subgroup_id = subgroup_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getSubgroup_id() {
        return subgroup_id;
    }

    public void setSubgroup_id(Long subgroup_id) {
        this.subgroup_id = subgroup_id;
    }
}

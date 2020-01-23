package com.bsu.edu.restapi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SubjectGroup {
    private Long id;
    private Long subject_id;
    private Long group_id;
    private Long subgroup_id;

    SubjectGroup(){}

    public SubjectGroup(Long subject_id, Long group_id, Long subgroup_id) {
        this.subject_id = subject_id;
        this.group_id = group_id;
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

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public Long getSubgroup_id() {
        return subgroup_id;
    }

    public void setSubgroup_id(Long subgroup_id) {
        this.subgroup_id = subgroup_id;
    }
}

package com.bsu.edu.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "subgroup")
public class SubGroup {
    private Long id;
    private int max_students_amount;
    private int current_student_amount;
    private Long group_id;

    public SubGroup(){}

    public SubGroup(int max_students_amount, int current_student_amount, Long group_id) {
        this.max_students_amount = max_students_amount;
        this.current_student_amount = current_student_amount;
        this.group_id = group_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMax_students_amount() {
        return max_students_amount;
    }

    public void setMax_students_amount(int max_students_amount) {
        this.max_students_amount = max_students_amount;
    }

    public int getCurrent_student_amount() {
        return current_student_amount;
    }

    public void setCurrent_student_amount(int current_student_amount) {
        this.current_student_amount = current_student_amount;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }
}

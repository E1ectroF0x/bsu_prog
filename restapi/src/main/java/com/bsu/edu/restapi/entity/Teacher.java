package com.bsu.edu.restapi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "teacher")
public class Teacher {

    private Long id;
    private String name;
    private String surname;
    private String fathername;
    private Date birthdate;
    private Long department_id;
    private Long user_id;

    public Teacher() { }

    public Teacher(String name, String surname, String fathername, Date birthdate, Long department_id, Long user_id) {
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.birthdate = birthdate;
        this.department_id = department_id;
        this.user_id = user_id;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}

package com.bsu.edu.restapi.DTO;

public class IOSStudentDTO {
    private String faculty;
    private String speciality;
    private String  course;
    private String group_number;
    private String form;
    private String email;
    private String address;
    private String name;
    private String surname;
    private String fathername;
    private String image;

    public IOSStudentDTO(){}

    public IOSStudentDTO(String faculty, String speciality, String course, String group_number, String form,
                         String email, String address, String name, String surname, String fathername, String image) {
        this.faculty = faculty;
        this.speciality = speciality;
        this.course = course;
        this.group_number = group_number;
        this.form = form;
        this.email = email;
        this.address = address;
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.image = image;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGroup_number() {
        return group_number;
    }

    public void setGroup_number(String group_number) {
        this.group_number = group_number;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

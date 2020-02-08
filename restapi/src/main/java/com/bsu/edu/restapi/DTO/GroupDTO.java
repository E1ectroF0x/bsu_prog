package com.bsu.edu.restapi.DTO;

public class GroupDTO {

    private String number;
    private String course;
    private String studentsAmount;
    private SpecialityDTO speciality;

    public GroupDTO() { }

    public GroupDTO(String number, String course, String studentsAmount, SpecialityDTO speciality) {
        this.number = number;
        this.course = course;
        this.studentsAmount = studentsAmount;
        this.speciality = speciality;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudentsAmount() {
        return studentsAmount;
    }

    public void setStudentsAmount(String studentsAmount) {
        this.studentsAmount = studentsAmount;
    }

    public SpecialityDTO getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityDTO speciality) {
        this.speciality = speciality;
    }
}

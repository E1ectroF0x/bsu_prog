package com.bsu.edu.restapi.DTO;

public class SpecialityDTO {

    private String name;
    private FacultyDTO faculty;

    public SpecialityDTO() { }

    public SpecialityDTO(String name, FacultyDTO faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacultyDTO getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDTO faculty) {
        this.faculty = faculty;
    }
}

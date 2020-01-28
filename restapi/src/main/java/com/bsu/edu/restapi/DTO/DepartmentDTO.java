package com.bsu.edu.restapi.DTO;

public class DepartmentDTO {

    private String name;
    private String facultyName;

    public DepartmentDTO() {}

    public DepartmentDTO(String name, String facultyName) {
        this.name = name;
        this.facultyName = facultyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}

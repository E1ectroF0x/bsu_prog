package com.bsu.edu.restapi.DTO;

public class TeacherDTO {
    private String name;
    private String secondName;
    private String lastName;
    private String birthday;
    private String departmentName;

    public TeacherDTO() {}

    public TeacherDTO(String name, String secondName, String lastName, String birthday, String departmentName) {
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

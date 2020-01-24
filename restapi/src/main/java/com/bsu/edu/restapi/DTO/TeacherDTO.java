package com.bsu.edu.restapi.DTO;

public class TeacherDTO {
    private String name;
    private String secondName;
    private String lastName;
    private String birthday;
    private Long departmentId;

    public TeacherDTO() {}

    public TeacherDTO(String name, String secondName, String lastName, String birthday, Long departmentId) {
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.departmentId = departmentId;
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}

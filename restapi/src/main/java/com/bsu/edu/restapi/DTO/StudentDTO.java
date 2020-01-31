package com.bsu.edu.restapi.DTO;

public class StudentDTO {

    private String name;
    private String secondName;
    private String lastName;
    private String address;
    private String email;
    private int ticketNumber;
    private int course;
    private int form;
    private String birthday;
    private GroupDTO group;

    StudentDTO(){}

    public StudentDTO(String name, String secondName, String lastName, String address, String email, int ticketNumber, int course, int form, String birthday, GroupDTO group) {
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.ticketNumber = ticketNumber;
        this.course = course;
        this.form = form;
        this.birthday = birthday;
        this.group = group;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }
}

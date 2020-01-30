package com.bsu.edu.restapi.DTO;

public class LessonDTO {

    private String name;
    private GroupDTO group;

    public LessonDTO() { }

    public LessonDTO(String name, GroupDTO group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

}

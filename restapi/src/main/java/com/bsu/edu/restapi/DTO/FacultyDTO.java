package com.bsu.edu.restapi.DTO;

public class FacultyDTO {

    private String name;
    private String buildingAddress;

    public FacultyDTO() { }

    public FacultyDTO(String name, String buildingAddress) {
        this.name = name;
        this.buildingAddress = buildingAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }
}

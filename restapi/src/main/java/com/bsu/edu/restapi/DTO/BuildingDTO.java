package com.bsu.edu.restapi.DTO;

public class BuildingDTO {

    private String address;
    private Integer type;

    public BuildingDTO() { }

    public BuildingDTO(String address, Integer type) {
        this.address = address;
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

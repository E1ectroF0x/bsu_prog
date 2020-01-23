package com.bsu.edu.restapi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Building {
    private Long id;
    private String address;
    private int type_building;

    public Building(){}

    public Building(String address, int type_building) {
        this.address = address;
        this.type_building = type_building;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType_building() {
        return type_building;
    }

    public void setType_building(int type_building) {
        this.type_building = type_building;
    }
}

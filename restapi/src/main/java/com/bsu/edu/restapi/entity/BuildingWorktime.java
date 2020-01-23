package com.bsu.edu.restapi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BuildingWorktime {
    private Long id;
    private int day;
    private String worktime_from;
    private String worktime_to;
    private Long building_id;

    public BuildingWorktime(){}

    public BuildingWorktime(int day, String worktime_from, String worktime_to, Long building_id) {
        this.day = day;
        this.worktime_from = worktime_from;
        this.worktime_to = worktime_to;
        this.building_id = building_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getWorktime_from() {
        return worktime_from;
    }

    public void setWorktime_from(String worktime_from) {
        this.worktime_from = worktime_from;
    }

    public String getWorktime_to() {
        return worktime_to;
    }

    public void setWorktime_to(String worktime_to) {
        this.worktime_to = worktime_to;
    }

    public Long getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(Long building_id) {
        this.building_id = building_id;
    }
}

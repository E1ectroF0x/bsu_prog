package com.bsu.edu.restapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="audience")
public class Audience {
    private Long id;
    private String number_audience;
    private int number_seats;
    private boolean is_projecteur;
    private int audience_type;
    private Long building_id;
    private Long department_id;

    public  Audience(){}

    public Audience(String number_audience, int number_seats, boolean is_projecteur, int audience_type, Long building_id, Long department_id) {
        this.number_audience = number_audience;
        this.number_seats = number_seats;
        this.is_projecteur = is_projecteur;
        this.audience_type = audience_type;
        this.building_id = building_id;
        this.department_id = department_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber_audience() {
        return number_audience;
    }

    public void setNumber_audience(String number_audience) {
        this.number_audience = number_audience;
    }

    public int getNumber_seats() {
        return number_seats;
    }

    public void setNumber_seats(int number_seats) {
        this.number_seats = number_seats;
    }

    public boolean isIs_projecteur() {
        return is_projecteur;
    }

    public void setIs_projecteur(boolean is_projecteur) {
        this.is_projecteur = is_projecteur;
    }

    public int getAudience_type() {
        return audience_type;
    }

    public void setAudience_type(int audience_type) {
        this.audience_type = audience_type;
    }

    public Long getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(Long building_id) {
        this.building_id = building_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }
}

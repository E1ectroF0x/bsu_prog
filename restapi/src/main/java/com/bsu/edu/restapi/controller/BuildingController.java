package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.DTO.BuildingDTO;
import com.bsu.edu.restapi.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/buildings")
public class BuildingController  {

    @Autowired
    private BuildingService buildingService;

    @GetMapping(value = "/{id}")
    public BuildingDTO getBuildingById(@PathVariable Long id){
        return buildingService.getBuildingById(id);
    }
}

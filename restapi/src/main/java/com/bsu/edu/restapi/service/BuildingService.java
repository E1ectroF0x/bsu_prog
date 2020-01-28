package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.BuildingDTO;
import com.bsu.edu.restapi.entity.Building;

public interface BuildingService {

    public BuildingDTO getBuildingById(Long id);

}

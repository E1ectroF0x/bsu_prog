package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.BuildingDTO;
import com.bsu.edu.restapi.entity.Building;
import com.bsu.edu.restapi.repository.BuildingRepository;
import com.bsu.edu.restapi.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public BuildingDTO getBuildingById(Long id) {
        Building building = buildingRepository.findById(id).orElse(null);
        return convert(building);
    }

    private BuildingDTO convert(Building building) {
        if (building == null) {
            return null;
        }
        return new BuildingDTO(building.getAddress(), building.getType_building());
    }
}

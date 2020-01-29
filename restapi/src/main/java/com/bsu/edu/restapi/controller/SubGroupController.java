package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.entity.SubGroup;
import com.bsu.edu.restapi.service.SubgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/subGroups")
public class SubGroupController {

    @Autowired
    private SubgroupService subGroupService;

    @RequestMapping(value = "/{id}")
    public SubGroup getById(@PathVariable Long id){
        return subGroupService.getById(id);
    }

    @RequestMapping(value = "/all")
    public List<SubGroup> getAll(){
        return subGroupService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        subGroupService.deleteById(id);
    }

    @PostMapping
    public void save(@RequestBody SubGroup subGroup){
        subGroupService.set(subGroup);
    }
}

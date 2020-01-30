package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.entity.Group;
import com.bsu.edu.restapi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;


    @RequestMapping(value = "/all")
    public List<Group> getAll(){
        return groupService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        groupService.deleteById(id);
    }

    @PostMapping
    public void save(@RequestBody Group group){
        groupService.set(group);
    }

}

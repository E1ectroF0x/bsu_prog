package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.entity.Group;

import java.util.List;

public interface GroupService {

    public Group getById(Long id);
    public List<Group> getAll();
    public void set(Group group);
    public void deleteById(Long id);
}

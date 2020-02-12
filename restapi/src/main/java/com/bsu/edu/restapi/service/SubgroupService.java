package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.entity.SubGroup;

import java.util.List;

public interface SubgroupService {

    public SubGroup getById(Long id);
    public List<SubGroup> getAll();
    public void set(SubGroup group);
    public void deleteById(Long id);
}

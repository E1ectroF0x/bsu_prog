package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.entity.SubGroup;
import com.bsu.edu.restapi.repository.SubgroupRepository;
import com.bsu.edu.restapi.service.SubgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubGroupServiceImpl implements SubgroupService {


    @Autowired
    SubgroupRepository subGroupRepository;

    @Override
    public SubGroup getById(Long id) {
        return subGroupRepository.findById(id).orElse(null);
    }

    @Override
    public List<SubGroup> getAll() {
        return (List<SubGroup>) subGroupRepository.findAll();
    }

    @Override
    public void set(SubGroup subGroup) {
        subGroupRepository.save(subGroup);
    }

    @Override
    public void deleteById(Long id) {
        subGroupRepository.deleteById(id);
    }
}

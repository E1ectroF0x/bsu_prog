package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.GroupDTO;
import com.bsu.edu.restapi.entity.Group;
import com.bsu.edu.restapi.repository.GroupRepository;
import com.bsu.edu.restapi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;


    @Override
    public GroupDTO getGroupById(Long id) {
        return null;
    }

    @Override
    public List<Group> getAll() {
        return (List<Group>) groupRepository.findAll();
    }

    @Override
    public void set(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Group getGroupByDTO(GroupDTO model) {
        return null;
    }
}

package com.bsu.edu.restapi.service;

import com.bsu.edu.restapi.DTO.GroupDTO;
import com.bsu.edu.restapi.entity.Group;

import java.util.List;

public interface GroupService {

    GroupDTO getGroupById(Long id);
    List<GroupDTO> getAll();
    List<GroupDTO> getAllGroupsBySpecialityName(String name);
    void set(Group group);
    void deleteById(Long id);
    Group getGroupByDTO(GroupDTO model);
}

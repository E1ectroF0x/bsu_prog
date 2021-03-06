package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.GroupDTO;
import com.bsu.edu.restapi.entity.Group;
import com.bsu.edu.restapi.repository.GroupRepository;
import com.bsu.edu.restapi.service.GroupService;
import com.bsu.edu.restapi.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private SpecialityService specialityService;

    @Override
    public GroupDTO getGroupById(Long id) {
        Group group = groupRepository.findById(id).orElse(null);
        return convert(group);
    }

    @Override
    public List<GroupDTO> getAll() {
         List<Group> groups = (List<Group>) groupRepository.findAll();
         List<GroupDTO> _groups = new ArrayList<>();
         groups.forEach(group -> _groups.add(convert(group)));
         return _groups;
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
        List<Group> groups = (List<Group>) groupRepository.findAll();
        return groups.stream().filter(g -> g.getNumber_group().equals(model.getNumber())
                                                   && String.valueOf(g.getCourse()).equals(model.getCourse()))
                                     .findFirst().orElse(null);
    }

    private GroupDTO convert(Group group) {
        GroupDTO model = new GroupDTO();
        model.setNumber(group.getNumber_group());
        model.setCourse(String.valueOf(group.getCourse()));
        model.setSpeciality(specialityService.findById(group.getSpeciality()));
        return null;
    }

}

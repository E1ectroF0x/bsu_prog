package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.GroupDTO;
import com.bsu.edu.restapi.DTO.LessonDTO;
import com.bsu.edu.restapi.entity.Lesson;
import com.bsu.edu.restapi.repository.LessonRepository;
import com.bsu.edu.restapi.service.GroupService;
import com.bsu.edu.restapi.service.LessonService;
import com.bsu.edu.restapi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private Lesson lesson;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private GroupService groupService;

    public LessonServiceImpl() {
        this.lesson = new Lesson();
    }

    @Override
    public List<LessonDTO> getLessonsByGroup(GroupDTO group) {
        List<Lesson> lessons = (List<Lesson>) lessonRepository.findAll();
        List<LessonDTO> _lessons = new ArrayList<>(Collections.emptyList());
        lessons.stream().filter(lesson -> lesson.getGroup_id().equals(groupService.getGroupByDTO(group).getId()))
                .forEach(lesson -> _lessons.add(convert(lesson)));
        return _lessons;
    }

    @Override
    public void saveLesson(LessonDTO model) {
        this.lesson.setSubject_id(subjectService.getSubjectByName(model.getName()).getId());
        this.lesson.setGroup_id(groupService.getGroupByDTO(model.getGroup()).getId());
        this.lessonRepository.save(this.lesson);
    }

    @Override
    public void deleteLesson(LessonDTO model) {
        List<Lesson> lessons = (List<Lesson>) lessonRepository.findAll();
        lessons.stream().filter(l -> (l.getGroup_id()).equals(groupService.getGroupByDTO(model.getGroup()).getId())
                && subjectService.getSubjectById(l.getSubject_id()).getName().equals(model.getName()))
                .findFirst().ifPresent(lesson -> lessonRepository.delete(lesson));
    }

    private LessonDTO convert(Lesson lesson) {
        return new LessonDTO(subjectService.getSubjectById(lesson.getSubject_id()).getName(),
                groupService.getGroupById(lesson.getGroup_id()));
    }
}

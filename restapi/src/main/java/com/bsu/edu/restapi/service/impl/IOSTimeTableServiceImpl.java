package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.IOSLessons;
import com.bsu.edu.restapi.entity.*;
import com.bsu.edu.restapi.repository.*;
import com.bsu.edu.restapi.service.IOSTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IOSTimeTableServiceImpl implements IOSTimeTableService {

    private Lesson lesson;

    public IOSTimeTableServiceImpl() {
        this.lesson = new Lesson();
    }

    @Autowired
    private LessonDateRepository lessonDateRepository;

    @Autowired
    private AudienceLessonRepository audienceLessonRepository;

    @Autowired
    private AudienceRepository audienceRepository;

    @Autowired
    private LessonTimeRepository lessonTimeRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private LessonTeacherRepository lessonTeacherRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<IOSLessons> getAllLessonsByMonth(int month) {
        List<IOSLessons> lessonDTOS = new ArrayList<>();
        List<LessonDate> lessonDates = (List<LessonDate>)lessonDateRepository.findAll();
        lessonDates.stream().filter(lesson ->
                (month > convertInt(lesson.getDate_start()) && month < convertInt(lesson.getDate_end())))
                .forEach(lesson -> lessonDTOS.add(convert(lesson)));
        return lessonDTOS;
    }

    private Integer convertInt(String date){
        return Integer.valueOf(date.substring(5, 6));
    }

    private IOSLessons convert(LessonDate model) {
        List<AudienceLesson> audienceLessons = (List<AudienceLesson>) audienceLessonRepository.findAll();
        List<LessonTime> lessonTimes = (List<LessonTime>) lessonTimeRepository.findAll();
        List<Group> groups = (List<Group>) groupRepository.findAll();
        Lesson _lesson =  lessonRepository.findById(model.getLesson_id()).orElse(null);
        List<LessonTeacher> lessonTeachers = (List<LessonTeacher>) lessonTeacherRepository.findAll();

        AudienceLesson audienceLesson = audienceLessons.stream().filter(lesson -> (lesson.getLesson_id())
                .equals(model.getLesson_id())).findFirst().orElse(null);
        Audience audience = audienceRepository.findById(audienceLesson.getId()).orElse(null);

        LessonTime lessonTime = lessonTimes.stream().filter(lesson -> lesson.getLesson_id().equals(model.getLesson_id()))
                                .findFirst().orElse(null);

        Group _group = groups.stream().filter(group -> _lesson.getGroup_id().equals(group.getId())).findFirst().orElse(null);
        Speciality speciality = specialityRepository.findById(_group.getSpeciality_id()).orElse(null);
        Faculty faculty = facultyRepository.findById(speciality.getFaculty_id()).orElse(null);
        Building building = buildingRepository.findById(faculty.getBuilding_id()).orElse(null);

        LessonTeacher lessonTeacher = lessonTeachers.stream().filter(lesson ->
                lesson.getLesson_id().equals(model.getLesson_id())).findFirst().orElse(null);
        Teacher teacher = teacherRepository.findById(lessonTeacher.getTeacher_id()).orElse(null);
        Subject subject = subjectRepository.findById(_lesson.getSubject_id()).orElse(null);

        IOSLessons IOSLessons = new IOSLessons();
        IOSLessons.setAudience(audience.getNumber_audience());
        IOSLessons.setTime_end(lessonTime.getTime_end());
        IOSLessons.setTime_start(lessonTime.getTime_start());
        IOSLessons.setBuilding(building.getAddress());
        IOSLessons.setName(teacher.getName());
        IOSLessons.setFathername(teacher.getFathername());
        IOSLessons.setSurname(teacher.getSurname());
        IOSLessons.setSubject(subject.getName());
        switch ((subject.getSubject_type_id()).toString()){
            case "1":
                IOSLessons.setType("Лабораторное занятие");
                break;
            case "2":
                IOSLessons.setType("Лекционное заянтие");
                break;
            case "3":
                IOSLessons.setType("Практическое занятие");
                break;
        }

        return IOSLessons;
    }

}

package com.bsu.edu.restapi.service.impl;

import com.bsu.edu.restapi.DTO.IOSDTO;
import com.bsu.edu.restapi.DTO.IOSLesson;
import com.bsu.edu.restapi.entity.*;
import com.bsu.edu.restapi.repository.*;
import com.bsu.edu.restapi.service.IOSTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
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
    public List<IOSDTO> getAllLessonsByMonth(int month) {
        List<IOSDTO> models = new ArrayList<>();
        List<Lesson> lessons = (List<Lesson>) lessonRepository.findAll();
        int monthdays;
        if (month < 9) {
            monthdays = YearMonth.of(2019, month).lengthOfMonth();
        }
        else {
            monthdays = YearMonth.of(2020, month).lengthOfMonth();
        }
        for (int i=1; i<=monthdays; i++) {
            final int day = i;
            List<IOSLesson> iosLessons = new ArrayList<>();
            lessons.stream().filter(lesson -> isThisDayOfMonth(month, day, lesson))
                    .forEach(lesson -> iosLessons.add(convert(lesson)));
            IOSDTO model = new IOSDTO();
            model.setDay(day);
            model.setLessons(iosLessons);
        }
        return models;
    }

    private Integer convertInt(String date){
        return Integer.valueOf(date.substring(5, 6));
    }

    private IOSLesson convert(Lesson model) {
        List<LessonTime> lessonTimes = (List<LessonTime>) lessonTimeRepository.findAll();
        LessonTime lessonTime = lessonTimes.stream().filter(lesson -> lesson.getLesson_id().equals(model.getId()))
                .findFirst().orElse(null);

        List<Group> groups = (List<Group>) groupRepository.findAll();
        Group _group = groups.stream().filter(group -> model.getGroup_id().equals(group.getId())).findFirst().orElse(null);
        Speciality speciality = specialityRepository.findById(_group.getSpeciality_id()).orElse(null);
        Faculty faculty = facultyRepository.findById(speciality.getFaculty_id()).orElse(null);
        Building building = buildingRepository.findById(faculty.getBuilding_id()).orElse(null);

        List<AudienceLesson> audienceLessons = (List<AudienceLesson>) audienceLessonRepository.findAll();
        AudienceLesson audienceLesson = audienceLessons.stream().filter(lesson -> (lesson.getLesson_id())
                .equals(model.getId())).findFirst().orElse(null);
        Audience audience = audienceRepository.findById(audienceLesson.getId()).orElse(null);

        List<LessonTeacher> lessonTeachers = (List<LessonTeacher>) lessonTeacherRepository.findAll();
        LessonTeacher lessonTeacher = lessonTeachers.stream().filter(lesson ->
                lesson.getLesson_id().equals(model.getId())).findFirst().orElse(null);
        Teacher teacher = teacherRepository.findById(lessonTeacher.getTeacher_id()).orElse(null);

        Subject subject = subjectRepository.findById(model.getSubject_id()).orElse(null);

        IOSLesson iosLesson = new IOSLesson();
        iosLesson.setTime_end(lessonTime.getTime_end());
        iosLesson.setTime_start(lessonTime.getTime_start());
        iosLesson.setBuilding(building.getAddress());
        iosLesson.setAudience(audience.getNumber_audience());
        iosLesson.setName(teacher.getName());
        iosLesson.setFathername(teacher.getFathername());
        iosLesson.setSurname(teacher.getSurname());
        iosLesson.setSubject(subject.getName());
        switch ((subject.getSubject_type_id()).toString()){
            case "1":
                iosLesson.setType("Лабораторное занятие");
                break;
            case "2":
                iosLesson.setType("Лекционное заянтие");
                break;
            case "3":
                iosLesson.setType("Практическое занятие");
                break;
        }
        return iosLesson;
    }

}

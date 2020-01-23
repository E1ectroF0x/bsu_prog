package com.bsu.edu.restapi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AudienceLesson {

    private Long id;
    private Long audience_id;
    private Long lesson_id;

    public AudienceLesson() {}

    public AudienceLesson(Long audience_id, Long lesson_id) {
        this.audience_id = audience_id;
        this.lesson_id = lesson_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAudience_id() {
        return audience_id;
    }

    public void setAudience_id(Long audience_id) {
        this.audience_id = audience_id;
    }

    public Long getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Long lesson_id) {
        this.lesson_id = lesson_id;
    }
}

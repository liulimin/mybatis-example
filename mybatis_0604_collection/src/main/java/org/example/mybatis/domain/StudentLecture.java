package org.example.mybatis.domain;

import java.math.BigDecimal;

public class StudentLecture {
    private Long id;

    private Integer studentId;

    private BigDecimal grade;

    private String note;

    private Lecture lecture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
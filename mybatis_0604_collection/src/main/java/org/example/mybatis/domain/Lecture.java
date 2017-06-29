package org.example.mybatis.domain;

public class Lecture {
    private Long id;

    private String lectureNmae;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLectureNmae() {
        return lectureNmae;
    }

    public void setLectureNmae(String lectureNmae) {
        this.lectureNmae = lectureNmae == null ? null : lectureNmae.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}
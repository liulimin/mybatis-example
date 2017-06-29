package org.example.mybatis.domain;

import java.util.List;

public class Student {
    private Long id;

    private String cnnmae;

    private Integer sex;

    private String note;

    private String comment;

    private StudentSelfcard studentSelfcard;

    private List<StudentLecture> studentLectureList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnnmae() {
        return cnnmae;
    }

    public void setCnnmae(String cnnmae) {
        this.cnnmae = cnnmae == null ? null : cnnmae.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public StudentSelfcard getStudentSelfcard() {
        return studentSelfcard;
    }

    public void setStudentSelfcard(StudentSelfcard studentSelfcard) {
        this.studentSelfcard = studentSelfcard;
    }

    public List<StudentLecture> getStudentLectureList() {
        return studentLectureList;
    }

    public void setStudentLectureList(List<StudentLecture> studentLectureList) {
        this.studentLectureList = studentLectureList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", cnnmae='" + cnnmae + '\'' +
                ", sex=" + sex +
                ", note='" + note + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
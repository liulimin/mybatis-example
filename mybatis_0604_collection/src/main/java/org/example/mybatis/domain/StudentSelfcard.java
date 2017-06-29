package org.example.mybatis.domain;

import java.util.Date;

public class StudentSelfcard {
    private Long id;

    private Integer studentId;

    private String studentNative;

    private Date issueDate;

    private Date endDate;

    private String note;

    private Student student;

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

    public String getStudentNative() {
        return studentNative;
    }

    public void setStudentNative(String studentNative) {
        this.studentNative = studentNative == null ? null : studentNative.trim();
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentSelfcard{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentNative='" + studentNative + '\'' +
                ", issueDate=" + issueDate +
                ", endDate=" + endDate +
                ", note='" + note + '\'' +
                '}';
    }
}
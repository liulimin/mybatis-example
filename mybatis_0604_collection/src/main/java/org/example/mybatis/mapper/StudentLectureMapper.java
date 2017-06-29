package org.example.mybatis.mapper;

import org.example.mybatis.domain.StudentLecture;

import java.util.List;

public interface StudentLectureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentLecture record);

    int insertSelective(StudentLecture record);

    StudentLecture selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentLecture record);

    int updateByPrimaryKey(StudentLecture record);

    List<StudentLecture> selectByStudentId(Long studentId);
}
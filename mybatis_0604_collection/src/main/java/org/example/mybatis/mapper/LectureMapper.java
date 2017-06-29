package org.example.mybatis.mapper;

import org.example.mybatis.domain.Lecture;

public interface LectureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Lecture record);

    int insertSelective(Lecture record);

    Lecture selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Lecture record);

    int updateByPrimaryKey(Lecture record);
}
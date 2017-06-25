package org.example.mybatis.mapper;

import org.example.mybatis.domain.StudentSelfcard;

public interface StudentSelfcardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentSelfcard record);

    int insertSelective(StudentSelfcard record);

    StudentSelfcard selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentSelfcard record);

    int updateByPrimaryKey(StudentSelfcard record);
}
package org.example.mybatis.persistence;

import java.util.List;

import org.example.mybatis.domain.User;

public interface UserMapper {

	public int insert(User user);

	public int update(User user);

	public int delete(String userName);

	public List<User> selectAll();

	public int countAll();

	public User findByUserName(String userName);
}

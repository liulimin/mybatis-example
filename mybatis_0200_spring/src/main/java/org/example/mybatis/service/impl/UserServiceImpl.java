package org.example.mybatis.service.impl;

import java.util.List;

import org.example.mybatis.domain.User;
import org.example.mybatis.persistence.UserMapper;
import org.example.mybatis.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public int delete(String userName) {
		return userMapper.delete(userName);
	}

	@Override
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public int countAll() {
		return userMapper.countAll();
	}

	@Override
	public User findByUserName(String userName) {
		return userMapper.findByUserName(userName);
	}

}

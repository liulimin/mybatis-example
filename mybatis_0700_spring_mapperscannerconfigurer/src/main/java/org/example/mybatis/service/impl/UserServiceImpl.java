package org.example.mybatis.service.impl;

import java.util.List;

import org.example.mybatis.dao.UserDao;
import org.example.mybatis.domain.User;
import org.example.mybatis.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public int delete(String userName) {
		return userDao.delete(userName);
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public int countAll() {
		return userDao.countAll();
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

}

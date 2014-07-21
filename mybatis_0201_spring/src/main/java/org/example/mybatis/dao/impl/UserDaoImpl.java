package org.example.mybatis.dao.impl;

import java.util.List;

import org.example.mybatis.dao.UserDao;
import org.example.mybatis.domain.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public int insert(User user) {
		return this.getSqlSession().insert(UserDao.class.getName() + ".insert", user);
	}

	@Override
	public int update(User user) {
		return this.getSqlSession().update(UserDao.class.getName() + ".update", user);
	}

	@Override
	public int delete(String userName) {
		return this.getSqlSession().delete(UserDao.class.getName() + ".delete", userName);
	}

	@Override
	public List<User> selectAll() {
		return this.getSqlSession().selectList(UserDao.class.getName() + ".selectAll");
	}

	@Override
	public int countAll() {
		//return this.getSqlSession().selectOne(UserDao.class.getName() + ".countAll");
		return 0;
	}

	@Override
	public User findByUserName(String userName) {
//		return this.getSqlSession().selectOne(UserDao.class.getName() + ".findByUserName", userName);
		return null;
	}

}

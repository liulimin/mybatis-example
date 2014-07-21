package org.example.mybatis.dao.impl;

import org.example.mybatis.dao.AddressDao;
import org.example.mybatis.domain.Address;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class AddressDaoImpl extends SqlSessionDaoSupport implements AddressDao {

	@Override
	public void insert(Address address) {
		this.getSqlSession().insert(AddressDao.class.getName() + ".insert", address);

	}

}

package org.example.mybatis.service.impl;

import org.example.mybatis.dao.AddressDao;
import org.example.mybatis.domain.Address;
import org.example.mybatis.service.AddressService;

public class AddressServiceImpl implements AddressService {
	
	private AddressDao addressDao;
	
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public void insert(Address address) {
		addressDao.insert(address);

	}

}

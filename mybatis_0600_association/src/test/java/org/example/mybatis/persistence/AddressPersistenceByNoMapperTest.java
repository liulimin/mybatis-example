package org.example.mybatis.persistence;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.domain.Address;
import org.example.mybatis.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressPersistenceByNoMapperTest {
	private SqlSession session = null;
	
	@Before
	public void setUp() throws IOException {
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);

		session = factory.openSession();
	}
	
	@Test
	public void selectAddressTest() {
		List<Address> addressList = session.selectList(Address.class.getName() + ".selectAddress", 1);
		for (Address address : addressList) {
			System.out.println("地址：" + address.getAddressName() + " 收件人：" + address.getAddressee() + " 邮编：" + address.getPostCode() + 
					" 姓名：" + address.getUser().getUserName() + " ID:" + address.getUser().getUserId() + " 密码：" + address.getUser().getPassword()
					+ " 备注：" + address.getUser().getComment());
		}
	}
	
	@After
	public void tearDown() {
		if (session != null) {
			session.close();
		}
	}
}
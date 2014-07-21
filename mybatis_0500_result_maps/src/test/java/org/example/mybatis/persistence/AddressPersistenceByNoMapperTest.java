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
	public void selectAllTest()  {
		List<Address> list = session.selectList(Address.class.getName() + ".selectAll");
		for (Address address : list) {
			System.out.println("地址：" + address.getAddressName() + " 收件人：" + address.getAddressee() + " 邮编：" + address.getPostCode());
		}
	}
	
	@Test
	public void insertTest() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(13);
		User user = session.selectOne(User.class.getName() + ".findByUserId", list);
		Address address = new Address();
		address.setAddressName("广东省海珠区");
		address.setPostCode("510665");
		/*address.setAddressName("广东省广州市天河区棠下村禾塘尾四巷3号");
		address.setPostCode("510665");*/
		address.setAddressee("刘利民");
		address.setUser(user);
		
		session.insert(Address.class.getName() + ".insert", address);
		
		session.commit();
	}
	
	@Test
	public void deleteTest() {
		session.delete(Address.class.getName() + ".delete", 1);
		session.commit();
	}
	
	@Test
	public void updateTest() {
		Address address = new Address();
		address.setAddressId(3);
		address.setAddressee("冯占兵");
		session.update(Address.class.getName() + ".update", address);
		session.commit();
	}
	
	@Test
	public void selectAddressTest() {
		List<Address> addressList = session.selectList(Address.class.getName() + ".selectAddress", 3);
		for (Address address : addressList) {
			System.out.println("地址：" + address.getAddressName() + " 收件人：" + address.getAddressee() + " 用户名：" + address.getUser().getUserName() + " 密码：" + address.getUser().getPassword() + " 备注：" + address.getUser().getComment());
		}
	}
	
	@After
	public void tearDown() {
		if (session != null) {
			session.close();
		}
	}
}
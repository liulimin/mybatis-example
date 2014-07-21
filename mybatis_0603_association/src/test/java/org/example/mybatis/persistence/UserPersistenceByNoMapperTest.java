package org.example.mybatis.persistence;

import java.io.IOException;
import java.io.Reader;
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

public class UserPersistenceByNoMapperTest {
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
	public void selectUserTest() {
		List<User> userList = session.selectList(User.class.getName() + ".selectUser", 13);
		List<Address> addressList = null;
		for (User user : userList) {
			System.out.println("姓名：" + user.getUserName() + " 密码：" + user.getPassword() + " 备注：" + user.getComment());
			addressList = user.getAddressList();
			if (null != addressList) {
				for (Address address : addressList) {
					System.out.println("---------地址：" + address.getAddressName() + " 所属姓名：" + address.getUser().getUserName());
				}
			}
		}
	}
	
	@After
	public void tearDown() {
		if (session != null) {
			session.close();
		}
	}
}
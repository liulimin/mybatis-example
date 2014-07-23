package org.example.mybatis.persistence;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
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
	public void userDaoTest() throws Exception {
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);

		SqlSession session = factory.openSession();

		User user = new User();
		user.setUserName("hongye");
		user.setPassword("123456");
		user.setComment("备注");

		session.insert(User.class.getName() + ".insert", user);
		System.out.println("记录条数：" + session.selectOne(User.class.getName() + ".countAll"));
        session.commit();
		/*List<User> users = session.selectList(User.class.getName() + ".selectAll");
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			user = iter.next();
			System.out.println("用" +
					"户名：" + user.getUserName() + " 密码："
					+ user.getPassword() + " 备注：" + user.getComment());
		}*/

	}
	
	@Test
	public void selectUserAndAddressTest() {
		List<Address> list = session.selectList(User.class.getName() + ".selectUserAndAddress");
		for (Address address : list) {
			System.out.println("地址：" + address.getAddressName() + " 收件人：" + address.getAddressee() + " 用户名：" + address.getUser().getUserName() + " 密码：" + address.getUser().getPassword() + " 备注：" + address.getUser().getComment());
		}
		
	}
	
	@Test
	public void selectUserTest() {
		List<User> userList = session.selectList(User.class.getName() + ".selectUser", 1);
		for (User user : userList) {
			List<Address> addressList = user.getAddressList();
			for (Address address : addressList) {
				System.out.println("地址：" + address.getAddressName());
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
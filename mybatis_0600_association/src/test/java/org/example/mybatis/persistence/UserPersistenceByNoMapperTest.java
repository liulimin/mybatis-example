package org.example.mybatis.persistence;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
	public void insertUserTest() {
		User user = new User();
		user.setUserName("test");
		user.setComment("test");
		user.setPassword("123123");
        session.insert(User.class.getName() + ".insert", user);
        session.commit();
	}
	
	@Test
	public void selectUserTest() {
		User user = session.selectOne(User.class.getName() + ".selectUser", 1);
			System.out.println("姓名：" + user.getUserName() + " 密码：" + user.getPassword() + " 备注：" + user.getComment());
	}
	
	@After
	public void tearDown() {
		if (session != null) {
			session.close();
		}
	}
}
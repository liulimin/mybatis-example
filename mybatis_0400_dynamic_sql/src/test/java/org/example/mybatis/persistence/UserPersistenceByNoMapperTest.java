package org.example.mybatis.persistence;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.domain.User;
import org.junit.Test;

public class UserPersistenceByNoMapperTest {
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

		List<User> users = session.selectList(User.class.getName() + ".selectAll");
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			System.out.println("用" +
					"户名：" + u.getUserName() + "密码："
					+ u.getPassword());
		}

		user.setComment("comment");
		session.update(User.class.getName() + ".update", user);
		User u = session.selectOne(User.class.getName() + ".findByUserName", "hongye");
		System.out.println(u.getComment());

		session.delete(User.class.getName() + ".delete", "hongye");
		System.out.println("记录条数：" + session.selectOne(User.class.getName() + ".countAll"));

		session.commit();
		session.close();
	}
}
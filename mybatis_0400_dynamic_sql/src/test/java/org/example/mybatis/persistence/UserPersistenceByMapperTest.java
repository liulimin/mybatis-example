package org.example.mybatis.persistence;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.domain.User;
import org.junit.Test;

public class UserPersistenceByMapperTest {
	@Test
	public void userDaoTest() throws Exception {
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);

		SqlSession session = factory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);

		/*User user = new User();
		user.setUserName("hongye");
		user.setPassword("123456");
		user.setComment("备注");

		userMapper.insert(user);
		System.out.println("记录条数：" + userMapper.countAll());

		List<User> users = userMapper.selectAll();
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			System.out.println("用" +
					"户名：" + u.getUserName() + "密码："
					+ u.getPassword());
		

		user.setComment("comment");
		userMapper.update(user);*/
		
		/*Map params = new HashMap();
		
		params.put("userId", "userId");
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(13);
		params.put("userIds", list);
		
		User u = userMapper.findByUserName(params);
		System.out.println(u.getUserName());*/
		
		/*int[] userIds = {13};
		User u = userMapper.findByUserName(userIds);
		System.out.println(u.getUserName());*/
		
		/*List<Integer> userIds = new ArrayList<Integer>();
		userIds.add(13);
		
		User u = userMapper.findByUserName(userIds);
		System.out.println(u.getUserName());*/
		
		List<User> users = userMapper.selectAllByeLike("h");
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			System.out.println("用" +
					"户名：" + u.getUserName() + "密码："
					+ u.getPassword());
		}

		/*userMapper.delete("hongye");
		System.out.println("记录条数：" + userMapper.countAll());
		 
		session.commit();
		session.close();*/
	}
}
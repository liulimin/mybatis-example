package org.example.mybatis.persistence;

import java.util.Iterator;
import java.util.List;

import org.example.mybatis.domain.User;
import org.example.mybatis.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserPersistenceTest {
	
	@Test
	public void userDaoTest() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)applicationContext.getBean("userService");
		/*User user = new User();
		user.setUserName("hongye");
		user.setPassword("123456");
		user.setComment("备注");

		userService.insert(user);*/
		/*System.out.println("记录条数：" + userService.countAll());*/

		/*List<User> users = userService.selectAll();
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			System.out.println("用" +
					"户名：" + u.getUserName() + "密码："
					+ u.getPassword());
		}

		user.setComment("comment");
		userService.update(user);*/
		User u = userService.findByUserName("hongye");
		System.out.println(u.getComment());

		/*userService.delete("hongye");
		System.out.println("记录条数：" + userService.countAll());*/

	}
	
}
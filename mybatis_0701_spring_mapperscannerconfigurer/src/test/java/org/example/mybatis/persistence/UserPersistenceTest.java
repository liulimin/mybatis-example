package org.example.mybatis.persistence;

import java.util.Iterator;
import java.util.List;

import org.example.mybatis.domain.User;
import org.example.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserPersistenceTest {
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Test
	public void userDaoTest() throws Exception {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserService userService = (UserService)applicationContext.getBean("userService");
		User user = new User();
		user.setUserName("hongye2");
		user.setPassword("123456");
		user.setComment("备注");

		userService.insert(user);
		System.out.println("记录条数：" + userService.countAll());

		List<User> users = userService.selectAll();
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			System.out.println("用" +
					"户名：" + u.getUserName() + "密码："
					+ u.getPassword());
		}

		user.setComment("comment");
		userService.update(user);
		User u = userService.findByUserName("hongye2");
		System.out.println(u.getComment());

		userService.delete("hongye");
		System.out.println("记录条数：" + userService.countAll());

	}
	
}
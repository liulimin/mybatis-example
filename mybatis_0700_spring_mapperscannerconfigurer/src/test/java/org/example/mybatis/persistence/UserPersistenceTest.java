package org.example.mybatis.persistence;

import java.util.Iterator;
import java.util.List;

import org.example.mybatis.domain.User;
import org.example.mybatis.service.UserService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserPersistenceTest {
	
	private ApplicationContext applicationContext;
	private UserService userService;
	
	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService)applicationContext.getBean("userService");
	}
	
	@Test
	public void insertTest() {
		User user = new User();
		user.setUserName("fzb");
		user.setPassword("fzb");
		user.setComment("fzb");
		userService.insert(user);
	}
	
	@Test
	public void findByUserNameTest() {
		User user = userService.findByUserName("fzb");
		System.out.println("姓名：" + user.getUserName() + " 密码：" + user.getPassword() + " 备注：" + user.getComment());
	}
	
	@Test
	public void updateTest() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("fengzhanbing");
		userService.update(user);
	}
	
	@Test
	public void deleteTest() {
		userService.delete("fengzhanbing");
	}
	
	@Test
	public void selectAllTest() {
		List<User> userList = userService.selectAll();
		for (User user : userList) {
			System.out.println("姓名：" + user.getUserName() + " 密码：" + user.getPassword() + " 备注：" + user.getComment());
		}
	}
	
	
	@Test
	public void countAllTest() throws Exception {
		int count = userService.countAll();
		System.out.println(count);
	}
}
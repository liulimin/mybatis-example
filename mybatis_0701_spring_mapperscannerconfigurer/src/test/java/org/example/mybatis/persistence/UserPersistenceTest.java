package org.example.mybatis.persistence;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.example.mybatis.domain.User;
import org.example.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class UserPersistenceTest {
	private static Logger logger = Logger.getLogger(UserPersistenceTest.class);

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Test
	public void userDaoTest() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)applicationContext.getBean("userService");
		User user = new User();
		user.setUserName("hongye");
		user.setPassword("123456");
		user.setComment("备注");

		userService.insert(user);
        logger.info("记录条数：" + userService.countAll());

		List<User> users = userService.selectAll();
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
            logger.debug("用" +
					"户名：" + u.getUserName() + "密码："
					+ u.getPassword());
		}

		user.setComment("comment");
		userService.update(user);
		User u = userService.findByUserName("hongye");
		logger.warn(u.getComment());

		userService.delete("hongye");
		logger.error("记录条数：" + userService.countAll());

	}
	
}
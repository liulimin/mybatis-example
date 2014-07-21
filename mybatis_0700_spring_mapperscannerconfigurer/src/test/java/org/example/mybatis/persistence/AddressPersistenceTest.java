package org.example.mybatis.persistence;

import java.util.List;

import org.example.mybatis.domain.Address;
import org.example.mybatis.domain.User;
import org.example.mybatis.service.AddressService;
import org.example.mybatis.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddressPersistenceTest {
	
	private ApplicationContext applicationContext;
	private UserService userService;
	private AddressService addressService;
	
	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService)applicationContext.getBean("userService");
		addressService = (AddressService)applicationContext.getBean("addressService");
	}
	
	@Test
	public void insertTest() {
		User user = userService.findByUserName("liulimin");
		Address address = new Address();
		address.setPostCode("422700");
		address.setAddressee("邹苏梅");
		address.setAddressName("湖南邵阳新宁安山温塘村");
		address.setUser(user);
		addressService.insert(address);
	}
	
	@Test
	public void findByUserNameTest() {
		User user = userService.findByUserName("liulimin");
		System.out.println("姓名：" + user.getUserName() + " 密码：" + user.getPassword() + " 备注：" + user.getComment());
	}
	
	@Test
	public void updateTest() {
		User user = new User();
		user.setUserId(15);
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
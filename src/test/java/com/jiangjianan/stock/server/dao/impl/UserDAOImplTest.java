package com.jiangjianan.stock.server.dao.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangjianan.stock.server.dao.UserDAO;
import com.jiangjianan.stock.server.object.UserDO;

public class UserDAOImplTest {
	private UserDAO userDAO;

	@SuppressWarnings("resource")
	@Before
	public void setup() {
		userDAO = (UserDAO) new ClassPathXmlApplicationContext(
				"applicationContext.xml").getBean("userDAO");
	}

	@Test
	public void test() {
		UserDO userDO = userDAO.getUserByName("user");
		System.out.println(userDO);
		ToStringBuilder.reflectionToString(userDO);
	}
}

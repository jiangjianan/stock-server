package com.jiangjianan.stock.server.manager.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.manager.MailSenderManager;
import com.jiangjianan.stock.server.object.MailConfigurationDO;

public class MailSenderManagerImplTest {
	private MailSenderManager mailSenderManager;

	@SuppressWarnings("resource")
	@Before
	public void setup() {
		mailSenderManager = (MailSenderManager) new ClassPathXmlApplicationContext(
				"applicationContext.xml").getBean("mailSenderManager");
	}

	@Test
	public void sendMail() throws ManagerException {
		MailConfigurationDO mailConfigurationDO = new MailConfigurationDO();
		mailConfigurationDO.setFrom("stock.jiangjianan@gmail.com");
		mailConfigurationDO.setTo("jja1982@gmail.com");
		mailConfigurationDO.setSubject("test");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("from", "johnny");
		mailConfigurationDO.setTemplateName("mail.vm");
		mailConfigurationDO.setModel(model);
		mailSenderManager.sendMail(mailConfigurationDO);
	}

}

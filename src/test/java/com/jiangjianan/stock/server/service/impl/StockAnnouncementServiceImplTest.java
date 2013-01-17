package com.jiangjianan.stock.server.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangjianan.stock.server.service.StockAnnouncementService;

public class StockAnnouncementServiceImplTest {
	private StockAnnouncementService stockAnnouncementService;

	@SuppressWarnings("resource")
	@Before
	public void setUp() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		stockAnnouncementService = (StockAnnouncementService) ctx
				.getBean("stockAnnouncementService");
	}

	@Test
	public void test() {
		stockAnnouncementService.updateStockAnnouncementByCode("600000");
	}

}

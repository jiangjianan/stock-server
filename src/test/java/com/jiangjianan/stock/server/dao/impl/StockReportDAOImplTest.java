package com.jiangjianan.stock.server.dao.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangjianan.stock.server.dao.StockReportDAO;
import com.jiangjianan.stock.server.object.StockReportDO;

public class StockReportDAOImplTest {
	private StockReportDAO stockReportDAO;

	@SuppressWarnings("resource")
	@Before
	public void setup() {
		stockReportDAO = (StockReportDAO) new ClassPathXmlApplicationContext(
				"applicationContext.xml").getBean("stockReportDAO");
	}

	@Test
	public void getList() {
		List<StockReportDO> list = stockReportDAO
				.getStockReportListByCode("600000");
		System.out.println(list.size());
	}

}

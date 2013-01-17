package com.jiangjianan.stock.server.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangjianan.stock.server.dao.StockInfoDAO;
import com.jiangjianan.stock.server.object.StockInfoDO;

public class StockInfoDAOImplTest {
	private StockInfoDAO stockInfoDAO;
	private StockInfoDO stockInfoDO;

	@SuppressWarnings("resource")
	@Before
	public void setup() {
		stockInfoDAO = (StockInfoDAO) new ClassPathXmlApplicationContext(
				"applicationContext.xml").getBean("stockInfoDAO");
		stockInfoDO = new StockInfoDO();
		stockInfoDO.setCode("-1");
		stockInfoDO.setName("ÆÖ·¢ÒøÐÐ");
	}

	@Test
	public void test() {
		assertNull(stockInfoDAO.getStockInfoByCode("-1"));
		stockInfoDAO.insertStockInfo(stockInfoDO);
		assertNotNull(stockInfoDAO.getStockInfoByCode("-1"));
		assertTrue(stockInfoDAO.getStockInfoList().size() > 0);
		stockInfoDAO.deleteStockInfoByCode("-1");
		assertNull(stockInfoDAO.getStockInfoByCode("-1"));
	}
}

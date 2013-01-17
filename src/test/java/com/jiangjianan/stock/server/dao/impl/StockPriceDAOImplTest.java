package com.jiangjianan.stock.server.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangjianan.stock.server.dao.StockPriceDAO;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.query.StockPriceQuery;

public class StockPriceDAOImplTest {
	private StockPriceDAO stockPriceDAO;
	private StockPriceDO stockPriceDO;

	@SuppressWarnings("resource")
	@Before
	public void setup() {
		stockPriceDAO = (StockPriceDAO) new ClassPathXmlApplicationContext(
				"applicationContext.xml").getBean("stockPriceDAO");
		stockPriceDO = new StockPriceDO();
		stockPriceDO.setCode("900000");
		stockPriceDO.setName("≤‚ ‘π…∆±");
		stockPriceDO.setDate(20120101L);
		stockPriceDO.setId("90000020120101");
	}

	@Test
	public void test() {
		assertNull(stockPriceDAO.getStockPriceById("90000020120101"));
		stockPriceDAO.insertStockPrice(stockPriceDO);
		assertNotNull(stockPriceDAO.getStockPriceById("90000020120101"));
		StockPriceQuery query = new StockPriceQuery();
		query.setCode("900000");
		query.setStartDate(20120101L);
		query.setEndDate(20120102L);
		assertEquals(1, stockPriceDAO.getStockPriceListByQuery(query).size());
		stockPriceDAO.deleteStockPriceById("90000020120101");
		assertNull(stockPriceDAO.getStockPriceById("900000201201011"));
	}
}

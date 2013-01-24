package com.jiangjianan.stock.server.dao.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangjianan.stock.server.dao.StockAttentionDAO;
import com.jiangjianan.stock.server.object.StockAttentionDO;

public class StockAttentionDAOImplTest {
	private StockAttentionDAO stockAttentionDAO;

	@SuppressWarnings("resource")
	@Before
	public void setup() {
		stockAttentionDAO = (StockAttentionDAO) new ClassPathXmlApplicationContext(
				"applicationContext.xml").getBean("stockAttentionDAO");
	}

	@Test
	public void getList() {
		List<StockAttentionDO> list = stockAttentionDAO
				.getStockAttentionListByUserId(8L);
		System.out.println(list.size());
	}
	
	@Test
	public void getStockAttentionListCodeList() {
		List<String> list = stockAttentionDAO.getStockAttentionListCodeList();
		System.out.println(list);
	}

}

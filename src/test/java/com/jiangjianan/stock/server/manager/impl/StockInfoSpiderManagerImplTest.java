package com.jiangjianan.stock.server.manager.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.object.StockPriceDO;

public class StockInfoSpiderManagerImplTest {

	// @Test
	// public void getStockName() throws ManagerException {
	// StockAnalyzerSpiderManagerImpl manager = new
	// StockAnalyzerSpiderManagerImpl();
	// StockInfoDO stockInfoDO = manager.getStockInfo("600000");
	// assertEquals("ÆÖ·¢ÒøÐÐ", stockInfoDO.getName());
	// }

	 @Test
	public void getStockPrice() throws ManagerException {
		StockAnalyzerSpiderManagerImpl manager = new StockAnalyzerSpiderManagerImpl();
		List<StockPriceDO> list = manager.getStockPrice("600000", 20130108L, 20130108L);
		assertEquals(1, list.size());
	}
	// @Test
	// public void getStockReport() throws ManagerException {
	// StockAnalyzerSpiderManagerImpl manager = new
	// StockAnalyzerSpiderManagerImpl();
	// String body = manager.getStockReport("600000");
	// System.out.println(body);
	// assertNotNull(body);
	// }

}

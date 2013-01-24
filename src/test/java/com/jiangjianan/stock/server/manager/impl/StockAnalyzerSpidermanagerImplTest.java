package com.jiangjianan.stock.server.manager.impl;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.object.StockReportDO;

public class StockAnalyzerSpidermanagerImplTest {

	@Test
	public void getStockReport() throws ManagerException {
		StockAnalyzerSpiderManagerImpl manager = new StockAnalyzerSpiderManagerImpl();
		List<StockReportDO> list = manager.getStockReport("601166");
		System.out.println(ToStringBuilder.reflectionToString(list.get(0)));
	}

}

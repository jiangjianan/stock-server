package com.jiangjianan.stock.server.manager;

import java.util.List;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.object.StockInfoDO;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.object.StockReportDO;

public interface StockAnalyzerSpiderManager {
	public StockInfoDO getStockInfo(String code) throws ManagerException;

	public List<StockPriceDO> getStockPrice(String code, Long startDate, Long endDate)
			throws ManagerException;

	public List<StockReportDO> getStockReport(String code) throws ManagerException;

}

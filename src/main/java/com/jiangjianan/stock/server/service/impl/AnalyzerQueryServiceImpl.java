package com.jiangjianan.stock.server.service.impl;

import java.util.List;

import com.jiangjianan.stock.server.common.service.BaseService;
import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.common.service.ResultSupport;
import com.jiangjianan.stock.server.dao.StockInfoDAO;
import com.jiangjianan.stock.server.dao.StockPriceDAO;
import com.jiangjianan.stock.server.manager.StockAnalyzerSpiderManager;
import com.jiangjianan.stock.server.object.StockInfoDO;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.query.StockPriceQuery;
import com.jiangjianan.stock.server.service.AnalyzerQueryService;

public class AnalyzerQueryServiceImpl extends BaseService implements
		AnalyzerQueryService {

	private StockAnalyzerSpiderManager stockAnalyzerSpiderManager;
	private StockPriceDAO stockPriceDAO;
	private StockInfoDAO stockInfoDAO;

	@Override
	public Result<List<StockPriceDO>> getStockPriceList(
			StockPriceQuery stockPriceQuery) {
		Result<List<StockPriceDO>> result = new ResultSupport<List<StockPriceDO>>();
		try {
			List<StockPriceDO> list = stockPriceDAO
					.getStockPriceListByQuery(stockPriceQuery);
			result.setSuccess(true);
			result.setDefaultModel(list);
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error("AnalyzerQueryServiceImpl.getStockPriceList", e);
		}
		return result;
	}

	@Override
	public Result<List<StockInfoDO>> getStockInfoList() {
		Result<List<StockInfoDO>> result = new ResultSupport<List<StockInfoDO>>();
		try {
			List<StockInfoDO> list = stockInfoDAO.getStockInfoList();
			result.setSuccess(true);
			result.setDefaultModel(list);
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error("StockAdminServiceImpl.getStockInfoList", e);
		}
		return result;
	}

	public StockAnalyzerSpiderManager getStockAnalyzerSpiderManager() {
		return stockAnalyzerSpiderManager;
	}

	public void setStockAnalyzerSpiderManager(
			StockAnalyzerSpiderManager stockAnalyzerSpiderManager) {
		this.stockAnalyzerSpiderManager = stockAnalyzerSpiderManager;
	}

	public StockPriceDAO getStockPriceDAO() {
		return stockPriceDAO;
	}

	public void setStockPriceDAO(StockPriceDAO stockPriceDAO) {
		this.stockPriceDAO = stockPriceDAO;
	}

	public StockInfoDAO getStockInfoDAO() {
		return stockInfoDAO;
	}

	public void setStockInfoDAO(StockInfoDAO stockInfoDAO) {
		this.stockInfoDAO = stockInfoDAO;
	}

}

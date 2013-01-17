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
import com.jiangjianan.stock.server.service.AnalyzerAdminService;

public class AnalyzerAdminServiceImpl extends BaseService implements
		AnalyzerAdminService {

	private StockAnalyzerSpiderManager stockAnalyzerSpiderManager;
	private StockInfoDAO stockInfoDAO;
	private StockPriceDAO stockPriceDAO;

	public Result<Boolean> insertStockInfo(String code) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			StockInfoDO stockInfoDO = stockAnalyzerSpiderManager
					.getStockInfo(code);
			if (stockInfoDO != null) {
				StockInfoDO stockInfoDOInDb = stockInfoDAO
						.getStockInfoByCode(code);
				if (stockInfoDOInDb == null) {
					stockInfoDAO.insertStockInfo(stockInfoDO);
					result.setSuccess(true);
				} else {
					result.setSuccess(false);
				}
			} else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error("StockAdminServiceImpl.insertStockInfo", e);
		}
		return result;
	}

	public Result<Boolean> deleteStockInfo(String code) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			stockInfoDAO.deleteStockInfoByCode(code);
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error("StockAdminServiceImpl.deleteStockInfo", e);
		}
		return result;
	}

	@Override
	public Result<Boolean> udpateStockPrice(StockPriceQuery query) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			List<StockPriceDO> list = stockAnalyzerSpiderManager.getStockPrice(
					query.getCode(), query.getStartDate(), query.getEndDate());
			
			for (StockPriceDO stockPriceDO : list) {
				stockPriceDAO.deleteStockPriceById(stockPriceDO.getId());
				stockPriceDAO.insertStockPrice(stockPriceDO);
			}
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error("StockAdminServiceImpl.deleteStockInfo", e);
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

	public StockInfoDAO getStockInfoDAO() {
		return stockInfoDAO;
	}

	public void setStockInfoDAO(StockInfoDAO stockInfoDAO) {
		this.stockInfoDAO = stockInfoDAO;
	}

	public StockPriceDAO getStockPriceDAO() {
		return stockPriceDAO;
	}

	public void setStockPriceDAO(StockPriceDAO stockPriceDAO) {
		this.stockPriceDAO = stockPriceDAO;
	}

}

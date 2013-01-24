package com.jiangjianan.stock.server.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jiangjianan.stock.server.common.service.BaseService;
import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.common.service.ResultSupport;
import com.jiangjianan.stock.server.dao.StockInfoDAO;
import com.jiangjianan.stock.server.dao.StockPriceDAO;
import com.jiangjianan.stock.server.dao.StockReportDAO;
import com.jiangjianan.stock.server.manager.StockAnalyzerSpiderManager;
import com.jiangjianan.stock.server.object.StockInfoDO;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.object.StockReportDO;
import com.jiangjianan.stock.server.query.StockPriceQuery;
import com.jiangjianan.stock.server.service.StockAnalyzerService;

public class StockAnalyzerServiceImpl extends BaseService implements
		StockAnalyzerService {

	private StockAnalyzerSpiderManager stockAnalyzerSpiderManager;
	private StockInfoDAO stockInfoDAO;
	private StockPriceDAO stockPriceDAO;
	private StockReportDAO stockReportDAO;

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
			logger.error("StockAnalyzerServiceImpl.udpateStockPrice", e);
		}
		return result;
	}

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
			logger.error("StockAnalyzerServiceImpl.getStockPriceList", e);
		}
		return result;
	}

	@Override
	public Result<List<StockReportDO>> getStockReportList(String code) {
		Result<List<StockReportDO>> result = new ResultSupport<List<StockReportDO>>();
		try {
			List<StockReportDO> list = stockReportDAO
					.getStockReportListByCode(code);
			result.setSuccess(true);
			result.setDefaultModel(list);
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error("StockAnalyzerServiceImpl.getStockReportList", e);
		}
		return result;
	}

	@Override
	public Result<Boolean> udpateStockReport(String code) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			List<StockReportDO> list = stockAnalyzerSpiderManager
					.getStockReport(code);
			List<StockReportDO> dbList = stockReportDAO
					.getStockReportListByCode(code);
			Set<Long> codeSet = new HashSet<Long>();
			for (StockReportDO stockReport : dbList) {
				codeSet.add(stockReport.getDate());
			}
			for (StockReportDO stockReport : list) {
				if (!codeSet.contains(codeSet)) {
					stockReportDAO.insertStockReport(stockReport);
				}
			}
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error("StockAnalyzerServiceImpl.udpateStockReport", e);
		}
		return result;
	}

	@Override
	public Result<Boolean> updateAllStockReport() {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			List<StockInfoDO> list = stockInfoDAO.getStockInfoList();
			for (StockInfoDO stockInfo : list) {
				udpateStockReport(stockInfo.getCode());
			}
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error("StockAnalyzerServiceImpl.udpateAllStockReport", e);
		}
		return result;
	}

	@Override
	public Result<Boolean> updateAllStockPrice() {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			List<StockInfoDO> list = stockInfoDAO.getStockInfoList();
			for (StockInfoDO stockInfo : list) {
				StockPriceQuery query = new StockPriceQuery();
				query.setCode(stockInfo.getCode());
				query.setStartDate(19990101L);
				query.setEndDate(20130114L);
				udpateStockPrice(query);
			}
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error("StockAnalyzerServiceImpl.udpateAllStockPrice", e);
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

	public StockReportDAO getStockReportDAO() {
		return stockReportDAO;
	}

	public void setStockReportDAO(StockReportDAO stockReportDAO) {
		this.stockReportDAO = stockReportDAO;
	}

}

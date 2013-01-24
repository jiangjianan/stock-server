package com.jiangjianan.stock.server.service.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.jiangjianan.stock.server.common.service.BaseService;
import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.common.service.ResultSupport;
import com.jiangjianan.stock.server.dao.StockAttentionDAO;
import com.jiangjianan.stock.server.manager.StockAnalyzerSpiderManager;
import com.jiangjianan.stock.server.object.StockAttentionDO;
import com.jiangjianan.stock.server.object.StockInfoDO;
import com.jiangjianan.stock.server.service.StockAttentionService;

public class StockAttentionServiceImpl extends BaseService implements
		StockAttentionService {

	private StockAttentionDAO stockAttentionDAO;
	private StockAnalyzerSpiderManager stockAnalyzerSpiderManager;

	@Override
	public Result<List<StockAttentionDO>> getStockAttentionListByUserId(
			Long userId) {
		Result<List<StockAttentionDO>> result = new ResultSupport<List<StockAttentionDO>>();
		try {
			List<StockAttentionDO> list = stockAttentionDAO
					.getStockAttentionListByUserId(userId);
			result.setDefaultModel(list);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error(
					"StockAttentionServiceImpl.getStockAttentionListByUserId",
					e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<Boolean> insertStockAttention(
			StockAttentionDO stockAttentionDO) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			StockInfoDO stockInfoDO = stockAnalyzerSpiderManager
					.getStockInfo(stockAttentionDO.getCode());
			if (stockInfoDO != null) {
				stockAttentionDO.setName(stockInfoDO.getName());
				stockAttentionDAO.insertStockAttention(stockAttentionDO);
				result.setSuccess(true);
			} else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("StockAttentionServiceImpl.InsertStockAttention", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<Boolean> deleteStockAttentionById(Long id) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			stockAttentionDAO.deleteStockAttentionById(id);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("StockAttentionServiceImpl.deleteStockAttentionById",
					e);
			result.setSuccess(false);
		}
		return result;
	}

	public StockAttentionDAO getStockAttentionDAO() {
		return stockAttentionDAO;
	}

	public void setStockAttentionDAO(StockAttentionDAO stockAttentionDAO) {
		this.stockAttentionDAO = stockAttentionDAO;
	}

	public StockAnalyzerSpiderManager getStockAnalyzerSpiderManager() {
		return stockAnalyzerSpiderManager;
	}

	public void setStockAnalyzerSpiderManager(
			StockAnalyzerSpiderManager stockAnalyzerSpiderManager) {
		this.stockAnalyzerSpiderManager = stockAnalyzerSpiderManager;
	}

}

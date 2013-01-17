//package com.jiangjianan.stock.server.service.impl;
//
//import java.util.List;
//
//import com.jiangjianan.stock.server.common.service.BaseService;
//import com.jiangjianan.stock.server.common.service.Result;
//import com.jiangjianan.stock.server.common.service.ResultSupport;
//import com.jiangjianan.stock.server.dao.StockAttentionDAO;
//import com.jiangjianan.stock.server.object.StockAttentionDO;
//import com.jiangjianan.stock.server.service.StockAttentionService;
//
//public class StockAttentionServiceImpl extends BaseService implements
//		StockAttentionService {
//
//	private StockAttentionDAO stockAttentionDAO;
//
//	@Override
//	public Result<List<StockAttentionDO>> getStockAttentionList() {
//		Result<List<StockAttentionDO>> result = new ResultSupport<List<StockAttentionDO>>());
//		try {
//			List<StockAttentionDO> list = stockAttentionDAO.getStockAttentionListByUserId(null);
//			result.setDefaultModel(list);
//			result.setSuccess(true);
//		} catch(Exception e) {
//			logger.error("StockAttentionServiceImpl.StockAttentionServiceImpl", e);
//			result.setSuccess(false);
//		}
//		return result;
//	}
//
//	@Override
//	public Result<Boolean> InsertStockAttention(
//			StockAttentionDO stockAttentionDO) {
//		Result<List<StockAttentionDO>> result = new ResultSupport<List<StockAttentionDO>>());
//		try {
//			List<StockAttentionDO> list = stockAttentionDAO.getStockAttentionListByUserId(null);
//			result.setDefaultModel(list);
//			result.setSuccess(true);
//		} catch(Exception e) {
//			logger.error("StockAttentionServiceImpl.StockAttentionServiceImpl", e);
//			result.setSuccess(false);
//		}
//		return result;
//	}
//
//	@Override
//	public Result<Boolean> deleteStockAttentionById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public StockAttentionDAO getStockAttentionDAO() {
//		return stockAttentionDAO;
//	}
//
//	public void setStockAttentionDAO(StockAttentionDAO stockAttentionDAO) {
//		this.stockAttentionDAO = stockAttentionDAO;
//	}
//
//}

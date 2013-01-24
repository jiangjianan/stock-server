package com.jiangjianan.stock.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jiangjianan.stock.server.common.service.BaseService;
import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.common.service.ResultSupport;
import com.jiangjianan.stock.server.dao.StockAnnouncementDAO;
import com.jiangjianan.stock.server.dao.StockAttentionDAO;
import com.jiangjianan.stock.server.dao.StockInfoDAO;
import com.jiangjianan.stock.server.manager.StockAnnouncementSpiderManager;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;
import com.jiangjianan.stock.server.query.StockAnnouncementPageQuery;
import com.jiangjianan.stock.server.service.StockAnnouncementService;

public class StockAnnouncementServiceImpl extends BaseService implements
		StockAnnouncementService {

	private StockAnnouncementSpiderManager stockAnnouncementSpiderManager;
	private StockAnnouncementDAO stockAnnouncementDAO;
	private StockInfoDAO stockInfoDAO;
	private StockAttentionDAO stockAttentionDAO;

	@Override
	public Result<Boolean> updateStockAnnouncementByCode(String code) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			// ��ȡ���һ��Ĺ�������
			List<StockAnnouncementDO> dbList = stockAnnouncementDAO
					.getStockAnnouncementListByCode(code);
			long date = 20130101;
			Map<String, StockAnnouncementDO> dbLastDateMap = new HashMap<String, StockAnnouncementDO>();
			if (dbList.size() > 0) {
				date = dbList.get(0).getDate();
				for (StockAnnouncementDO stockAnnouncement : dbList) {
					if (stockAnnouncement.getDate() == date) {
						dbLastDateMap.put(stockAnnouncement.getUrl(),
								stockAnnouncement);
					} else {
						break;
					}
				}
			}

			// ����ץȡ���µĹ������ݣ��������¸��µ�����
			List<StockAnnouncementDO> newList = stockAnnouncementSpiderManager
					.getStockAnnouncementList(code);
			for (StockAnnouncementDO stockAnnouncement : newList) {
				if (stockAnnouncement.getDate() >= date) {
					if (!dbLastDateMap.containsKey(stockAnnouncement.getUrl())) {
						stockAnnouncementDAO
								.insertStockAnnouncement(stockAnnouncement);
					}
				}
			}
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error(
					"StockAnnouncemetServiceImpl.updateStockAnnouncementByCode",
					e);
		}
		return result;
	}

	@Override
	public Result<Boolean> deleteStockAnnouncementById(Long id) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			stockAnnouncementDAO.deleteStockAnnouncementById(id);
		} catch (Exception e) {
			result.setSuccess(false);
			logger.error(
					"StockAnnouncementSpiderImplManager.deleteStockAnnouncementById",
					e);
		}
		return result;
	}

	@Override
	public Result<Boolean> updateAllStockAnnouncement() {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			List<String> list = stockAttentionDAO
					.getStockAttentionListCodeList();
			for (String code : list) {
				updateStockAnnouncementByCode(code);
			}
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error(
					"StockAnnouncementSpiderImplManager.updateAllStockAnnouncement",
					e);
			result.setSuccess(false);
		}
		return result;
	}

	public Result<StockAnnouncementPageQuery> getStockAnnouncementList(
			StockAnnouncementPageQuery query) {
		Result<StockAnnouncementPageQuery> result = new ResultSupport<StockAnnouncementPageQuery>();
		try {
			query = stockAnnouncementDAO
					.getStockAnnouncementListByPageQuery(query);
			result.setDefaultModel(query);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error(
					"StockAnnouncementSpiderImplManager.getRecentStockAnnouncementList",
					e);
			result.setSuccess(false);
		}
		return result;
	}

	public StockAnnouncementSpiderManager getStockAnnouncementSpiderManager() {
		return stockAnnouncementSpiderManager;
	}

	public void setStockAnnouncementSpiderManager(
			StockAnnouncementSpiderManager stockAnnouncementSpiderManager) {
		this.stockAnnouncementSpiderManager = stockAnnouncementSpiderManager;
	}

	public StockAnnouncementDAO getStockAnnouncementDAO() {
		return stockAnnouncementDAO;
	}

	public void setStockAnnouncementDAO(
			StockAnnouncementDAO stockAnnouncementDAO) {
		this.stockAnnouncementDAO = stockAnnouncementDAO;
	}

	public StockInfoDAO getStockInfoDAO() {
		return stockInfoDAO;
	}

	public void setStockInfoDAO(StockInfoDAO stockInfoDAO) {
		this.stockInfoDAO = stockInfoDAO;
	}

	public StockAttentionDAO getStockAttentionDAO() {
		return stockAttentionDAO;
	}

	public void setStockAttentionDAO(StockAttentionDAO stockAttentionDAO) {
		this.stockAttentionDAO = stockAttentionDAO;
	}

}

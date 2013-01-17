package com.jiangjianan.stock.server.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jiangjianan.stock.server.dao.StockAnnouncementDAO;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;

@SuppressWarnings("deprecation")
public class StockAnnouncementDAOImpl extends SqlMapClientDaoSupport implements
		StockAnnouncementDAO {

	@Override
	public void insertStockAnnouncement(StockAnnouncementDO stockAnnouncementDO) {
		this.getSqlMapClientTemplate().insert(
				"stockAnnouncementDAO.insertStockAnnouncement",
				stockAnnouncementDO);
	}

	@Override
	public void deleteStockAnnouncementById(Long id) {
		this.getSqlMapClientTemplate().delete(
				"stockAnnouncementDAO.deleteStockAnnouncementById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockAnnouncementDO> getStockAnnouncementListByCode(String code) {
		return (List<StockAnnouncementDO>) this.getSqlMapClientTemplate()
				.queryForList(
						"stockAnnouncementDAO.getStockAnnouncementListByCode",
						code);
	}

	@Override
	public StockAnnouncementDO getStockAnnouncementById(Long id) {
		return (StockAnnouncementDO) this.getSqlMapClientTemplate()
				.queryForObject(
						"stockAnnouncementDAO.getStockAnnouncementById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockAnnouncementDO> getRecentStockAnnouncementList(
			Long startDate) {
		return (List<StockAnnouncementDO>) this.getSqlMapClientTemplate()
				.queryForList(
						"stockAnnouncementDAO.getRecentStockAnnouncementList",
						startDate);
	}

}

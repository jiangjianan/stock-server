package com.jiangjianan.stock.server.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jiangjianan.stock.server.dao.StockReportDAO;
import com.jiangjianan.stock.server.object.StockReportDO;

@SuppressWarnings("deprecation")
public class StockReportDAOImpl extends SqlMapClientDaoSupport implements
		StockReportDAO {

	@Override
	public StockReportDO getStockReportById(String id) {
		return (StockReportDO) this.getSqlMapClientTemplate().queryForObject(
				"stockReportDAO.getStockReportById", id);
	}

	@Override
	public void insertStockReport(StockReportDO stockReportDO) {
		this.getSqlMapClientTemplate().insert(
				"stockReportDAO.insertStockReport", stockReportDO);
	}

	@Override
	public void deleteStockReportById(String id) {
		this.getSqlMapClientTemplate().delete(
				"stockReportDAO.deleteStockReportById", id);
	}

	@Override
	public void deleteStockReportByCode(String code) {
		this.getSqlMapClientTemplate().delete(
				"stockReportDAO.deleteStockReportByCode", code);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockReportDO> getStockReportListByCode(String code) {
		return (List<StockReportDO>) this.getSqlMapClientTemplate()
				.queryForList("stockReportDAO.getStockReportListByCode", code);
	}

}

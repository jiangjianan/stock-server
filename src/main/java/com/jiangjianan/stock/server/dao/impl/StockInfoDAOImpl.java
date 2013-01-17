package com.jiangjianan.stock.server.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jiangjianan.stock.server.dao.StockInfoDAO;
import com.jiangjianan.stock.server.object.StockInfoDO;

@SuppressWarnings("deprecation")
public class StockInfoDAOImpl extends SqlMapClientDaoSupport implements
		StockInfoDAO {

	@Override
	public void insertStockInfo(StockInfoDO stockInfoDO) {
		this.getSqlMapClientTemplate().insert("stockInfoDAO.insertStockInfo",
				stockInfoDO);
	}

	@Override
	public void deleteStockInfoByCode(String code) {
		this.getSqlMapClientTemplate().delete(
				"stockInfoDAO.deleteStockInfoByCode", code);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockInfoDO> getStockInfoList() {
		return (List<StockInfoDO>) this.getSqlMapClientTemplate().queryForList(
				"stockInfoDAO.getStockInfoList");
	}

	@Override
	public StockInfoDO getStockInfoByCode(String code) {
		return (StockInfoDO) this.getSqlMapClientTemplate().queryForObject(
				"stockInfoDAO.getStockInfoByCode", code);
	}

}

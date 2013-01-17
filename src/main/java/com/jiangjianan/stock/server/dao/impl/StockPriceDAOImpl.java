package com.jiangjianan.stock.server.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jiangjianan.stock.server.dao.StockPriceDAO;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.query.StockPriceQuery;

@SuppressWarnings("deprecation")
public class StockPriceDAOImpl extends SqlMapClientDaoSupport implements
		StockPriceDAO {

	@Override
	public void insertStockPrice(StockPriceDO stockPriceDO) {
		this.getSqlMapClientTemplate().insert("stockPriceDAO.insertStockPrice",
				stockPriceDO);
	}

	@Override
	public void deleteStockPriceById(String id) {
		this.getSqlMapClientTemplate().delete(
				"stockPriceDAO.deleteStockPriceById", id);
	}

	@Override
	public StockPriceDO getStockPriceById(String id) {
		return (StockPriceDO) this.getSqlMapClientTemplate().queryForObject(
				"stockPriceDAO.getStockPriceById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockPriceDO> getStockPriceListByQuery(
			StockPriceQuery stockPriceQuery) {
		return ((List<StockPriceDO>) this.getSqlMapClientTemplate()
				.queryForList("stockPriceDAO.getStockPriceListByQuery",
						stockPriceQuery));
	}
}

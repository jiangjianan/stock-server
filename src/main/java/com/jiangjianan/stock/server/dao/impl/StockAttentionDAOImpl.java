package com.jiangjianan.stock.server.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jiangjianan.stock.server.dao.StockAttentionDAO;
import com.jiangjianan.stock.server.object.StockAttentionDO;

@SuppressWarnings("deprecation")
public class StockAttentionDAOImpl extends SqlMapClientDaoSupport implements
		StockAttentionDAO {

	@Override
	public void insertStockAttention(StockAttentionDO stockAttentionDO) {
		this.getSqlMapClientTemplate().insert(
				"stockAttentionDAO.insertStockAttention", stockAttentionDO);
	}

	@Override
	public void deleteStockAttentionById(Long id) {
		this.getSqlMapClientTemplate().delete(
				"stockAttentionDAO.deleteStockAttentionById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockAttentionDO> getStockAttentionListByUserId(Long userId) {
		return (List<StockAttentionDO>) this
				.getSqlMapClientTemplate()
				.queryForList("stockAttentionDAO.getStockAttentionListByUserId");
	}

	@Override
	public StockAttentionDO getStockAttentionById(Long id) {
		return (StockAttentionDO) this.getSqlMapClientTemplate()
				.queryForObject("stockAttentionDAO.getStockAttentionById", id);
	}

}

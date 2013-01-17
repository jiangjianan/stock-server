package com.jiangjianan.stock.server.dao;

import java.util.List;

import com.jiangjianan.stock.server.object.StockAttentionDO;

public interface StockAttentionDAO {

	public void insertStockAttention(StockAttentionDO stockAttentionDO);

	public void deleteStockAttentionById(Long id);

	public List<StockAttentionDO> getStockAttentionListByUserId(Long userId);

	public StockAttentionDO getStockAttentionById(Long id);

}

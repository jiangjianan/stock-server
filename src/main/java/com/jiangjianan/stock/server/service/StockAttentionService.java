package com.jiangjianan.stock.server.service;

import java.util.List;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockAttentionDO;

public interface StockAttentionService {
	public Result<List<StockAttentionDO>> getStockAttentionListByUserId(Long userId);

	public Result<Boolean> insertStockAttention(StockAttentionDO stockAttentionDO);

	public Result<Boolean> deleteStockAttentionById(Long id);
}

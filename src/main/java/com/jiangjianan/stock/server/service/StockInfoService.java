package com.jiangjianan.stock.server.service;

import java.util.List;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockInfoDO;

public interface StockInfoService {
	public Result<Boolean> insertStockInfo(String code);

	public Result<Boolean> deleteStockInfo(String code);

	public Result<List<StockInfoDO>> getStockInfoList();
}

package com.jiangjianan.stock.server.service;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.query.StockPriceQuery;

public interface AnalyzerAdminService {
	public Result<Boolean> insertStockInfo(String code);

	public Result<Boolean> deleteStockInfo(String code);

	public Result<Boolean> udpateStockPrice(StockPriceQuery query);
}

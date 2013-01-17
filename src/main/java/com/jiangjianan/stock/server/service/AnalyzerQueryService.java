package com.jiangjianan.stock.server.service;

import java.util.List;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockInfoDO;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.query.StockPriceQuery;

public interface AnalyzerQueryService {
	public Result<List<StockPriceDO>> getStockPriceList(
			StockPriceQuery stockPriceQuery);

	public Result<List<StockInfoDO>> getStockInfoList();
}

package com.jiangjianan.stock.server.service;

import java.util.List;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.object.StockReportDO;
import com.jiangjianan.stock.server.query.StockPriceQuery;

public interface StockAnalyzerService {
	public Result<Boolean> udpateStockPrice(StockPriceQuery query);

	public Result<List<StockPriceDO>> getStockPriceList(
			StockPriceQuery stockPriceQuery);

	public Result<List<StockReportDO>> getStockReportList(String code);

	public Result<Boolean> udpateStockReport(String code);

	public Result<Boolean> updateAllStockReport();

	public Result<Boolean> updateAllStockPrice();
}

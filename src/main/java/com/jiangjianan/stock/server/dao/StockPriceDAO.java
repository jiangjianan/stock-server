package com.jiangjianan.stock.server.dao;

import java.util.List;

import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.query.StockPriceQuery;

public interface StockPriceDAO {

	public void insertStockPrice(StockPriceDO stockPriceDO);

	public void deleteStockPriceById(String id);

	public StockPriceDO getStockPriceById(String id);

	public List<StockPriceDO> getStockPriceListByQuery(
			StockPriceQuery stockPriceQuery);

}

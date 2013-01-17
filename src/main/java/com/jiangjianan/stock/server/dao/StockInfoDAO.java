package com.jiangjianan.stock.server.dao;

import java.util.List;

import com.jiangjianan.stock.server.object.StockInfoDO;

public interface StockInfoDAO {

	public void insertStockInfo(StockInfoDO stockInfoDO);

	public void deleteStockInfoByCode(String code);

	public List<StockInfoDO> getStockInfoList();
	
	public StockInfoDO getStockInfoByCode(String code);


}

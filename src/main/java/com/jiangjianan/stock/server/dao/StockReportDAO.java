package com.jiangjianan.stock.server.dao;

import java.util.List;

import com.jiangjianan.stock.server.object.StockReportDO;

public interface StockReportDAO {

	public StockReportDO getStockReportById(String id);

	public void insertStockReport(StockReportDO stockReportDO);

	public void deleteStockReportById(String id);

	public void deleteStockReportByCode(String code);

	public List<StockReportDO> getStockReportListByCode(String code);

}

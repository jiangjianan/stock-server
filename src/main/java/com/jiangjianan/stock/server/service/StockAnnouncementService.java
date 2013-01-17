package com.jiangjianan.stock.server.service;

import java.util.List;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;

public interface StockAnnouncementService {
	public Result<List<StockAnnouncementDO>> getStockAnnouncementListByCode(
			String code);

	public Result<Boolean> updateStockAnnouncementByCode(String code);

	public Result<Boolean> deleteStockAnnouncementById(Long delete);
	
	public Result<Boolean> updateAllStockAnnouncement();
	
	public Result<List<StockAnnouncementDO>> getRecentStockAnnouncementList(Long startDate);
}

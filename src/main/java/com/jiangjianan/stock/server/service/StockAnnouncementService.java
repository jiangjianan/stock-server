package com.jiangjianan.stock.server.service;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.query.StockAnnouncementPageQuery;

public interface StockAnnouncementService {

	public Result<Boolean> updateStockAnnouncementByCode(String code);

	public Result<Boolean> deleteStockAnnouncementById(Long delete);

	public Result<Boolean> updateAllStockAnnouncement();

	public Result<StockAnnouncementPageQuery> getStockAnnouncementList(
			StockAnnouncementPageQuery query);
}

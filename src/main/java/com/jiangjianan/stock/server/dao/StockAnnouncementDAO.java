package com.jiangjianan.stock.server.dao;

import java.util.List;

import com.jiangjianan.stock.server.object.StockAnnouncementDO;
import com.jiangjianan.stock.server.query.StockAnnouncementPageQuery;

public interface StockAnnouncementDAO {

	public void insertStockAnnouncement(StockAnnouncementDO stockAnnouncementDO);

	public void deleteStockAnnouncementById(Long id);

	public List<StockAnnouncementDO> getStockAnnouncementListByCode(String code);

	public List<StockAnnouncementDO> getRecentStockAnnouncementList(
			Long startDate);

	public StockAnnouncementDO getStockAnnouncementById(Long id);

	public StockAnnouncementPageQuery getStockAnnouncementListByPageQuery(
			StockAnnouncementPageQuery query);

}

package com.jiangjianan.stock.server.dao;

import java.util.List;

import com.jiangjianan.stock.server.object.StockAnnouncementDO;

public interface StockAnnouncementDAO {

	public void insertStockAnnouncement(StockAnnouncementDO stockAnnouncementDO);

	public void deleteStockAnnouncementById(Long id);

	public List<StockAnnouncementDO> getStockAnnouncementListByCode(String code);
	
	public List<StockAnnouncementDO> getRecentStockAnnouncementList(Long startDate);
	
	public StockAnnouncementDO getStockAnnouncementById(Long id);

}

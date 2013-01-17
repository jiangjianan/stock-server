package com.jiangjianan.stock.server.manager;

import java.util.List;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;

public interface StockAnnouncementSpiderManager {
	public List<StockAnnouncementDO> getStockAnnouncementList(String code)
			throws ManagerException;

}

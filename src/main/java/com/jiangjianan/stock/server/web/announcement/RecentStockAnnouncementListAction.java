package com.jiangjianan.stock.server.web.announcement;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;
import com.jiangjianan.stock.server.service.StockAnnouncementService;
import com.jiangjianan.stock.server.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class RecentStockAnnouncementListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAnnouncementService stockAnnouncementService;

	private List<StockAnnouncementDO> stockAnnouncementList;

	public String execute() throws Exception {
		long time = System.currentTimeMillis();
		time -= 3 * 24 * 60 * 60 * 1000L;
		Date date = new Date(time);
		Result<List<StockAnnouncementDO>> result = stockAnnouncementService
				.getRecentStockAnnouncementList(Long.valueOf(DateUtil.dateToString(date)));
		if (result.isSuccess()) {
			stockAnnouncementList = result.getDefaultModel();
		}
		return SUCCESS;
	}

	public StockAnnouncementService getStockAnnouncementService() {
		return stockAnnouncementService;
	}

	public void setStockAnnouncementService(
			StockAnnouncementService stockAnnouncementService) {
		this.stockAnnouncementService = stockAnnouncementService;
	}

	public List<StockAnnouncementDO> getStockAnnouncementList() {
		return stockAnnouncementList;
	}

	public void setStockAnnouncementList(
			List<StockAnnouncementDO> stockAnnouncementList) {
		this.stockAnnouncementList = stockAnnouncementList;
	}

}

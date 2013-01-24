package com.jiangjianan.stock.server.web.announcement;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.service.StockAnnouncementService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Results({ @Result(location = "../attention/stock-attention-list", type = "redirectAction") })
public class UpdateAllStockAnnouncementAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAnnouncementService stockAnnouncementService;

	public String execute() throws Exception {
		new UpdateThread().start();
		return SUCCESS;
	}

	class UpdateThread extends Thread {
		@Override
		public void run() {
			stockAnnouncementService.updateAllStockAnnouncement();
		}
	}

	public StockAnnouncementService getStockAnnouncementService() {
		return stockAnnouncementService;
	}

	public void setStockAnnouncementService(
			StockAnnouncementService stockAnnouncementService) {
		this.stockAnnouncementService = stockAnnouncementService;
	}
}

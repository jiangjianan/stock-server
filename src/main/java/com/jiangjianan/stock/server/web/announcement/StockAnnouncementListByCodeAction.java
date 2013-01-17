package com.jiangjianan.stock.server.web.announcement;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;
import com.jiangjianan.stock.server.service.StockAnnouncementService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class StockAnnouncementListByCodeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAnnouncementService stockAnnouncementService;

	private List<StockAnnouncementDO> stockAnnouncementList;
	private String code;

	public String execute() throws Exception {
		Result<List<StockAnnouncementDO>> result = stockAnnouncementService
				.getStockAnnouncementListByCode(code);
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

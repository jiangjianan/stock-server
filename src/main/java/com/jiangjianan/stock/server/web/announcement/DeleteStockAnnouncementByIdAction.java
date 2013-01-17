package com.jiangjianan.stock.server.web.announcement;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.service.StockAnnouncementService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Results({ @Result(location = "stock-announcement-list-by-code", type = "redirectAction", params = {
		"code", "${code}" }) })
public class DeleteStockAnnouncementByIdAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAnnouncementService stockAnnouncementService;

	private Long id;
	private String code;

	public String execute() throws Exception {
		stockAnnouncementService.deleteStockAnnouncementById(id);
		return SUCCESS;
	}

	public StockAnnouncementService getStockAnnouncementService() {
		return stockAnnouncementService;
	}

	public void setStockAnnouncementService(
			StockAnnouncementService stockAnnouncementService) {
		this.stockAnnouncementService = stockAnnouncementService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

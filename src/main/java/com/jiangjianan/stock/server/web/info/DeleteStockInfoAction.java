package com.jiangjianan.stock.server.web.info;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.service.StockInfoService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Results({ @Result(location = "stock-info-list", type = "redirectAction") })
public class DeleteStockInfoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockInfoService stockInfoService;

	private String code;

	public String execute() throws Exception {
		stockInfoService.deleteStockInfo(code);
		return SUCCESS;
	}

	public StockInfoService getStockInfoService() {
		return stockInfoService;
	}

	public void setStockInfoService(StockInfoService stockInfoService) {
		this.stockInfoService = stockInfoService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

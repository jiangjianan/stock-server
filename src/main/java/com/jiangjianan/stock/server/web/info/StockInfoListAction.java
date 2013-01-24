package com.jiangjianan.stock.server.web.info;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockInfoDO;
import com.jiangjianan.stock.server.service.StockInfoService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class StockInfoListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockInfoService stockInfoService;

	private List<StockInfoDO> stockInfoList;

	public String execute() throws Exception {
		Result<List<StockInfoDO>> result = stockInfoService.getStockInfoList();
		if (result.isSuccess()) {
			stockInfoList = result.getDefaultModel();
		}
		return SUCCESS;
	}

	public StockInfoService getStockInfoService() {
		return stockInfoService;
	}

	public void setStockInfoService(StockInfoService stockInfoService) {
		this.stockInfoService = stockInfoService;
	}

	public List<StockInfoDO> getStockInfoList() {
		return stockInfoList;
	}

	public void setStockInfoList(List<StockInfoDO> stockInfoList) {
		this.stockInfoList = stockInfoList;
	}

}

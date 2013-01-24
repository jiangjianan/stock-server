package com.jiangjianan.stock.server.web.analyzer;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.query.StockPriceQuery;
import com.jiangjianan.stock.server.service.StockAnalyzerService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class StockPriceListByCodeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAnalyzerService stockAnalyzerService;

	private List<StockPriceDO> stockPriceList;
	private String code;
	private Long startDate;
	private Long endDate;

	public String execute() throws Exception {
		StockPriceQuery query = new StockPriceQuery();
		startDate = 20130101L;
		query.setCode(code);
		query.setStartDate(startDate);
		query.setEndDate(endDate);
		Result<List<StockPriceDO>> result = stockAnalyzerService
				.getStockPriceList(query);
		if (result.isSuccess()) {
			stockPriceList = result.getDefaultModel();
		}
		return SUCCESS;
	}

	public StockAnalyzerService getStockAnalyzerService() {
		return stockAnalyzerService;
	}

	public void setStockAnalyzerService(
			StockAnalyzerService stockAnalyzerService) {
		this.stockAnalyzerService = stockAnalyzerService;
	}

	public List<StockPriceDO> getStockPriceList() {
		return stockPriceList;
	}

	public void setStockPriceList(List<StockPriceDO> stockPriceList) {
		this.stockPriceList = stockPriceList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

}

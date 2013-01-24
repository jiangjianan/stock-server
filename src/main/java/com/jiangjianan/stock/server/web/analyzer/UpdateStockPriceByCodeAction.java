package com.jiangjianan.stock.server.web.analyzer;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.query.StockPriceQuery;
import com.jiangjianan.stock.server.service.StockAnalyzerService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Results({ @Result(location = "../info/stock-info-list", type = "redirectAction") })
public class UpdateStockPriceByCodeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAnalyzerService stockAnalyzerService;

	private String code;
	private Long startDate;
	private Long endDate;

	public String execute() throws Exception {
		new UpdateThread().start();
		return SUCCESS;
	}

	class UpdateThread extends Thread {
		@Override
		public void run() {
			StockPriceQuery query = new StockPriceQuery();
			query.setCode(code);
			query.setStartDate(19990101L);
			query.setEndDate(20130114L);
			stockAnalyzerService.udpateStockPrice(query);
		}

	}

	public StockAnalyzerService getStockAnalyzerService() {
		return stockAnalyzerService;
	}

	public void setStockAnalyzerService(
			StockAnalyzerService stockAnalyzerService) {
		this.stockAnalyzerService = stockAnalyzerService;
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

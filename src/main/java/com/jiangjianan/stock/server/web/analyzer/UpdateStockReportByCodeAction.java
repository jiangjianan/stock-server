package com.jiangjianan.stock.server.web.analyzer;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.service.StockAnalyzerService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Results({ @Result(location = "stock-report-list-by-code", type = "redirectAction") })
public class UpdateStockReportByCodeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAnalyzerService stockAnalyzerService;

	private String code;

	public String execute() throws Exception {
		new UpdateThread().start();
		return SUCCESS;
	}

	class UpdateThread extends Thread {
		@Override
		public void run() {
			stockAnalyzerService.udpateStockReport(code);
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

}

package com.jiangjianan.stock.server.web.analyzer;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockReportDO;
import com.jiangjianan.stock.server.service.StockAnalyzerService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class StockReportListByCodeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAnalyzerService stockAnalyzerService;

	private List<StockReportDO> stockReportList;
	private String code;

	public String execute() throws Exception {
		Result<List<StockReportDO>> result = stockAnalyzerService
				.getStockReportList(code);
		if (result.isSuccess()) {
			stockReportList = result.getDefaultModel();
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

	public List<StockReportDO> getStockReportList() {
		return stockReportList;
	}

	public void setStockReportList(List<StockReportDO> stockReportList) {
		this.stockReportList = stockReportList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

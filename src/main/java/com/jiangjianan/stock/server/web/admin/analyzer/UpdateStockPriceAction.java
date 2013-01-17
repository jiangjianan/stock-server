package com.jiangjianan.stock.server.web.admin.analyzer;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.query.StockPriceQuery;
import com.jiangjianan.stock.server.service.AnalyzerAdminService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Results({ @Result(location = "stock-info-list", type = "redirectAction") })
public class UpdateStockPriceAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnalyzerAdminService analyzerAdminService;

	private String code;

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
			analyzerAdminService.udpateStockPrice(query);
		}

	}

	public AnalyzerAdminService getAnalyzerAdminService() {
		return analyzerAdminService;
	}

	public void setAnalyzerAdminService(
			AnalyzerAdminService analyzerAdminService) {
		this.analyzerAdminService = analyzerAdminService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

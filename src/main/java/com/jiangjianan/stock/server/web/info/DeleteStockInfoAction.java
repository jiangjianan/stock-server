package com.jiangjianan.stock.server.web.info;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.service.AnalyzerAdminService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Results({ @Result(location = "stock-info-list", type = "redirectAction") })
public class DeleteStockInfoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnalyzerAdminService analyzerAdminService;

	private String code;

	public String execute() throws Exception {
		analyzerAdminService.deleteStockInfo(code);
		return SUCCESS;
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

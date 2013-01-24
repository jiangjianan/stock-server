package com.jiangjianan.stock.server.web.announcement;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;
import com.jiangjianan.stock.server.query.StockAnnouncementPageQuery;
import com.jiangjianan.stock.server.service.StockAnnouncementService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class StockAnnouncementListByCodeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAnnouncementService stockAnnouncementService;

	private List<StockAnnouncementDO> stockAnnouncementList;
	private String code;
	private int page;
	private int count;
	private int pageCount;

	public String execute() throws Exception {
		if (page == 0) {
			page = 1;
		}
		StockAnnouncementPageQuery query = new StockAnnouncementPageQuery();
		query.setCode(code);
		query.setPage(page);
		Result<StockAnnouncementPageQuery> result = stockAnnouncementService
				.getStockAnnouncementList(query);
		if (result.isSuccess()) {
			query = result.getDefaultModel();
			stockAnnouncementList = query.getList();
			count = query.getCount();
			pageCount = query.getPageCount();
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}

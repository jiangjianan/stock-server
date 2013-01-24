package com.jiangjianan.stock.server.web.attention;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.action.SessionAction;
import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.StockAttentionDO;
import com.jiangjianan.stock.server.object.UserDO;
import com.jiangjianan.stock.server.service.StockAttentionService;

@ParentPackage("struts-default")
public class StockAttentionListAction extends SessionAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAttentionService stockAttentionService;

	private List<StockAttentionDO> stockAttentionList;

	public String execute() throws Exception {
		UserDO userDO = (UserDO) session.get(SESSION_USER_KEY);
		if (userDO != null) {
			Result<List<StockAttentionDO>> result = stockAttentionService
					.getStockAttentionListByUserId(userDO.getId());
			if (result.isSuccess()) {
				stockAttentionList = result.getDefaultModel();
			}
		}
		return SUCCESS;
	}

	public List<StockAttentionDO> getStockAttentionList() {
		return stockAttentionList;
	}

	public void setStockAttentionList(List<StockAttentionDO> stockAttentionList) {
		this.stockAttentionList = stockAttentionList;
	}

	public StockAttentionService getStockAttentionService() {
		return stockAttentionService;
	}

	public void setStockAttentionService(
			StockAttentionService stockAttentionService) {
		this.stockAttentionService = stockAttentionService;
	}

}

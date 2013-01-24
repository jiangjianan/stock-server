package com.jiangjianan.stock.server.web.attention;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.action.SessionAction;
import com.jiangjianan.stock.server.object.StockAttentionDO;
import com.jiangjianan.stock.server.object.UserDO;
import com.jiangjianan.stock.server.service.StockAttentionService;

@ParentPackage("struts-default")
@Results({ @Result(location = "stock-attention-list", type = "redirectAction") })
public class InsertStockAttentionByCodeAction extends SessionAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StockAttentionService stockAttentionService;

	private String code;

	public String execute() throws Exception {
		UserDO userDO = (UserDO) session.get(SESSION_USER_KEY);
		if (userDO != null) {
			StockAttentionDO stockAttentionDO = new StockAttentionDO();
			stockAttentionDO.setUserId(userDO.getId());
			stockAttentionDO.setCode(code);
			stockAttentionService.insertStockAttention(stockAttentionDO);
		}
		return SUCCESS;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public StockAttentionService getStockAttentionService() {
		return stockAttentionService;
	}

	public void setStockAttentionService(
			StockAttentionService stockAttentionService) {
		this.stockAttentionService = stockAttentionService;
	}

}

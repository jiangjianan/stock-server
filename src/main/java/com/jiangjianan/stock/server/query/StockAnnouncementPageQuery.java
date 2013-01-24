package com.jiangjianan.stock.server.query;

import com.jiangjianan.stock.server.common.query.PageQuery;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;

public class StockAnnouncementPageQuery extends PageQuery<StockAnnouncementDO> {
	private String code;
	private Long startDate;

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

}

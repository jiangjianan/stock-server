package com.jiangjianan.stock.server.query;

import java.util.Date;

import com.jiangjianan.stock.server.common.query.PageQuery;
import com.jiangjianan.stock.server.object.ArticleDO;

public class ArticlePageQuery extends PageQuery<ArticleDO> {
	private String blogUid;

	private Date startDate;

	public String getBlogUid() {
		return blogUid;
	}

	public void setBlogUid(String blogUid) {
		this.blogUid = blogUid;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}

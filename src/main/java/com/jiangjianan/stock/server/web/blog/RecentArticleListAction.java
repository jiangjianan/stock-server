package com.jiangjianan.stock.server.web.blog;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class RecentArticleListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BlogService blogService;

	private List<ArticleDO> articleList;

	public String execute() throws Exception {
		long time = System.currentTimeMillis();
		time -= 3 * 24 * 60 * 60 * 1000L;
		Date date = new Date();
		date.setTime(time);
		Result<List<ArticleDO>> result = blogService.getRecentArticleList(date);
		if (result.isSuccess()) {
			articleList = result.getDefaultModel();
		}
		return SUCCESS;
	}

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public List<ArticleDO> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleDO> articleList) {
		this.articleList = articleList;
	}

}

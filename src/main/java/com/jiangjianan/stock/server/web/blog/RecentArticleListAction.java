package com.jiangjianan.stock.server.web.blog;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.query.ArticlePageQuery;
import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class RecentArticleListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BlogService blogService;

	private List<ArticleDO> articleList;
	private int page;
	private int pageCount;
	private int count;

	public String execute() throws Exception {
		if (page == 0) {
			page = 1;
		}
		long time = System.currentTimeMillis();
		time -= 7 * 24 * 60 * 60 * 1000L;
		Date startDate = new Date(time);
		ArticlePageQuery query = new ArticlePageQuery();
		query.setPage(page);
		query.setStartDate(startDate);
		Result<ArticlePageQuery> result = blogService.getArticleList(query);
		if (result.isSuccess()) {
			query = result.getDefaultModel();
			articleList = query.getList();
			count = query.getCount();
			pageCount = query.getPageCount();
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

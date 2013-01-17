package com.jiangjianan.stock.server.web.blog;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class ArticleListByBlogUidAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BlogService blogService;

	private List<ArticleDO> articleList;
	private String blogUid;

	public String execute() throws Exception {
		Result<List<ArticleDO>> result = blogService
				.getArticleListByBlogUid(blogUid);
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

	public String getBlogUid() {
		return blogUid;
	}

	public void setBlogUid(String blogUid) {
		this.blogUid = blogUid;
	}

}

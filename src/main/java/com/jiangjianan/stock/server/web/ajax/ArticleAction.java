package com.jiangjianan.stock.server.web.ajax;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default")
@Result(type = "json")
public class ArticleAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private boolean isSuccess;
	private String articleId;
	private ArticleDO articleDO;

	@Autowired
	private BlogService blogService;

	public String execute() throws Exception {
		com.jiangjianan.stock.server.common.service.Result<ArticleDO> result = blogService
				.getArticleById(articleId);
		isSuccess = result.isSuccess();
		articleDO = result.getDefaultModel();
		return SUCCESS;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public ArticleDO getArticleDO() {
		return articleDO;
	}

	public void setArticleDO(ArticleDO articleDO) {
		this.articleDO = articleDO;
	}

	@JSON(serialize = false)
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}

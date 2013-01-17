package com.jiangjianan.stock.server.web.ajax;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default")
@Result(type = "json")
public class BlogAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private boolean isSuccess;
	private String blogUid;
	private BlogDO blogDO;

	@Autowired
	private BlogService blogService;

	public String execute() throws Exception {
		com.jiangjianan.stock.server.common.service.Result<BlogDO> result = blogService
				.getBlogById(blogUid);
		isSuccess = result.isSuccess();
		blogDO = result.getDefaultModel();
		return SUCCESS;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getBlogUid() {
		return blogUid;
	}

	public void setBlogUid(String blogUid) {
		this.blogUid = blogUid;
	}

	public BlogDO getBlogDO() {
		return blogDO;
	}

	public void setBlogDO(BlogDO blogDO) {
		this.blogDO = blogDO;
	}

	@JSON(serialize = false)
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

}

package com.jiangjianan.stock.server.web.ajax;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default")
@Result(type = "json")
public class BlogListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private boolean isSuccess;
	private List<BlogDO> blogList;

	@Autowired
	private BlogService blogService;

	public String execute() throws Exception {
		com.jiangjianan.stock.server.common.service.Result<List<BlogDO>> result = blogService
				.getBlogList();
		isSuccess = result.isSuccess();
		if (result.isSuccess()) {
			blogList = result.getDefaultModel();
		}
		return SUCCESS;
	}

	public List<BlogDO> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<BlogDO> blogList) {
		this.blogList = blogList;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	@JSON(serialize = false)
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
}

package com.jiangjianan.stock.server.web.blog;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class BlogListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BlogService blogService;

	private List<BlogDO> blogList;

	public String execute() throws Exception {
		Result<List<BlogDO>> result = blogService.getBlogList();
		if (result.isSuccess()) {
			blogList = result.getDefaultModel();
		}
		return SUCCESS;
	}

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public List<BlogDO> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<BlogDO> blogList) {
		this.blogList = blogList;
	}

}

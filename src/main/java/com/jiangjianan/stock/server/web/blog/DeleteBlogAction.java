package com.jiangjianan.stock.server.web.blog;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Results({ @Result(location = "blog-list", type = "redirectAction") })
public class DeleteBlogAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String blogUid;

	@Autowired
	private BlogService blogServcie;

	public String execute() throws Exception {
		blogServcie.deleteBlogById(blogUid);
		return SUCCESS;
	}

	public String getBlogUid() {
		return blogUid;
	}

	public void setBlogUid(String blogUid) {
		this.blogUid = blogUid;
	}

	public BlogService getBlogServcie() {
		return blogServcie;
	}

	public void setBlogServcie(BlogService blogServcie) {
		this.blogServcie = blogServcie;
	}

}

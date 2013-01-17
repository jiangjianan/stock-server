package com.jiangjianan.stock.server.web.blog;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Results({ @Result(location = "blog-list", type = "redirectAction") })
public class UpdateAllBlogArticleAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String blogUid;
	private boolean force;
	private boolean quick;

	@Autowired
	private BlogService blogService;

	public String execute() throws Exception {
		new UpdateThread().start();
		return SUCCESS;
	}

	class UpdateThread extends Thread {
		public void run() {
			blogService.updateAllBlogArticle(force, quick);
		}
	}

	public String getBlogUid() {
		return blogUid;
	}

	public void setBlogUid(String blogUid) {
		this.blogUid = blogUid;
	}

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public boolean isForce() {
		return force;
	}

	public void setForce(boolean force) {
		this.force = force;
	}

	public boolean isQuick() {
		return quick;
	}

	public void setQuick(boolean quick) {
		this.quick = quick;
	}

}

package com.jiangjianan.stock.server.web.blog;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.query.BlogPageQuery;
import com.jiangjianan.stock.server.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class BlogListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BlogService blogService;

	private List<BlogDO> blogList;
	private int page;
	private int count;
	private int pageCount;

	public String execute() throws Exception {
		if (page == 0) {
			page = 1;
		}
		BlogPageQuery query = new BlogPageQuery();
		query.setPage(page);
		Result<BlogPageQuery> result = blogService
				.getBlogList(query);
		if (result.isSuccess()) {
			query = result.getDefaultModel();
			blogList = query.getList();
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

	public List<BlogDO> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<BlogDO> blogList) {
		this.blogList = blogList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}

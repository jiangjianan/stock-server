package com.jiangjianan.stock.server.dao;

import java.util.List;

import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.query.BlogPageQuery;

;;

public interface BlogDAO {

	public BlogDO getBlogById(String blogUid);

	public void insertBlog(BlogDO blogDO);

	public void updateBlog(BlogDO blogDO);

	public void deleteBlog(String blogId);

	public List<BlogDO> getBlogList();

	public BlogPageQuery getBlogListByPageQuery(BlogPageQuery query);
}

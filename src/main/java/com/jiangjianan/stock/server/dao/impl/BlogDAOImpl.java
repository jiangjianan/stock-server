package com.jiangjianan.stock.server.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jiangjianan.stock.server.dao.BlogDAO;
import com.jiangjianan.stock.server.object.BlogDO;

@SuppressWarnings("deprecation")
public class BlogDAOImpl extends SqlMapClientDaoSupport implements BlogDAO {

	@Override
	public BlogDO getBlogById(String blogUid) {
		return (BlogDO) this.getSqlMapClientTemplate().queryForObject(
				"blogDAO.getBlogById", blogUid);
	}

	@Override
	public void insertBlog(BlogDO blogDO) {
		this.getSqlMapClientTemplate().insert("blogDAO.insertBlog", blogDO);
	}

	@Override
	public void updateBlog(BlogDO blogDO) {
		this.getSqlMapClientTemplate().update("blogDAO.updateBlog", blogDO);
	}

	@Override
	public void deleteBlog(String blogId) {
		this.getSqlMapClientTemplate().delete("blogDAO.deleteBlogById", blogId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BlogDO> getBlogList() {
		return (List<BlogDO>) this.getSqlMapClientTemplate().queryForList(
				"blogDAO.getBlogList");
	}
}

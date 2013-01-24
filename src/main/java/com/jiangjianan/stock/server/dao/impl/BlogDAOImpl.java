package com.jiangjianan.stock.server.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jiangjianan.stock.server.dao.BlogDAO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.query.BlogPageQuery;

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

	@SuppressWarnings("unchecked")
	@Override
	public BlogPageQuery getBlogListByPageQuery(BlogPageQuery query) {
		Integer count = (Integer) this.getSqlMapClientTemplate()
				.queryForObject("blogDAO.getBlogListByPageQueryCount", query);
		query.setCount(count);
		if (count > 0) {
			List<BlogDO> list = this.getSqlMapClientTemplate().queryForList(
					"blogDAO.getBlogListByPageQuery", query);
			query.setList(list);
		}
		return query;
	}
}

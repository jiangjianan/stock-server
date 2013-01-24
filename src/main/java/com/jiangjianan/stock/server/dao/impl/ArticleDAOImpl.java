package com.jiangjianan.stock.server.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jiangjianan.stock.server.dao.ArticleDAO;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.query.ArticlePageQuery;

@SuppressWarnings("deprecation")
public class ArticleDAOImpl extends SqlMapClientDaoSupport implements
		ArticleDAO {

	@Override
	public ArticleDO getArticleById(String articleId) {
		return (ArticleDO) this.getSqlMapClientTemplate().queryForObject(
				"articleDAO.getArticleById", articleId);
	}

	@Override
	public void insertArticle(ArticleDO articleDO) {
		this.getSqlMapClientTemplate().insert("articleDAO.insertArticle",
				articleDO);
	}

	@Override
	public void updateArticle(ArticleDO articleDO) {
		this.getSqlMapClientTemplate().update("articleDAO.updateArticle",
				articleDO);
	}

	@Override
	public void deleteArticleById(String articleId) {
		this.getSqlMapClientTemplate().delete("articleDAO.deleteArticleById",
				articleId);
	}

	@Override
	public void deleteArticleByBlogUid(String blogUid) {
		this.getSqlMapClientTemplate().delete(
				"articleDAO.deleteArticleByBlogUid", blogUid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleDO> getArticleListByBlogUid(String blogUid) {
		return (List<ArticleDO>) this.getSqlMapClientTemplate().queryForList(
				"articleDAO.getArticleListByBlogUid", blogUid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleDO> getRecentArticleList(Date startDate) {
		return (List<ArticleDO>) this.getSqlMapClientTemplate().queryForList(
				"articleDAO.getRecentArticleList", startDate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArticlePageQuery getArticleListByPageQuery(ArticlePageQuery query) {
		Integer count = (Integer) this.getSqlMapClientTemplate()
				.queryForObject("articleDAO.getArticleListByPageQueryCount",
						query);
		query.setCount(count);
		if (count > 0) {
			List<ArticleDO> list = this.getSqlMapClientTemplate().queryForList(
					"articleDAO.getArticleListByPageQuery", query);
			query.setList(list);
		}
		return query;
	}
}

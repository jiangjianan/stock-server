package com.jiangjianan.stock.server.dao;

import java.util.Date;
import java.util.List;

import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.query.ArticlePageQuery;

public interface ArticleDAO {

	public ArticleDO getArticleById(String articleId);

	public void insertArticle(ArticleDO articleDO);

	public void updateArticle(ArticleDO articleDO);

	public void deleteArticleById(String articleId);

	public void deleteArticleByBlogUid(String blogUid);

	public List<ArticleDO> getArticleListByBlogUid(String blogUid);

	public List<ArticleDO> getRecentArticleList(Date startDate);

	public ArticlePageQuery getArticleListByPageQuery(
			ArticlePageQuery query);
}

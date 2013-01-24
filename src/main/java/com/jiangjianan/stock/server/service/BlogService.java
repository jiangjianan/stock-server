package com.jiangjianan.stock.server.service;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.object.TokenDO;
import com.jiangjianan.stock.server.query.ArticlePageQuery;
import com.jiangjianan.stock.server.query.BlogPageQuery;

public interface BlogService {
	public Result<TokenDO> relogin(String code);

	public Result<Boolean> deleteBlogById(String blogUid);

	public Result<Boolean> updateBlogArticleById(String blogUid,
			boolean rebuild, boolean quick);

	public Result<Boolean> updateAllBlogArticle(boolean rebuild, boolean quick);

	public Result<Boolean> insertBlogById(String blogUid);

	public Result<Boolean> setAccessToken(String accessToken);

	public Result<BlogPageQuery> getBlogList(BlogPageQuery query);

	public Result<BlogDO> getBlogById(String blogUid);

	public Result<ArticleDO> getArticleById(String articleId);

	public Result<ArticlePageQuery> getArticleList(
			ArticlePageQuery query);
}

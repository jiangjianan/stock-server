package com.jiangjianan.stock.server.service;

import java.util.Date;
import java.util.List;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.object.TokenDO;

public interface BlogService {
	public Result<TokenDO> relogin(String code);

	public Result<Boolean> deleteBlogById(String blogUid);

	public Result<Boolean> updateBlogArticleById(String blogUid,
			boolean rebuild, boolean quick);

	public Result<Boolean> updateAllBlogArticle(boolean rebuild, boolean quick);

	public Result<Boolean> insertBlogById(String blogUid);

	public Result<Boolean> setAccessToken(String accessToken);

	public Result<List<BlogDO>> getBlogList();

	public Result<BlogDO> getBlogById(String blogUid);

	public Result<ArticleDO> getArticleById(String articleId);

	public Result<List<ArticleDO>> getArticleListByBlogUid(String blogUid);

	public Result<List<ArticleDO>> getRecentArticleList(Date startDate);

}

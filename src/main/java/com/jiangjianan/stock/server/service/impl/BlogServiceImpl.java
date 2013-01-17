package com.jiangjianan.stock.server.service.impl;

import java.util.Date;
import java.util.List;

import com.jiangjianan.stock.server.common.service.BaseService;
import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.common.service.ResultSupport;
import com.jiangjianan.stock.server.dao.ArticleDAO;
import com.jiangjianan.stock.server.dao.BlogDAO;
import com.jiangjianan.stock.server.manager.SinaBlogSpiderManager;
import com.jiangjianan.stock.server.manager.SinaOpenApiManager;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.object.TokenDO;
import com.jiangjianan.stock.server.service.BlogService;

public class BlogServiceImpl extends BaseService implements BlogService {
	private SinaOpenApiManager sinaOpenApiManager;
	private SinaBlogSpiderManager sinaBlogSpiderManager;
	private BlogDAO blogDAO;
	private ArticleDAO articleDAO;

	@Override
	public Result<TokenDO> relogin(String code) {
		Result<TokenDO> result = new ResultSupport<TokenDO>();
		try {
			sinaOpenApiManager.setCode(code);
			TokenDO tokenDO = sinaOpenApiManager.login();
			sinaOpenApiManager.setAccessToken(tokenDO.getAccessToken());
			if (tokenDO.isSuccess()) {
				result.setSuccess(true);
				result.setDefaultModel(tokenDO);
			} else {
				result.setSuccess(false);
				result.setDefaultModel(tokenDO);
			}
		} catch (Exception e) {
			logger.error("AdminServiceImpl.relogin", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<Boolean> deleteBlogById(String blogUid) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			blogDAO.deleteBlog(blogUid);
			articleDAO.deleteArticleByBlogUid(blogUid);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("AdminServiceImpl.deleteBlogById", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<Boolean> insertBlogById(String blogUid) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			BlogDO blogDO = sinaOpenApiManager.getBlog(blogUid);
			blogDO.setArticleCount(0);
			if (blogDO.isSuccess()) {
				blogDAO.insertBlog(blogDO);
				result.setSuccess(true);
			} else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("AdminServiceImpl.insertBlogById", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<Boolean> updateBlogArticleById(String blogUid,
			boolean rebuild, boolean quick) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			BlogDO blogDO = blogDAO.getBlogById(blogUid);
			int page = sinaBlogSpiderManager.getArticlePages(blogUid);
			if (rebuild == true) {
				articleDAO.deleteArticleByBlogUid(blogUid);
			}
			for (int i = 1; i <= page; i++) {
				List<String> list = sinaBlogSpiderManager.getArticleList(
						blogUid, i);
				for (String articleId : list) {
					ArticleDO articleDO = articleDAO.getArticleById(articleId);
					if (articleDO != null) {
						continue;
					}
					articleDO = sinaBlogSpiderManager.getArticle(blogUid,
							articleId);
					articleDO.setUserNick(blogDO.getUserNick());
					articleDO.setBlogName(blogDO.getBlogName());
					articleDAO.insertArticle(articleDO);
				}
				if (rebuild == false && quick == true) {
					break;
				}
			}
			List<ArticleDO> articleList = articleDAO
					.getArticleListByBlogUid(blogUid);
			blogDO.setArticleCount(articleList.size());
			blogDAO.updateBlog(blogDO);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("AdminServiceImpl.updateBlogArticleById", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<Boolean> updateAllBlogArticle(boolean rebuild, boolean quick) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			List<BlogDO> blogList = blogDAO.getBlogList();
			for (BlogDO blogDO : blogList) {
				updateBlogArticleById(blogDO.getBlogUid(), rebuild, quick);
			}
		} catch (Exception e) {
			logger.error("AdminServiceImpl.updateBlogArticleById", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<Boolean> setAccessToken(String accessToken) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			sinaOpenApiManager.setAccessToken(accessToken);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("AdminServiceImpl.insertBlogById", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<List<BlogDO>> getBlogList() {
		Result<List<BlogDO>> result = new ResultSupport<List<BlogDO>>();
		try {
			List<BlogDO> blogList = blogDAO.getBlogList();
			result.setSuccess(true);
			result.setDefaultModel(blogList);
		} catch (Exception e) {
			logger.error("QueryServiceImpl.getBlogList", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<BlogDO> getBlogById(String blogUid) {
		Result<BlogDO> result = new ResultSupport<BlogDO>();
		try {
			BlogDO blogDO = blogDAO.getBlogById(blogUid);
			result.setSuccess(true);
			result.setDefaultModel(blogDO);
		} catch (Exception e) {
			logger.error("QueryServiceImpl.getBlogList", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<ArticleDO> getArticleById(String articleId) {
		Result<ArticleDO> result = new ResultSupport<ArticleDO>();
		try {
			ArticleDO articleDO = articleDAO.getArticleById(articleId);
			result.setSuccess(true);
			result.setDefaultModel(articleDO);
		} catch (Exception e) {
			logger.error("QueryServiceImpl.getArticleById", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<List<ArticleDO>> getArticleListByBlogUid(String blogUid) {
		Result<List<ArticleDO>> result = new ResultSupport<List<ArticleDO>>();
		try {
			List<ArticleDO> list = articleDAO.getArticleListByBlogUid(blogUid);
			result.setSuccess(true);
			result.setDefaultModel(list);
		} catch (Exception e) {
			logger.error("QueryServiceImpl.getArticleListByBlogUid", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<List<ArticleDO>> getRecentArticleList(Date startDate) {
		Result<List<ArticleDO>> result = new ResultSupport<List<ArticleDO>>();
		try {
			List<ArticleDO> list = articleDAO.getRecentArticleList(startDate);
			result.setSuccess(true);
			result.setDefaultModel(list);
		} catch (Exception e) {
			logger.error("QueryServiceImpl.getArticleListByBlogUid", e);
			result.setSuccess(false);
		}
		return result;
	}

	public SinaOpenApiManager getSinaOpenApiManager() {
		return sinaOpenApiManager;
	}

	public void setSinaOpenApiManager(SinaOpenApiManager sinaOpenApiManager) {
		this.sinaOpenApiManager = sinaOpenApiManager;
	}

	public BlogDAO getBlogDAO() {
		return blogDAO;
	}

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	public SinaBlogSpiderManager getSinaBlogSpiderManager() {
		return sinaBlogSpiderManager;
	}

	public void setSinaBlogSpiderManager(
			SinaBlogSpiderManager sinaBlogSpiderManager) {
		this.sinaBlogSpiderManager = sinaBlogSpiderManager;
	}

}

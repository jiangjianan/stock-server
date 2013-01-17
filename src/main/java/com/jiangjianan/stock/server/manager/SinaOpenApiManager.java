package com.jiangjianan.stock.server.manager;

import java.util.List;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.object.TokenDO;

public interface SinaOpenApiManager {

	public ArticleDO getArticle(String articleId) throws ManagerException;

	public BlogDO getBlog(String blogUid) throws ManagerException;

	public TokenDO login() throws ManagerException;

	public void setCode(String code);

	public void setAccessToken(String accessToken);

	public List<String> getArticleList(String blogUid, int page, int pageSize)
			throws ManagerException;

}

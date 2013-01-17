package com.jiangjianan.stock.server.manager;

import java.util.List;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.object.ArticleDO;

public interface SinaBlogSpiderManager {

	public ArticleDO getArticle(String blogUid, String articleId)
			throws ManagerException;

	public int getArticlePages(String blogUid) throws ManagerException;

	public List<String> getArticleList(String blogUid, int page)
			throws ManagerException;
}

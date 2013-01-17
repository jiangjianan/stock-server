package com.jiangjianan.stock.server.manager.impl;

import java.util.Date;
import java.util.List;

import com.jiangjianan.stock.server.common.manager.BaseManager;
import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.manager.SinaBlogSpiderManager;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.util.DateUtil;
import com.jiangjianan.stock.server.util.HtmlUtil;
import com.jiangjianan.stock.server.util.HttpUtil;

public class SinaBlogSpiderManagerImpl extends BaseManager implements
		SinaBlogSpiderManager {
	private static final String CHARSET_UTF_8 = "utf-8";

	@Override
	public ArticleDO getArticle(String blogUid, String articleId)
			throws ManagerException {
		String url = "http://blog.sina.com.cn/s/blog_" + articleId + ".html";
		try {
			String html = HttpUtil.get(url, CHARSET_UTF_8);
			String articleBody = HtmlUtil.getContentByTag(html, "utf-8", "id",
					"sina_keyword_ad_area2");
			String articleTitle = HtmlUtil.getContentByTag(html, "utf-8",
					"class", "titName SG_txta");
			String articlePubdateString = HtmlUtil.getContentByTag(html,
					"utf-8", "class", "time SG_txtc").trim();
			articlePubdateString = articlePubdateString.substring(1,
					articlePubdateString.length() - 1);
			Date articlePubdate = DateUtil.stringToDate(articlePubdateString);
			ArticleDO articleDO = new ArticleDO();
			articleDO.setArticleId(articleId);
			articleDO.setArticleBody(articleBody);
			articleDO.setArticleTitle(articleTitle);
			articleDO.setArticlePubdate(articlePubdate);
			articleDO.setBlogUid(blogUid);
			return articleDO;
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public int getArticlePages(String blogUid) throws ManagerException {
		String url = "http://blog.sina.com.cn/s/articlelist_" + blogUid
				+ "_0_1.html";
		try {
			String html = HttpUtil.get(url, CHARSET_UTF_8);
			int pages = HtmlUtil.getArticleListPages(html, CHARSET_UTF_8);
			return pages;
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public List<String> getArticleList(String blogUid, int page)
			throws ManagerException {
		String url = "http://blog.sina.com.cn/s/articlelist_" + blogUid + "_0_"
				+ page + ".html";
		try {
			String html = HttpUtil.get(url, CHARSET_UTF_8);
			List<String> list = HtmlUtil.getArticleList(html, CHARSET_UTF_8);
			return list;
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}
}

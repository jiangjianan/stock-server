package com.jiangjianan.stock.server.object;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticleDO extends SinaBaseDO {
	private static final long serialVersionUID = 1L;
	private String articleId;
	private String articleTitle;
	private Date articlePubdate;
	private Date articleUppdate;
	private String className;
	private String articleBody;
	private String articleTag;

	private String blogName;
	private String blogUid;
	private String userNick;

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public Date getArticlePubdate() {
		return articlePubdate;
	}

	public void setArticlePubdate(Date articlePubdate) {
		this.articlePubdate = articlePubdate;
	}

	public Date getArticleUppdate() {
		return articleUppdate;
	}

	public void setArticleUppdate(Date articleUppdate) {
		this.articleUppdate = articleUppdate;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getArticleBody() {
		return articleBody;
	}

	public void setArticleBody(String articleBody) {
		this.articleBody = articleBody;
	}

	public String getArticleTag() {
		return articleTag;
	}

	public void setArticleTag(String articleTag) {
		this.articleTag = articleTag;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getBlogUid() {
		return blogUid;
	}

	public void setBlogUid(String blogUid) {
		this.blogUid = blogUid;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getArticlePubdateString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(articlePubdate);
	}

}

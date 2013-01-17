package com.jiangjianan.stock.server.object;

public class BlogDO extends SinaBaseDO {
	private static final long serialVersionUID = 1L;
	private String blogUid;
	private String blogUrl;
	private String blogName;
	private String userNick;
	private String userPic;
	private int articleCount;
	private String uhost;

	public String getBlogUid() {
		return blogUid;
	}

	public void setBlogUid(String blogUid) {
		this.blogUid = blogUid;
	}

	public String getBlogUrl() {
		return blogUrl;
	}

	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public String getUhost() {
		return uhost;
	}

	public void setUhost(String uhost) {
		this.uhost = uhost;
	}

}

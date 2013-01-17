package com.jiangjianan.stock.server.object;

public class TokenDO extends SinaBaseDO {
	private static final long serialVersionUID = 1L;
	private String accessToken;
	private Long expiresIn;
	private Long timeLeft;
	private String uid;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Long getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(Long timeLeft) {
		this.timeLeft = timeLeft;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}

package com.jiangjianan.stock.server.manager.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jiangjianan.stock.server.common.manager.BaseManager;
import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.manager.SinaOpenApiManager;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.object.TokenDO;
import com.jiangjianan.stock.server.util.HttpUtil;
import com.jiangjianan.stock.server.util.JsonUtil;

public class SinaOpenApiManagerImpl extends BaseManager implements
		SinaOpenApiManager {

	public static final String APP_KEY = "1679260282";

	public static final String CONSUMER_SECRET = "40f5d3733293bc7ff7fc5faf704fc095";

	public static final String REDIRECT_URI = "http://www.jiangjianan.com";

	private static String USER_IP;

	private final String CHARSET_GBK = "GBK";

	private final String CHARSET_UTF_8 = "utf-8";

	private String accessToken = "a9b6216661MEeUq1PE0jg3CE5r8216b8";

	private String code = "97e29b493600ce1e4ac02fe13b504e1a";

	@Override
	public TokenDO login() throws ManagerException {
		String url = "https://auth.sina.com.cn/oauth2/access_token";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("client_id", APP_KEY);
		parameters.put("client_secret", CONSUMER_SECRET);
		parameters.put("grant_type", "authorization_code");
		parameters.put("code", code);
		parameters.put("redirect_uri", REDIRECT_URI);

		try {
			String json = HttpUtil.post(url, parameters, CHARSET_UTF_8);
			TokenDO tokenDO = JsonUtil.getToken(json);
			return tokenDO;
		} catch (IOException e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public ArticleDO getArticle(String articleId) throws ManagerException {
		String url = "https://platform.sina.com.cn/blogv2/article?app_key="
				+ APP_KEY + "&access_token=" + accessToken + "&article_id="
				+ articleId + "&user_ip=" + getUserIp();
		try {
			Thread.sleep(1000);
			String json = HttpUtil.get(url, CHARSET_GBK);
			ArticleDO articleDO = JsonUtil.getArticle(json);
			return articleDO;
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public BlogDO getBlog(String blogUid) throws ManagerException {
		String url = "https://platform.sina.com.cn/blogv2/articlelist?app_key="
				+ APP_KEY + "&access_token=" + accessToken + "&blog_uid="
				+ blogUid + "&user_ip=" + getUserIp();
		try {
			Thread.sleep(1000);
			String json = HttpUtil.get(url, CHARSET_GBK);
			System.out.println(json);
			BlogDO blogDO = JsonUtil.getBlog(json);
			return blogDO;
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	public List<String> getArticleList(String blogUid, int page, int pageSize)
			throws ManagerException {
		String url = "https://platform.sina.com.cn/blogv2/articlelist?app_key="
				+ APP_KEY + "&access_token=" + accessToken + "&blog_uid="
				+ blogUid + "&page=" + page + "&pagesize=" + pageSize
				+ "&user_ip=" + getUserIp();
		try {
			Thread.sleep(1000);
			String json = HttpUtil.get(url, CHARSET_GBK);
			List<String> list = JsonUtil.getArticleList(json);
			return list;
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	public String getUserIp() {
		if (USER_IP != null) {
			return USER_IP;
		} else {
			InetAddress addr = null;
			try {
				addr = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				logger.error("SinaOpenApiManagerImpl.getUserIp", e);
			}
			USER_IP = addr.getHostAddress().toString();
			return USER_IP;
		}
	}

	public String getAccessToken() {
		return accessToken;
	}

	@Override
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

}

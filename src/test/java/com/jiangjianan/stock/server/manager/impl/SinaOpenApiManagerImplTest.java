package com.jiangjianan.stock.server.manager.impl;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.manager.SinaOpenApiManager;
import com.jiangjianan.stock.server.manager.impl.SinaOpenApiManagerImpl;
import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.object.TokenDO;

public class SinaOpenApiManagerImplTest {
	private SinaOpenApiManager manager;

	@Before
	public void setUp() {
		manager = new SinaOpenApiManagerImpl();
	}

	@SuppressWarnings("unused")
	@Ignore
	@Test
	public void login() throws ManagerException {
		String url = "https://auth.sina.com.cn/oauth2/authorize?client_id=1679260282&redirect_uri=http://www.jiangjianan.com";
		manager.setCode("217cef1918b9b85acb47215ef0836125");
		TokenDO tokenDO = manager.login();
		System.out.println(ToStringBuilder.reflectionToString(tokenDO));
	}

	@Ignore
	@Test
	public void getArticle() throws ManagerException {
		manager.setAccessToken("a9b6216661MEeUq1PE0jg3CE5r8216b8");
		ArticleDO articleDO = manager.getArticle("4462623d0100kqfr");
		assertEquals("4462623d0100kqfr", articleDO.getArticleId());
	}

	
	@Test
	public void getBlog() throws ManagerException {
		manager.setAccessToken("1e76476661MEeUq1PE0jg3CE5r847733");
		BlogDO blogDO = manager.getBlog("1147298365");
		assertEquals("1147298365", blogDO.getBlogUid());
	}
}

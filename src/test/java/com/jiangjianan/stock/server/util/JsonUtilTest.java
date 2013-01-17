package com.jiangjianan.stock.server.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.jiangjianan.stock.server.object.ArticleDO;
import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.object.TokenDO;
import com.jiangjianan.stock.server.util.FileUtil;
import com.jiangjianan.stock.server.util.JsonUtil;

public class JsonUtilTest {
	@Test
	public void getBlogError() throws IOException, ParseException {
		String json = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/error.json");
		BlogDO blogDO = JsonUtil.getBlog(json);
		assertEquals("O40002", blogDO.getErrorCode());
	}

	@Test
	public void getBlog() throws IOException, ParseException {
		String json = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/blog.json");
		BlogDO blogDO = JsonUtil.getBlog(json);
		assertEquals("1147298365", blogDO.getBlogUid());
	}

	@Test
	public void getArticle() throws IOException, ParseException {
		String json = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/article.json");
		ArticleDO articleDO = JsonUtil.getArticle(json);
		assertEquals("4462623d0100kqfr", articleDO.getArticleId());
	}

	@Test
	public void getToken() throws IOException {
		String json = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/token.json");
		TokenDO tokenDO = JsonUtil.getToken(json);
		assertEquals("a9b6216661MEeUq1PE0jg3CE5r8216b8",
				tokenDO.getAccessToken());
	}

	@Test
	public void getTokenError() throws IOException {
		String json = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/token_error.json");
		TokenDO tokenDO = JsonUtil.getToken(json);
		assertEquals("21325", tokenDO.getErrorCode());
	}

	@Test
	public void getArticleList() throws IOException {
		String json = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/blog.json");
		List<String> list = JsonUtil.getArticleList(json);
		assertEquals(10, list.size());
	}
}

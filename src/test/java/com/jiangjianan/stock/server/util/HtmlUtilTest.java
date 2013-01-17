package com.jiangjianan.stock.server.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.htmlparser.util.ParserException;
import org.junit.Test;

import com.jiangjianan.stock.server.util.FileUtil;
import com.jiangjianan.stock.server.util.HtmlUtil;

public class HtmlUtilTest {
	@Test
	public void getContentById() throws IOException, ParserException {
		String html = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/blog_4462623d0102ee74.html");
		HtmlUtil.getContentByTag(html, "utf-8", "id", "sina_keyword_ad_area2");
	}

	@Test
	public void getArticleList() throws IOException, ParserException {
		String html = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/articlelist_1147298365_0_1.html");
		assertEquals(50, HtmlUtil.getArticleList(html, "utf-8").size());
	}

	@Test
	public void getArticleListPages() throws IOException, ParserException {
		String html = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/articlelist_1147298365_0_1.html");
		assertEquals(127, HtmlUtil.getArticleListPages(html, "utf-8"));
	}
}

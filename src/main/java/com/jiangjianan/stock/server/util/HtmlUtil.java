package com.jiangjianan.stock.server.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.LinkStringFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.jiangjianan.stock.server.object.BlogDO;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;

public class HtmlUtil {
	public static void main(String[] args) throws IOException, ParserException {
		// String html = FileUtil
		// .getStringFromFile("src/test/resources/com/jiangjianan/sinablog/server/util/blog_4462623d0102ee74.html");
		// System.out.println(HtmlUtil.getContentById(html, "utf-8", "id",
		// "sina_keyword_ad_area2"));
		// System.out.println(HtmlUtil.getContentById(html, "utf-8", "class",
		// "titName SG_txta"));
		// System.out.println(HtmlUtil.getContentById(html, "utf-8", "class",
		// "time SG_txtc"));
		// System.out.println(HtmlUtil.getContentById(html, "utf-8", "class",
		// "blog_tag"));
		// System.out.println(HtmlUtil.getContentById(html, "utf-8", "class",
		// "blog_class"));

		String html = FileUtil
				.readTextFile("src/test/resources/com/jiangjianan/stock/server/util/SSEQueryCompanyStatement.htm");
		HtmlUtil.getAnnouncementList(html, "GB2312");
	}

	public static String getContentByTag(String html, String charset,
			String key, String value) throws ParserException {
		Parser parser = Parser.createParser(html, charset);
		NodeFilter filter = new HasAttributeFilter(key, value);
		NodeList nodeList = parser.extractAllNodesThatMatch(filter);
		if (nodeList != null && nodeList.size() > 0) {
			Node node = nodeList.elementAt(0);
			return node.toPlainTextString();
		} else {
			return null;
		}
	}

	public static List<String> getArticleList(String html, String charset)
			throws ParserException {
		Parser parser = Parser.createParser(html, charset);
		NodeFilter filter = new LinkStringFilter(
				"http://blog.sina.com.cn/s/blog_");
		NodeList nodeList = parser.extractAllNodesThatMatch(filter);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.elementAt(i);
			String link = ((LinkTag) node).getLink();
			int index = link.indexOf(".html");
			list.add(link.substring(31, index));
		}
		return list;
	}

	public static int getArticleListPages(String html, String charset)
			throws ParserException {
		Parser parser = Parser.createParser(html, charset);
		NodeFilter filter = new HasAttributeFilter("class", "SG_pages");
		NodeList nodeList = parser.extractAllNodesThatMatch(filter);
		nodeList = nodeList.elementAt(0).getChildren();
		String value = nodeList.elementAt(nodeList.size() - 2)
				.toPlainTextString();
		int page = Integer.parseInt(value.substring(1, value.length() - 1));
		return page;
	}

	public static BlogDO getBlog(String html, String charset)
			throws ParserException {
		BlogDO blogDO = new BlogDO();
		Parser parser = Parser.createParser(html, charset);
		NodeFilter filter = new HasAttributeFilter("id", "blognamespan");
		NodeList nodeList = parser.extractAllNodesThatMatch(filter);
		String blogName = nodeList.elementAt(0).toPlainTextString();
		blogDO.setBlogName(blogName);

		parser = Parser.createParser(html, charset);
		filter = new HasAttributeFilter("id", "bloglink");
		nodeList = parser.extractAllNodesThatMatch(filter);
		String blogUrl = nodeList.elementAt(0).getChildren().elementAt(0)
				.toPlainTextString();
		String uhost = blogUrl.substring(24);
		blogDO.setBlogUrl(blogUrl);
		blogDO.setUhost(uhost);
		return null;
	}

	public static List<StockAnnouncementDO> getAnnouncementList(String html,
			String charset) throws ParserException {
		List<StockAnnouncementDO> list = new ArrayList<StockAnnouncementDO>();
		Parser parser = Parser.createParser(html, charset);
		NodeFilter filter = new LinkStringFilter(
				"http://static.sse.com.cn/sseportal/cs/zhs/scfw/gg/ssgs/");
		NodeList nodeList = parser.extractAllNodesThatMatch(filter);
		for (int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.elementAt(i);
			String title = node.getText();
			String url = ((LinkTag) node).getLink();
			StockAnnouncementDO stockAnnouncementDO = new StockAnnouncementDO();
			stockAnnouncementDO.setTitle(title);
			stockAnnouncementDO.setUrl(url);
			list.add(stockAnnouncementDO);
		}
		return list;
	}
}

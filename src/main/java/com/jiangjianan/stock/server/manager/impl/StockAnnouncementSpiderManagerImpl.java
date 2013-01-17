package com.jiangjianan.stock.server.manager.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.LinkStringFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.jiangjianan.stock.server.common.manager.BaseManager;
import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.manager.StockAnnouncementSpiderManager;
import com.jiangjianan.stock.server.object.StockAnnouncementDO;
import com.jiangjianan.stock.server.util.HttpUtil;

public class StockAnnouncementSpiderManagerImpl extends BaseManager implements
		StockAnnouncementSpiderManager {
	public List<StockAnnouncementDO> getStockAnnouncementList(String code)
			throws ManagerException {
		if (code.startsWith("6")) {
			return getShStockAnnouncementList(code);
		} else if (code.startsWith("0") || code.startsWith("3")) {
			return getSzStockAnnouncementList(code);
		} else {
			return new ArrayList<StockAnnouncementDO>();
		}
	}

	protected List<StockAnnouncementDO> getShStockAnnouncementList(String code)
			throws ManagerException {
		String url = "http://www.sse.com.cn/sseportal/webapp/datapresent/SSEQueryCompanyStatement?isAdvQuery=1&PRODUCTID="
				+ code + "&REPORTTYPE2=&BEGINDATE=&ENDDATE=&REPORTTYPE=ALL";
		String charset = "GB2312";
		try {
			String html = HttpUtil.get(url, charset);
			return getShAnnouncementList(code, html, charset);
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	protected List<StockAnnouncementDO> getSzStockAnnouncementList(String code)
			throws ManagerException {
		String url = "http://disclosure.szse.cn/m/drgg" + code + ".htm";
		String charset = "gb2312";
		try {
			String html = HttpUtil.get(url, charset);
			return getSzAnnouncementList(code, html, charset);
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	protected List<StockAnnouncementDO> getShAnnouncementList(String code,
			String html, String charset) throws ParserException, ParseException {
		List<StockAnnouncementDO> list = new ArrayList<StockAnnouncementDO>();
		Parser parser = Parser.createParser(html, charset);
		NodeFilter filter = new LinkStringFilter(
				"http://static.sse.com.cn/sseportal/cs/zhs/scfw/gg/ssgs/");
		NodeList nodeList = parser.extractAllNodesThatMatch(filter);
		for (int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.elementAt(i);
			String title = node.toPlainTextString();
			String url = ((LinkTag) node).getLink();
			StockAnnouncementDO stockAnnouncementDO = new StockAnnouncementDO();
			stockAnnouncementDO.setCode(code);
			stockAnnouncementDO.setTitle(title);
			stockAnnouncementDO.setUrl(url);
			String date = url.substring(55, 65);
			stockAnnouncementDO.setDate(Long.valueOf(date.replaceAll("-", "")));
			list.add(stockAnnouncementDO);
		}
		return list;
	}

	protected List<StockAnnouncementDO> getSzAnnouncementList(String code,
			String html, String charset) throws ParserException, ParseException {
		List<StockAnnouncementDO> list = new ArrayList<StockAnnouncementDO>();
		Parser parser = Parser.createParser(html, charset);
		NodeFilter filter = new LinkStringFilter("finalpage/");
		NodeList nodeList = parser.extractAllNodesThatMatch(filter);
		for (int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.elementAt(i);
			String title = node.toPlainTextString();
			String url = ((LinkTag) node).getLink();
			StockAnnouncementDO stockAnnouncementDO = new StockAnnouncementDO();
			stockAnnouncementDO.setCode(code);
			stockAnnouncementDO.setTitle(title);
			stockAnnouncementDO.setUrl("http://disclosure.szse.cn/m/" + url);
			String date = url.substring(10, 20);
			stockAnnouncementDO.setDate(Long.valueOf(date.replaceAll("-", "")));
			list.add(stockAnnouncementDO);
		}
		return list;
	}
	
}

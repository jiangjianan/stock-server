package com.jiangjianan.stock.server.manager.impl;

import java.io.IOException;
import java.util.List;

import com.jiangjianan.stock.server.common.manager.BaseManager;
import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.manager.StockAnalyzerSpiderManager;
import com.jiangjianan.stock.server.object.StockInfoDO;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.util.CsvUtil;
import com.jiangjianan.stock.server.util.HttpUtil;

public class StockAnalyzerSpiderManagerImpl extends BaseManager implements
		StockAnalyzerSpiderManager {
	private final String CHARSET_GBK = "GBK";

	private final String CHARSET_UTF_8 = "utf-8";

	@Override
	public StockInfoDO getStockInfo(String code) throws ManagerException {
		if (code.startsWith("0") || code.startsWith("3")) {
			code = "sz" + code;
		} else if (code.startsWith("6")) {
			code = "sh" + code;
		}
		try {
			String url = "http://hq.sinajs.cn/list=" + code;
			String httpBody = HttpUtil.get(url, CHARSET_UTF_8);
			if (httpBody == null) {
				return null;
			}
			int startIndex = httpBody.indexOf("\"");
			int endIndex = httpBody.indexOf(",");
			if (startIndex <= 0 || endIndex <= 0 || startIndex >= endIndex) {
				return null;
			}
			String name = httpBody.substring(startIndex + 1, endIndex);
			StockInfoDO stockInfoDO = new StockInfoDO();
			stockInfoDO.setCode(code.substring(2));
			stockInfoDO.setName(name);
			return stockInfoDO;
		} catch (Exception e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public List<StockPriceDO> getStockPrice(String code, Long startDate,
			Long endDate) throws ManagerException {
		if (code.startsWith("0") || code.startsWith("3")) {
			code = "1" + code;
		} else if (code.startsWith("6")) {
			code = "0" + code;
		}
		try {
			String url = "http://quotes.money.163.com/service/chddata.html?start="
					+ startDate
					+ "&end="
					+ endDate
					+ "&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;TURNOVER;VOTURNOVER;VATURNOVER;TCAP;MCAP&code="
					+ code;
			String csv = HttpUtil.get(url, CHARSET_GBK);
			System.out.println(csv);
			return CsvUtil.getStockPrice(csv);
		} catch (IOException e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public String getStockReport(String code) throws ManagerException {
		try {
			String url = "http://quotes.money.163.com/service/zycwzb_" + code
					+ ".html?type=report";
			String body = HttpUtil.get(url, CHARSET_GBK);
			return body;
		} catch (IOException e) {
			throw new ManagerException(e);
		}
	}
}

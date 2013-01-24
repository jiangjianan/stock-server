package com.jiangjianan.stock.server.manager.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jiangjianan.stock.server.common.manager.BaseManager;
import com.jiangjianan.stock.server.common.manager.ManagerException;
import com.jiangjianan.stock.server.manager.StockAnalyzerSpiderManager;
import com.jiangjianan.stock.server.object.StockInfoDO;
import com.jiangjianan.stock.server.object.StockPriceDO;
import com.jiangjianan.stock.server.object.StockReportDO;
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
			return getStockPriceInCsv(csv);
		} catch (IOException e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public List<StockReportDO> getStockReport(String code)
			throws ManagerException {
		try {
			String url = "http://quotes.money.163.com/service/zycwzb_" + code
					+ ".html?type=report";
			String csv = HttpUtil.get(url, CHARSET_GBK);
			return getStockReportInCsv(code, csv);
		} catch (IOException e) {
			throw new ManagerException(e);
		}
	}

	public List<StockReportDO> getStockReportInCsv(String code, String csv) {
		List<StockReportDO> list = new ArrayList<StockReportDO>();
		String[] array = csv.split(System.getProperty("line.separator"));
		if (array.length >= 20) {
			String dateLine = array[0];
			String[] dateArray = dateLine.split(",");
			for (int i = 1; i < dateArray.length; i++) {
				if (!dateArray[i].equals("")) {
					StockReportDO stockReportDO = new StockReportDO();
					stockReportDO.setCode(code);
					String sDate = dateArray[i].replaceAll("-", "");
					stockReportDO.setDate(Long.valueOf(sDate));
					stockReportDO.setId(code + sDate);
					list.add(stockReportDO);
				}
			}
			String epsLine = array[1];
			String[] epsArray = epsLine.split(",");
			for (int i = 1; i < epsArray.length; i++) {
				if (!epsArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sEps = epsArray[i];
					try {
						stockReport.setEps(Double.valueOf(sEps));
					} catch (Exception e) {
					}
				}
			}
			String navpsLine = array[2];
			String[] navpsArray = navpsLine.split(",");
			for (int i = 1; i < navpsArray.length; i++) {
				if (!navpsArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sNavps = navpsArray[i];
					try {
						stockReport.setNavps(Double.valueOf(sNavps));
					} catch (Exception e) {
					}
				}
			}
			String cashFlowPerStockLine = array[3];
			String[] cashFlowPerStockArray = cashFlowPerStockLine.split(",");
			for (int i = 1; i < cashFlowPerStockArray.length; i++) {
				if (!cashFlowPerStockArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sCashFlowPerStock = cashFlowPerStockArray[i];
					try {
						stockReport.setCashFlowPerStock(Double
								.valueOf(sCashFlowPerStock));
					} catch (Exception e) {
					}
				}
			}
			String businessIncomeLine = array[4];
			String[] businessIncomeArray = businessIncomeLine.split(",");
			for (int i = 1; i < businessIncomeArray.length; i++) {
				if (!businessIncomeArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sBusinessIncome = businessIncomeArray[i];
					try {
						stockReport.setBusinessIncome(Double
								.valueOf(sBusinessIncome));
					} catch (Exception e) {
					}
				}
			}
			String grossProfitLine = array[5];
			String[] grossProfitArray = grossProfitLine.split(",");
			for (int i = 1; i < grossProfitArray.length; i++) {
				if (!grossProfitArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sGrossProfit = grossProfitArray[i];
					try {
						stockReport
								.setGrossProfit(Double.valueOf(sGrossProfit));
					} catch (Exception e) {
					}
				}
			}
			String businessProfitLine = array[6];
			String[] businessProfitArray = businessProfitLine.split(",");
			for (int i = 1; i < businessProfitArray.length; i++) {
				if (!businessProfitArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sBusinessProfit = businessProfitArray[i];
					try {
						stockReport.setBusinessProfit(Double
								.valueOf(sBusinessProfit));
					} catch (Exception e) {
					}
				}
			}
			String investProfitLine = array[7];
			String[] investProfitArray = investProfitLine.split(",");
			for (int i = 1; i < investProfitArray.length; i++) {
				if (!investProfitArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sInvestProfit = investProfitArray[i];
					try {
						stockReport.setInvestProfit(Double
								.valueOf(sInvestProfit));
					} catch (Exception e) {
					}
				}
			}
			String nonOperationIncomeLine = array[8];
			String[] nonOperationIncomeArray = nonOperationIncomeLine
					.split(",");
			for (int i = 1; i < investProfitArray.length; i++) {
				if (!nonOperationIncomeArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sNonOperationIncome = nonOperationIncomeArray[i];
					try {
						stockReport.setNonOperationIncome(Double
								.valueOf(sNonOperationIncome));
					} catch (Exception e) {
					}
				}
			}
			String totalProfitLine = array[9];
			String[] totalProfitArray = totalProfitLine.split(",");
			for (int i = 1; i < totalProfitArray.length; i++) {
				if (!totalProfitArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sTotalProfit = totalProfitArray[i];
					try {
						stockReport
								.setTotalProfit(Double.valueOf(sTotalProfit));
					} catch (Exception e) {
					}
				}
			}
			String netProfitLine = array[10];
			String[] netProfitArray = netProfitLine.split(",");
			for (int i = 1; i < netProfitArray.length; i++) {
				if (!netProfitArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sNetProfit = netProfitArray[i];
					try {
						stockReport.setNetProfit(Double.valueOf(sNetProfit));
					} catch (Exception e) {
					}
				}
			}
			String deductNetProfitLine = array[11];
			String[] deductNetProfitArray = deductNetProfitLine.split(",");
			for (int i = 1; i < deductNetProfitArray.length; i++) {
				if (!deductNetProfitArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sDeductNetProfit = deductNetProfitArray[i];
					try {
						stockReport.setDeductNetProfit(Double
								.valueOf(sDeductNetProfit));
					} catch (Exception e) {
					}
				}
			}
			String cashFlowLine = array[12];
			String[] cashFlowArray = cashFlowLine.split(",");
			for (int i = 1; i < cashFlowArray.length; i++) {
				if (!cashFlowArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sCashFlow = cashFlowArray[i];
					try {
						stockReport.setCashFlow(Double.valueOf(sCashFlow));
					} catch (Exception e) {
					}
				}
			}
			String cashAddedLine = array[13];
			String[] cashAddedArray = cashAddedLine.split(",");
			for (int i = 1; i < cashAddedArray.length; i++) {
				if (!cashAddedArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sCashAdded = cashAddedArray[i];
					try {
						stockReport.setCashAdded(Double.valueOf(sCashAdded));
					} catch (Exception e) {
					}
				}
			}
			String totalAssetsLine = array[14];
			String[] totalAssetsArray = totalAssetsLine.split(",");
			for (int i = 1; i < totalAssetsArray.length; i++) {
				if (!totalAssetsArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sTotalAssets = totalAssetsArray[i];
					try {
						stockReport
								.setTotalAssets(Double.valueOf(sTotalAssets));
					} catch (Exception e) {
					}
				}
			}
			String currentAssetsLine = array[15];
			String[] currentAssetsArray = currentAssetsLine.split(",");
			for (int i = 1; i < currentAssetsArray.length; i++) {
				if (!currentAssetsArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sCurrentAssets = currentAssetsArray[i];
					try {
						stockReport.setCurrentAssets(Double
								.valueOf(sCurrentAssets));
					} catch (Exception e) {
					}
				}
			}
			String grossLiabilityLine = array[16];
			String[] grossLiabilityArray = grossLiabilityLine.split(",");
			for (int i = 1; i < grossLiabilityArray.length; i++) {
				if (!grossLiabilityArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sGrossLiability = grossLiabilityArray[i];
					try {
						stockReport.setGrossLiability(Double
								.valueOf(sGrossLiability));
					} catch (Exception e) {
					}
				}
			}
			String currentLiabilitiesLine = array[17];
			String[] currentLiabilitiesArray = currentLiabilitiesLine
					.split(",");
			for (int i = 1; i < currentLiabilitiesArray.length; i++) {
				if (!currentLiabilitiesArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sCurrentLiabilities = currentLiabilitiesArray[i];
					try {
						stockReport.setCurrentLiabilities(Double
								.valueOf(sCurrentLiabilities));
					} catch (Exception e) {
					}
				}
			}
			String netAssetsLine = array[18];
			String[] netAssetsArray = netAssetsLine.split(",");
			for (int i = 1; i < netAssetsArray.length; i++) {
				if (!netAssetsArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sNetAssets = netAssetsArray[i];
					try {
						stockReport.setNetAssets(Double.valueOf(sNetAssets));
					} catch (Exception e) {
					}
				}
			}
			String roeLine = array[19];
			String[] roeArray = roeLine.split(",");
			for (int i = 1; i < list.size() + 1; i++) {
				if (!roeArray[i].equals("")) {
					StockReportDO stockReport = list.get(i - 1);
					String sRoe = roeArray[i];
					try {
						stockReport.setRoe(Double.valueOf(sRoe));
					} catch (Exception e) {
					}
				}
			}
		}
		return list;
	}

	public List<StockPriceDO> getStockPriceInCsv(String csv) {
		List<StockPriceDO> list = new ArrayList<StockPriceDO>();
		String[] array = csv.split(System.getProperty("line.separator"));
		if (array.length > 1) {
			for (int i = 1; i < array.length; i++) {
				String row = array[i];
				String[] elements = row.split(",");
				StockPriceDO stockPriceDO = new StockPriceDO();
				try {
					String[] dateArray = elements[0].split("-");
					stockPriceDO.setDate(Long.valueOf((dateArray[0]
							+ dateArray[1] + dateArray[2])));
				} catch (Exception e) {
				}
				stockPriceDO.setCode(elements[1].substring(1));
				stockPriceDO.setId(stockPriceDO.getCode()
						+ stockPriceDO.getDate());
				stockPriceDO.setName(elements[2]);
				try {
					double close = Double.valueOf(elements[3]);
					stockPriceDO.setClose(close);
				} catch (Exception e) {
				}
				try {
					double highest = Double.valueOf(elements[4]);
					stockPriceDO.setHighest(highest);
				} catch (Exception e) {
				}
				try {
					double lowest = Double.valueOf(elements[5]);
					stockPriceDO.setLowest(lowest);
				} catch (Exception e) {
				}
				try {
					double open = Double.valueOf(elements[6]);
					stockPriceDO.setOpen(open);
				} catch (Exception e) {
				}
				try {
					double priviousClose = Double.valueOf(elements[7]);
					stockPriceDO.setPreviousClose(priviousClose);
				} catch (Exception e) {
				}
				try {
					double changeAmount = Double.valueOf(elements[8]);
					stockPriceDO.setChangeAmount(changeAmount);
				} catch (Exception e) {
				}
				try {
					double changeRate = Double.valueOf(elements[9]);
					stockPriceDO.setChangeRate(changeRate);
				} catch (Exception e) {
				}
				try {
					double turnoverRate = Double.valueOf(elements[10]);
					stockPriceDO.setTurnoverRate(turnoverRate);
				} catch (Exception e) {
				}
				try {
					double turnover = Double.valueOf(elements[11]);
					stockPriceDO.setTurnover(turnover);
				} catch (Exception e) {
				}
				try {
					double amount = Double.valueOf(elements[12]);
					stockPriceDO.setAmount(amount);
				} catch (Exception e) {
				}
				try {
					double totalValue = Double.valueOf(elements[13]);
					stockPriceDO.setTotalValue(totalValue);
				} catch (Exception e) {
				}
				try {
					double marketValue = Double.valueOf(elements[14]);
					stockPriceDO.setMarketValue(marketValue);
				} catch (Exception e) {
				}
				list.add(stockPriceDO);
			}
		}
		return list;
	}
}

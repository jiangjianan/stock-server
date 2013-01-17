package com.jiangjianan.stock.server.util;

import java.util.ArrayList;
import java.util.List;

import com.jiangjianan.stock.server.object.StockPriceDO;

public class CsvUtil {
	public static List<StockPriceDO> getStockPrice(String csv) {
		List<StockPriceDO> list = new ArrayList<StockPriceDO>();
		String[] array = csv.split(";");
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
		System.out.println(list.size());
		return list;
	}
}

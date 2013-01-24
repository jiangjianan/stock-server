package com.jiangjianan.stock.server.object;

import com.jiangjianan.stock.server.common.object.BaseDO;

public class StockPriceDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	private String id;
	private Long date;
	private String code;
	private String name;
	private Double highest;
	private Double lowest;
	private Double open;
	private Double close;
	private Double previousClose;
	private Double changeAmount;
	private Double changeRate;
	private Double turnoverRate;
	private Double turnover;
	private Double amount;
	private Double totalValue;
	private Double marketValue;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getHighest() {
		return highest;
	}

	public void setHighest(Double highest) {
		this.highest = highest;
	}

	public Double getLowest() {
		return lowest;
	}

	public void setLowest(Double lowest) {
		this.lowest = lowest;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(Double previousClose) {
		this.previousClose = previousClose;
	}

	public Double getChangeAmount() {
		return changeAmount;
	}

	public void setChangeAmount(Double changeAmount) {
		this.changeAmount = changeAmount;
	}

	public Double getChangeRate() {
		return changeRate;
	}

	public void setChangeRate(Double changeRate) {
		this.changeRate = changeRate;
	}

	public Double getTurnoverRate() {
		return turnoverRate;
	}

	public void setTurnoverRate(Double turnoverRate) {
		this.turnoverRate = turnoverRate;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}

	public String getDateString() {
		long year = date / 10000;
		long month = date % 10000 / 100;
		long day = date % 100;
		return year + "-" + month + "-" + day;
	}

	public String getTotalValueString() {
		return exchange(totalValue);
	}
	
	public String getAmountString() {
		return exchange(amount);
	}
	
	public String exchange(Double origin) {
		if (origin == null) {
			return null;
		}
		double value = origin / 100000000L;
		return String.format("%.2f", value);
	}

}

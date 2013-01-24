package com.jiangjianan.stock.server.object;

import com.jiangjianan.stock.server.common.object.BaseDO;

public class StockAnalyzeDO extends BaseDO {
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String date;
	private Double price;
	private Double totalValue;
	private Double capital;
	private Double netProfit;
	private Double priviousNetProfit;
	private Double previousYearNetProfit;
	private Double eps;
	private Double netProfitRate;
	private Double netAssets;
	private Double navps;
	private Double roe;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital = capital;
	}

	public Double getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}

	public Double getPriviousNetProfit() {
		return priviousNetProfit;
	}

	public void setPriviousNetProfit(Double priviousNetProfit) {
		this.priviousNetProfit = priviousNetProfit;
	}

	public Double getPreviousYearNetProfit() {
		return previousYearNetProfit;
	}

	public void setPreviousYearNetProfit(Double previousYearNetProfit) {
		this.previousYearNetProfit = previousYearNetProfit;
	}

	public Double getEps() {
		return eps;
	}

	public void setEps(Double eps) {
		this.eps = eps;
	}

	public Double getNetProfitRate() {
		return netProfitRate;
	}

	public void setNetProfitRate(Double netProfitRate) {
		this.netProfitRate = netProfitRate;
	}

	public Double getNetAssets() {
		return netAssets;
	}

	public void setNetAssets(Double netAssets) {
		this.netAssets = netAssets;
	}

	public Double getNavps() {
		return navps;
	}

	public void setNavps(Double navps) {
		this.navps = navps;
	}

	public Double getRoe() {
		return roe;
	}

	public void setRoe(Double roe) {
		this.roe = roe;
	}

}

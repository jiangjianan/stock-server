package com.jiangjianan.stock.server.object;

import com.jiangjianan.stock.server.common.object.BaseDO;

public class StockReportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	// id = code + date
	private String id;
	private String code;
	private Long date;

	// Earnings per share 基本每股收益(元)
	private Double eps;
	// Net asset value per share 每股净资产(元)
	private Double navps;
	// 每股经营活动产生的现金流量净额(元)
	private Double cashFlowPerStock;
	// 主营业务收入(万元)
	private Double businessIncome;
	// 主营业务利润(万元)
	private Double grossProfit;
	// 营业利润(万元)
	private Double businessProfit;
	// 投资收益(万元)
	private Double investProfit;
	// 营业外收支净额(万元)
	private Double nonOperationIncome;
	// 利润总额(万元)
	private Double totalProfit;
	// 净利润(万元)
	private Double netProfit;
	// 净利润(扣除非经常性损益后)(万元)
	private Double deductNetProfit;
	// 经营活动产生的现金流量净额(万元)
	private Double cashFlow;
	// 现金及现金等价物净增加额(万元)
	private Double cashAdded;
	// 总资产(万元)
	private Double totalAssets;
	// 流动资产(万元)
	private Double currentAssets;
	// 总负债(万元)
	private Double grossLiability;
	// 流动负债(万元)
	private Double currentLiabilities;
	// 股东权益不含少数股东权益(万元)
	private Double netAssets;
	// 净资产收益率加权(%)
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

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Double getEps() {
		return eps;
	}

	public void setEps(Double eps) {
		this.eps = eps;
	}

	public Double getNavps() {
		return navps;
	}

	public void setNavps(Double navps) {
		this.navps = navps;
	}

	public Double getCashFlowPerStock() {
		return cashFlowPerStock;
	}

	public void setCashFlowPerStock(Double cashFlowPerStock) {
		this.cashFlowPerStock = cashFlowPerStock;
	}

	public Double getBusinessIncome() {
		return businessIncome;
	}

	public void setBusinessIncome(Double businessIncome) {
		this.businessIncome = businessIncome;
	}

	public Double getGrossProfit() {
		return grossProfit;
	}

	public void setGrossProfit(Double grossProfit) {
		this.grossProfit = grossProfit;
	}

	public Double getBusinessProfit() {
		return businessProfit;
	}

	public void setBusinessProfit(Double businessProfit) {
		this.businessProfit = businessProfit;
	}

	public Double getInvestProfit() {
		return investProfit;
	}

	public void setInvestProfit(Double investProfit) {
		this.investProfit = investProfit;
	}

	public Double getNonOperationIncome() {
		return nonOperationIncome;
	}

	public void setNonOperationIncome(Double nonOperationIncome) {
		this.nonOperationIncome = nonOperationIncome;
	}

	public Double getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(Double totalProfit) {
		this.totalProfit = totalProfit;
	}

	public Double getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}

	public Double getDeductNetProfit() {
		return deductNetProfit;
	}

	public void setDeductNetProfit(Double deductNetProfit) {
		this.deductNetProfit = deductNetProfit;
	}

	public Double getCashFlow() {
		return cashFlow;
	}

	public void setCashFlow(Double cashFlow) {
		this.cashFlow = cashFlow;
	}

	public Double getCashAdded() {
		return cashAdded;
	}

	public void setCashAdded(Double cashAdded) {
		this.cashAdded = cashAdded;
	}

	public Double getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(Double totalAssets) {
		this.totalAssets = totalAssets;
	}

	public Double getCurrentAssets() {
		return currentAssets;
	}

	public void setCurrentAssets(Double currentAssets) {
		this.currentAssets = currentAssets;
	}

	public Double getGrossLiability() {
		return grossLiability;
	}

	public void setGrossLiability(Double grossLiability) {
		this.grossLiability = grossLiability;
	}

	public Double getCurrentLiabilities() {
		return currentLiabilities;
	}

	public void setCurrentLiabilities(Double currentLiabilities) {
		this.currentLiabilities = currentLiabilities;
	}

	public Double getNetAssets() {
		return netAssets;
	}

	public void setNetAssets(Double netAssets) {
		this.netAssets = netAssets;
	}

	public Double getRoe() {
		return roe;
	}

	public void setRoe(Double roe) {
		this.roe = roe;
	}

}

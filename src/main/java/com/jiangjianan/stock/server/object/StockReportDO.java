package com.jiangjianan.stock.server.object;

import com.jiangjianan.stock.server.common.object.BaseDO;

public class StockReportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	// id = code + date
	private String id;
	private String code;
	private Long date;

	// Earnings per share ����ÿ������(Ԫ)
	private Double eps;
	// Net asset value per share ÿ�ɾ��ʲ�(Ԫ)
	private Double navps;
	// ÿ�ɾ�Ӫ��������ֽ���������(Ԫ)
	private Double cashFlowPerStock;
	// ��Ӫҵ������(��Ԫ)
	private Double businessIncome;
	// ��Ӫҵ������(��Ԫ)
	private Double grossProfit;
	// Ӫҵ����(��Ԫ)
	private Double businessProfit;
	// Ͷ������(��Ԫ)
	private Double investProfit;
	// Ӫҵ����֧����(��Ԫ)
	private Double nonOperationIncome;
	// �����ܶ�(��Ԫ)
	private Double totalProfit;
	// ������(��Ԫ)
	private Double netProfit;
	// ������(�۳��Ǿ����������)(��Ԫ)
	private Double deductNetProfit;
	// ��Ӫ��������ֽ���������(��Ԫ)
	private Double cashFlow;
	// �ֽ��ֽ�ȼ��ﾻ���Ӷ�(��Ԫ)
	private Double cashAdded;
	// ���ʲ�(��Ԫ)
	private Double totalAssets;
	// �����ʲ�(��Ԫ)
	private Double currentAssets;
	// �ܸ�ծ(��Ԫ)
	private Double grossLiability;
	// ������ծ(��Ԫ)
	private Double currentLiabilities;
	// �ɶ�Ȩ�治�������ɶ�Ȩ��(��Ԫ)
	private Double netAssets;
	// ���ʲ������ʼ�Ȩ(%)
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

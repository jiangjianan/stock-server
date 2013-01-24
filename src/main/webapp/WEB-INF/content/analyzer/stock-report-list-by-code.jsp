<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container">
	<table class="table table-striped">
		<tbody>
			<tr>
				<th>报告日期</th>
				<s:iterator value="stockReportList">
					<td><s:property value="date" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>基本每股收益(元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="eps" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>基本每股收益(元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="navps" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>每股经营活动产生的现金流量净额(元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="cashFlowPerStock" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>主营业务收入(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="businessIncome" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>主营业务利润(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="grossProfit" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>营业利润(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="businessProfit" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>投资收益(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="investProfit" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>营业外收支净额(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="nonOperationIncome" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>利润总额(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="totalProfit" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>净利润(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="netProfit" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>净利润(扣除非经常性损益后)(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="deductNetProfit" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>经营活动产生的现金流量净额(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="cashFlow" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>现金及现金等价物净增加额(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="cashAdded" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>总资产(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="totalAssets" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>流动资产(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="currentAssets" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>总负债(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="grossLiability" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>流动负债(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="currentLiabilities" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>股东权益不含少数股东权益(万元)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="netAssets" /></td>
				</s:iterator>
			</tr>
			<tr>
				<th>净资产收益率加权(%)</th>
				<s:iterator value="stockReportList">
					<td><s:property value="roe" /></td>
				</s:iterator>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>
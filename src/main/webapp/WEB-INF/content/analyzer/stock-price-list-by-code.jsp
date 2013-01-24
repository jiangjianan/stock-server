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
		<thead>
			<tr>
				<th>日期</th>
				<th>股票代码</th>
				<th>名称</th>
				<th>收盘价</th>
				<th>涨跌额</th>
				<th>涨跌幅</th>
				<th>换手率</th>
				<th>成交金额</th>
				<th>总市值</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="stockPriceList">
				<tr>
					<td><s:property value="date" /></td>
					<td><s:property value="code" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="close" /></td>
					<td><s:property value="changeAmount" /></td>
					<td><s:property value="changeRate" />%</td>
					<td><s:property value="turnoverRate" /></td>
					<td><s:property value="amountString" /></td>
					<td><s:property value="totalValueString" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
</body>
</html>
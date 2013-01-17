<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>日期</th>
				<th>编号</th>
				<th>名称</th>
				<th>收盘价</th>
				<th>开盘价</th>
				<th>最低价</th>
				<th>最高价</th>
				<th>前收盘</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="stockPriceList">
				<tr>
					<td><s:property value="date" /></td>
					<td><s:property value="code" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="close" /></td>
					<td><s:property value="open" /></td>
					<td><s:property value="lowest" /></td>
					<td><s:property value="highest" /></td>
					<td><s:property value="previousClose" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="/js/jquery-1.9.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<title>我的关注</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../module/nav.jsp" flush="true">
			<jsp:param name="index" value="3" />
		</jsp:include>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>代码</th>
					<th>名称</th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="stockInfoList">
					<tr>
						<td><s:property value="code" /></td>
						<td><s:property value="name" /></td>
						<td><a href="/announcement/stock-announcement-list-by-code.action?code=<s:property value="code" />">公告列表</a></td>
						<td><a href="/analyzer/stock-report-list-by-code.action?code=<s:property value="code" />">财务报表</a></td>
						<td><a href="/analyzer/stock-price-list-by-code.action?code=<s:property value="code" />">价格列表</a></td>
						<td><a href="update-stock-price.action?code=<s:property value="code" />">重建</a></td>
						<td><a href="delete-stock-info.action?code=<s:property value="code" />">删除</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<a href="/announcement/update-all-stock-announcement.action">更新全部公告列表</a>
		<a href="/analyzer/update-all-stock-report.action">更新全部财务报表</a>
		<a href="/analyzer/update-all-stock-price.action">更新全部价格列表</a>
		<form action="insert-stock-info.action" method="post">
			<input type="text" name="code" value="" />
			<input class="btn btn-primary" type="submit" name="" value="添加新股票" />
		</form>
	</div>
</body>
</html>
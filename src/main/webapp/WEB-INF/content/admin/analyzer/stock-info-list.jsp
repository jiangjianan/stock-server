<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>博客列表</title>
</head>
<body>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>code</th>
				<th>name</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="stockInfoList">
				<tr>
					<td><s:property value="code" /></td>
					<td><s:property value="name" /></td>
					<td><a href="update-stock-price.action?code=<s:property value="code" />">重建</a></td>
					<td><a href="delete-stock-info.action?code=<s:property value="code" />">删除</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<form action="insert-stock-info.action" method="post">
		<input type="text" name="code" value="" /> 
		<input class="btn btn-primary" type="submit" name="" value="添加新股票" />
	</form>
	<div><a href="../announcement/update-all-stock-announcement.action">更新所有公告</a></div>
</div>
</body>
</html>
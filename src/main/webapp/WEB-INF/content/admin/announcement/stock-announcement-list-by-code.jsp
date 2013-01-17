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
	<div><a href="update-stock-announcement-by-code.action?code=<s:property value="code" />">更新公告</a></div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>标题</th>
				<th>日期</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="stockAnnouncementList">
				<tr>
					<td><s:property value="id" /></td>
					<td><a href="<s:property value="url" />" target="_blank"><s:property value="title" /></a></td>
					<td><s:property value="date" /></td>
					<td><a href="delete-stock-announcement-by-id.action?id=<s:property value="id" />&code=<s:property value="code" />" >删除</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
</body>
</html>
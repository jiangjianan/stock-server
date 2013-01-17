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
				<th>blogUid</th>
				<th>userNick</th>
				<th>blogName</th>
				<th>articleCount</th>
				<th>blogUrl</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="blogList">
				<tr>
					<td><s:property value="blogUid" /></td>
					<td><s:property value="userNick" /></td>
					<td><s:property value="blogName" /></td>
					<td><s:property value="articleCount" /></td>
					<td><a href="<s:property value="blogUrl" />"><s:property value="blogUrl" /></a></td>
					<td><a href="update-blog-article.action?blogUid=<s:property value="blogUid" />&force=false&quick=true">快速更新</a></td>
					<td><a href="update-blog-article.action?blogUid=<s:property value="blogUid" />&force=false&quick=false">更新</a></td>
					<td><a href="update-blog-article.action?blogUid=<s:property value="blogUid" />&force=true">重建</a></td>
					<td><a href="delete-blog.action?blogUid=<s:property value="blogUid" />">删除</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<a href="update-all-blog-article.action?force=false&quick=true">快速全部更新</a>
	<a href="update-all-blog-article.action?force=false&quick=false">全部更新</a>
	<a href="update-all-blog-article.action?force=true">全部重建</a>
	<form action="insert-blog.action" method="post">
		<input type="text" name="blogUid" value="" /> 
		<input class="btn btn-primary" type="submit" name="" value="添加新博客" />
	</form>
</div>
</body>
</html>
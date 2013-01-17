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
	<div><a href="recent-article-list.action">最近三天更新的博客</a></div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>名称</th>
				<th>博客</th>
				<th>数量</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="blogList">
				<tr>
					<td><s:property value="blogUid" /></td>
					<td><s:property value="userNick" /></td>
					<td><a href="<s:property value="blogUrl" />"><s:property value="blogName" /></a></td>
					<td><s:property value="articleCount" /></td>
					<td><a href="article-list-by-blog-uid.action?blogUid=<s:property value="blogUid" />" >查看</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
</body>
</html>
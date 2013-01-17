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
	<div><a href="update-article-list.action">最近三天更新的博客</a></div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>作者</th>
				<th>标题</th>
				<th>时间</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="articleList">
				<tr>
					<td><a href="http://blog.sina.com.cn/u/<s:property value="blogUid" />"><s:property value="userNick" /></a></td>
					<td><a href="http://blog.sina.com.cn/s/blog_<s:property value="articleId" />.html"><s:property value="articleTitle" /></a></td>
					<td><s:property value="articlePubdate" /></td>
					<td><a href="article-by-id.action?articleId=<s:property value="articleId" />" >查看</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
</body>
</html>
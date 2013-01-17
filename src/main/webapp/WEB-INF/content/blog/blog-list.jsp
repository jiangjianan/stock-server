<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>博客列表</title>
</head>
<body>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="/index.action">价值投资</a>
				<ul class="nav">
					<li><a href="/info/stock-info-list.action">股票列表</a></li>
					<li class="divider-vertical"></li>
					<li><a href="/announcement/recent-stock-announcement-list.action">公司公告</a></li>
					<li class="divider-vertical"></li>
					<li class="active"><a href="/blog/blog-list.action">博客列表</a></li>
				</ul>
			</div>
		</div>
		<a href="recent-article-list.action">最近三天更新的博客</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>名称</th>
					<th>博客</th>
					<th>数量</th>
					<th></th>
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
						<td><a href="<s:property value="blogUrl" />" target="_blank"><s:property value="blogName" /></a></td>
						<td><s:property value="articleCount" /></td>
						<td><a href="article-list-by-blog-uid.action?blogUid=<s:property value="blogUid" />" target="_blank">查看列表</a></td>
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
		<a href="login.action">登录</a>
		<form action="insert-blog.action" method="post">
			<input type="text" name="blogUid" value="" />
			<input class="btn btn-primary" type="submit" name="" value="添加新博客" />
		</form>
	</div>
</body>
</html>
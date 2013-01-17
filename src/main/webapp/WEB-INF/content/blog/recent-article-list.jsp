<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<title><s:property value="articleDO.articleTitle" /></title>
</head>
<body>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="/index.action">价值投资</a>
				<ul class="nav">
					<li><a href="/info/stock-info-list.action">股票列表</a></li>
					<li class="divider-vertical"></li>
					<li><a href="/announcement/recent-stock-announcement-list.action" target="_blank">公司公告</a></li>
					<li class="divider-vertical"></li>
					<li class="active"><a href="/blog/blog-list.action">博客列表</a></li>
				</ul>
			</div>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>作者</th>
					<th>标题</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="articleList">
					<tr>
						<td><s:property value="userNick" /></td>
						<td><a href="http://blog.sina.com.cn/s/blog_<s:property value="articleId" />.html" target="_blank"><s:property value="articleTitle" /></a></td>
						<td><s:property value="articlePubdate" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>
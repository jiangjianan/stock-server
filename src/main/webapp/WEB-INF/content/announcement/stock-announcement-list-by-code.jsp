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
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="/index.action">价值投资</a>
				<ul class="nav">
					<li><a href="/info/stock-info-list.action">股票列表</a></li>
					<li class="divider-vertical"></li>
					<li><a href="/announcement/recent-stock-announcement-list.action">公司公告</a></li>
					<li class="divider-vertical"></li>
					<li><a href="/blog/blog-list.action">价值名博</a></li>
				</ul>
			</div>
		</div>

		<a href="update-stock-announcement-by-code.action?code=<s:property value="code" />">更新公告</a>
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
						<td><a href="delete-stock-announcement-by-id.action?id=<s:property value="id" />&code=<s:property value="code" />">删除</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>
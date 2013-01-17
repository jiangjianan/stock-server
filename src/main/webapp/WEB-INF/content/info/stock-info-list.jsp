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
					<li class="active"><a href="/info/stock-info-list.action">股票列表</a></li>
					<li class="divider-vertical"></li>
					<li><a href="/announcement/recent-stock-announcement-list.action">公司公告</a></li>
					<li class="divider-vertical"></li>
					<li><a href="/blog/blog-list.action">价值名博</a></li>
				</ul>
			</div>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>代码</th>
					<th>名称</th>
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
						<td><a
							href="/announcement/stock-announcement-list-by-code.action?code=<s:property value="code" />">公告列表</a></td>
						<td><a href="update-stock-price.action?code=<s:property value="code" />">重建</a></td>
						<td><a href="delete-stock-info.action?code=<s:property value="code" />">删除</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<a href="/announcement/update-all-stock-announcement.action">更新全部公告列表</a>
		<form action="insert-stock-info.action" method="post">
			<input type="text" name="code" value="" />
			<input class="btn btn-primary" type="submit" name="" value="添加新股票" />
		</form>
	</div>
</body>
</html>
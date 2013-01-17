<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>首页</title>
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
	</div>
</body>
</html>
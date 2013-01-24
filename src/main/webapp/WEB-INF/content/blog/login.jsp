<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="/js/jquery-1.9.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<title>新浪博客登录</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../module/nav.jsp" flush="true">
			<jsp:param name="index" value="3" />
		</jsp:include>
		
		<a href="https://auth.sina.com.cn/oauth2/authorize?client_id=1679260282&redirect_uri=http://www.jiangjianan.com" target="_blank">获取code</a>
		<p>${requestScope.message}</p>
		
		<form action="login.action" method="get">
			<input type="text" name="code" placeholder="code" value="" />
			<input class="btn btn-primary" type="submit" name="" value="登录" />
		</form>
	</div>
</body>
</html>
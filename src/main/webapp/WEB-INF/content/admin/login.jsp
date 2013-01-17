<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>登录</title>
</head>
<body>
<div class="container">
	<p><a href="https://auth.sina.com.cn/oauth2/authorize?client_id=1679260282&redirect_uri=http://www.jiangjianan.com" target="_blank">获取code</a></p>
	<s:property value="message" />
	<form action="login.action" method="get">
		code:<input type="text" name="code" value="" />
		<input class="btn btn-primary" type="submit" name="" value="登录" />
	</form>
</div>
</body>
</html>
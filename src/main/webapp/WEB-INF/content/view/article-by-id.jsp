<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<title><s:property value="articleDO.articleTitle" /></title>
</head>
<body>
<div class="container">
	<h1><s:property value="articleDO.articleTitle" /></h1>
	<h6><s:property value="articleDO.articlePubdate" /></h6>
	<p><s:property escape="0" value="articleDO.articleBody" /></p>
</div>
</body>
</html>
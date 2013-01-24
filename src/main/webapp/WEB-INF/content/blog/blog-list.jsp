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
<title>博客列表</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../module/nav.jsp" flush="true">
			<jsp:param name="index" value="3" />
		</jsp:include>
		
		<jsp:include page="../module/page_changer.jsp" flush="true">
			<jsp:param name="currentPage" value="${requestScope.page}" />
			<jsp:param name="pageCount" value="${requestScope.pageCount}" />
			<jsp:param name="pageUrl" value="blog-list.action?page=" />
		</jsp:include>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>名称</th>
					<th>博客</th>
					<th>数量</th>
					<th></th>
					<c:if test="${sessionScope.user.type == 2}">
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="blog" items="${requestScope.blogList}">
					<tr>
						<td>${blog.blogUid}</td>
						<td>${blog.userNick}</td>
						<td><a href="${blog.blogUrl}" target="_blank">${blog.blogName}</a></td>
						<td>${blog.articleCount}</td>
						<td><a href="article-list-by-blog-uid.action?blogUid=${blog.blogUid}">查看列表</a></td>
						<c:if test="${sessionScope.user.type == 2}">
						<td><a href="update-blog-article.action?blogUid=${blog.blogUid}>&force=false&quick=true">快速更新</a></td>
						<td><a href="update-blog-article.action?blogUid=${blog.blogUid}&force=false&quick=false">更新</a></td>
						<td><a href="update-blog-article.action?blogUid=${blog.blogUid}&force=true">重建</a></td>
						<td><a href="delete-blog.action?blogUid=${blog.blogUid}">删除</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<jsp:include page="../module/page_changer.jsp" flush="true">
			<jsp:param name="currentPage" value="${requestScope.page}" />
			<jsp:param name="pageCount" value="${requestScope.pageCount}" />
			<jsp:param name="pageUrl" value="blog-list.action?page=" />
		</jsp:include>
		
		<c:if test="${sessionScope.user.type == 2}">
		<a href="update-all-blog-article.action?force=false&quick=true">快速全部更新</a>
		<a href="update-all-blog-article.action?force=false&quick=false">全部更新</a>
		<a href="update-all-blog-article.action?force=true">全部重建</a>
		<form action="insert-blog.action" method="post">
			<input type="text" name="blogUid" value="" />
			<input class="btn btn-primary" type="submit" name="" value="添加新博客" />
		</form>
		</c:if>
	</div>
</body>
</html>
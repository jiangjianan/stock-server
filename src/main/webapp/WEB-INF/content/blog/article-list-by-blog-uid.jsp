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
<title>价值博客文章列表</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../module/nav.jsp" flush="true">
			<jsp:param name="index" value="3" />
		</jsp:include>
		
		<jsp:include page="../module/page_changer.jsp" flush="true">
			<jsp:param name="currentPage" value="${requestScope.page}" />
			<jsp:param name="pageCount" value="${requestScope.pageCount}" />
			<jsp:param name="pageUrl" value="article-list-by-blog-uid.action?blogUid=${requestScope.blogUid}&page=" />
		</jsp:include>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>作者</th>
					<th>标题</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${requestScope.articleList}">
					<tr>
						<td>${article.userNick}</td>
						<td><a href="http://blog.sina.com.cn/s/blog_${article.articleId}.html" target="_blank">${article.articleTitle}</a></td>
						<td>${article.articlePubdateString}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<jsp:include page="../module/page_changer.jsp" flush="true">
			<jsp:param name="currentPage" value="${requestScope.page}" />
			<jsp:param name="pageCount" value="${requestScope.pageCount}" />
			<jsp:param name="pageUrl" value="recent-list-by-blog-uid.action?${requestScope.blogUid}&page=" />
		</jsp:include>
	</div>
</body>
</html>
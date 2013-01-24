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
</head>
<body>
	<div class="container">
		<jsp:include page="../module/nav.jsp" flush="true">
			<jsp:param name="index" value="2" />
		</jsp:include>
		
		<jsp:include page="../module/page_changer.jsp" flush="true">
			<jsp:param name="currentPage" value="${requestScope.page}" />
			<jsp:param name="pageCount" value="${requestScope.pageCount}" />
			<jsp:param name="pageUrl" value="recent-stock-announcement-list.action?page=" />
		</jsp:include>

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
				<c:forEach var="stockAnnouncement" items="${requestScope.stockAnnouncementList}">
					<tr>
						<td>${stockAnnouncement.id}</td>
						<td><a href="${stockAnnouncement.url}" target="_blank">${stockAnnouncement.title}</a></td>
						<td>${stockAnnouncement.dateString}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<jsp:include page="../module/page_changer.jsp" flush="true">
			<jsp:param name="currentPage" value="${requestScope.page}" />
			<jsp:param name="pageCount" value="${requestScope.pageCount}" />
			<jsp:param name="pageUrl" value="recent-stock-announcement-list.action?page=" />
		</jsp:include>
	</div>
</body>
</html>
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
<title>我的关注</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../module/nav.jsp" flush="true">
			<jsp:param name="index" value="1" />
		</jsp:include>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>代码</th>
					<th>名称</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="stockAttention" items="${requestScope.stockAttentionList}">
					<tr>
						<td>${stockAttention.code}</td>
						<td>${stockAttention.name}</td>
						<td><a href="/announcement/stock-announcement-list-by-code.action?code=${stockAttention.code}">公告列表</a></td>
						<td><a href="delete-stock-attention.action?id=${stockAttention.id}">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form class="form-inline" action="insert-stock-attention-by-code.action" method="post">
			<input type="text" name="code" value="" />
			<input class="btn btn-primary" type="submit" name="" value="添加新股票" />
		</form>
		
		<c:if test="${sessionScope.user.type == 2}">
		<a href="/announcement/update-all-stock-announcement.action">更新全部公告</a>
		</c:if>
	</div>
</body>
</html>
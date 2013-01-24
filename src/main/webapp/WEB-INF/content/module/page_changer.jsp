<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pagination pagination-right">
	<ul>
		<c:choose>
			<c:when test="${param.currentPage==1}">
				<li class="disabled"><a href="">上一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${param.pageUrl}${param.currentPage-1}">上一页</a></li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="1" end="${param.pageCount}" step="1">
			<c:choose>
				<c:when test="${param.currentPage==i}">
					<li class="active"><a href="${param.pageUrl}${i}">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${param.pageUrl}${i}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${param.currentPage==param.pageCount}">
				<li class="disabled"><a href="">下一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${param.pageUrl}${param.currentPage+1}">下一页</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
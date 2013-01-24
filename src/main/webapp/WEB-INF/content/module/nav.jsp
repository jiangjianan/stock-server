<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar">
	<div class="navbar-inner">
		<a class="brand" href="/index.action">价值投资</a>
		<ul class="nav">
			<li class="divider-vertical"></li>
			<c:choose>
				<c:when test="${param.index == 1}">
					<li class="active"><a href="/attention/stock-attention-list.action">我的关注</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/attention/stock-attention-list.action">我的关注</a></li>
				</c:otherwise>
			</c:choose>
			<li class="divider-vertical"></li>
			<c:choose>
				<c:when test="${param.index == 2}">
					<li class="active"><a href="/announcement/recent-stock-announcement-list.action">公司公告</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/announcement/recent-stock-announcement-list.action">公司公告</a></li>
				</c:otherwise>
			</c:choose>
			<li class="divider-vertical"></li>
			<c:choose>
				<c:when test="${param.index == 3}">
					<li class="active dropdown">
				</c:when>
				<c:otherwise>
					<li class="dropdown">
				</c:otherwise>
			</c:choose>
				<a href="" class="dropdown-toggle" data-toggle="dropdown">价值博客 <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="/blog/blog-list.action">价值博客列表</a></li>
					<li><a href="/blog/recent-article-list.action">最近一周的博文</a></li>
					<c:if test="${sessionScope.user.type == 2}">
					<li><a href="/blog/login.action">新浪博客登陆</a></li>
					</c:if>
				</ul>
			</li>
		</ul>
		<ul class="nav pull-right">
			<c:choose>
				<c:when test="${sessionScope.user != null}">
					<li><a>欢迎 ${sessionScope.user.name}</a><li>
					<li><a href="/user/logoff.action">退出</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/user/register-input.action">注册</a></li>
					<li><a href="/user/login-input.action">登录</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
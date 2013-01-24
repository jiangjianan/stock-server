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
		<jsp:include page="../module/nav.jsp" flush="true" />
		
		<form action="/user/register.action" method="post"
			class="form-horizontal">
			<div class="control-group">
				<label class="control-label" for="name">账号</label>
				<div class="controls">
					<input type="text" id="name" name="name" placeholder="账号" value="" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="password">密码</label>
				<div class="controls">
					<input type="password" id="password" name="password"
						placeholder="密码" value="" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="repassword">确认密码</label>
				<div class="controls">
					<input type="password" id="repassword" name="repassword" placeholder="确认密码" value="" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="email">邮箱</label>
				<div class="controls">
					<input type="text" id="email" name="email" placeholder="邮箱" value="" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-large btn-primary">注册</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
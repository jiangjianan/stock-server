<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>消息</title>
</head>
<body>
<div class="container">
	<table class="table table-striped">
		<tbody>
			<s:iterator value="messages" id="key">
				<tr>
					<td><s:property value="key" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
</body>
</html>
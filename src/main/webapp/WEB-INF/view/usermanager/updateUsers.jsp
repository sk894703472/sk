<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/1.jpg');background-size: cover;">
	<form action="<%=request.getContextPath() %>/user/update" method="post">
		<input type="hidden" value="${user.id }" name="id">
		用户名：<input type="text" name="userName" value="${user.userName }"><br>
		用户密码：<input type="text" name="password" value="${user.password }"><br>
		用户年龄：<input type="text" name="age" value="${user.age }"><br>
		<input type="submit" name="" value="修改">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/1.jpg');background-size: cover;">

<center>
	<h3 style="color:red">请输入用户名称或是用户id进行查询</h3>
	<form action="<%=request.getContextPath() %>/user/find" method="post">
		用户名称：<input type="text" name="userName"><br>
		用户id：<input type="text" name="id"><br><br>
		<c:if test="${re.state==1 }">
		<table border="1" cellspacing="0">
			<tr>
				<td>用户名称</td>
				<td>用户id</td>
				<td>年龄</td>
				<td>用户密码</td>
			</tr>
			<tr>
				<td>${re.content.userName }</td>
				<td>${re.content.id }</td>
				<td>${re.content.age }</td>
				<td>${re.content.password }</td>
			</tr>
		</table>
		</c:if>
		<c:if test="${!(empty requestScope.re)&&re.state==0 }">
		  <span>${re.message }</span><br>
		</c:if>
		<input type="submit" value="查询">
	</form>
</center>
</body>
</html>
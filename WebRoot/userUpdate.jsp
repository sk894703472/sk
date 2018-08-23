<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
input{
text-align:center;
margin-top:30px;
}
</style>
</head>
<body>
<div>
<div style="text-align:center;maigin-top:50px;color:red">${msg}</div>
<h2 style="text-align:center"> 用户信息修改</h2>
</div>
<form action="/sk/UserUpdate" method="post" style="text-align:center">
<label for="id">编号:</label>
<input type="text" id="id" name="id" value="${user.id }" readonly="readonly" placeholder="编号"/><br>
<label for="name">姓名:</label>
<input type="text" id="name" name="name" value="${user.name }" placeholder="名称"/><br>
<label for="password">密码:</label>
<input type="text" id="password" name="password" value="${user.password }" placeholder="密码"/><br>
<input type="submit" value="修改"/>
</form>
</body>
</html>
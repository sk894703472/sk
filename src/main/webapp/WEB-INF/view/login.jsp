<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/312024.jpg');background-size: cover;">
 <div align="center">
 <div style="font-size:x-large;">电子商务管理信息系统</div><br><br>
 <font color="red">${mess }</font>
    <form action="<%=request.getContextPath() %>/user/login" method="post">
    	用户名:<input type="text" name="userName" /><br><br>
    	password:<input type="password" name="password" /><br>
    	<input type="submit" value="登陆">
    </form>
 </div> 
  </body>
</html>

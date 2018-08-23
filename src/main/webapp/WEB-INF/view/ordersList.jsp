<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/1.jpg');background-size: cover;">

<%
	String path=request.getContextPath();
	request.setAttribute("path", path);
%>
<center>
	<h2>商品信息管理</h2><br>
	<form action="<%=request.getContextPath() %>/orders/findone" method="post">
		订单id：<input type="text" name="Id"><font color="red">*请输入订单id</font><br><br>
		<c:if test="${!(empty mess)}">
		  <span>${mess }</span><br>
		</c:if>
		<input type="submit" value="订单查询">
	</form>
	
	<table border="1" cellspacing="0" cellpadding="1" bgcolor="#96CDCD">
		<tr>
			<td>订单编号</td>
			<td>购买人</td>
			<td>商品编号</td>
			<td>下单时间</td>
			<td>执行操作</td>
		</tr>
		
		<c:forEach items="${requestScope.orders}" var="g">
			<tr>
				<td>${g.ordersId}</td>
				<td>${g.users.userName }</td>
				<td>${g.goodsinformation.goodsId}</td>
				<td>${g.time }</td>
				<td><a id="delete" name="${g.ordersId }" href="${path}/orders/delete?id=${g.ordersId }">删除</a> 
					<a id="update" name="${g.ordersId }" href="${path}/orders/toUpdate?id=${g.ordersId }">修改</a>
				</td>
			</tr>
			
		</c:forEach>
	</table>
	</center>
</body>
</html>
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
	<h2 class="color:red">请输入库存商品名称或是商品id进行查询</h2>
	<form action="<%=request.getContextPath() %>/goods/find" method="post">
		商品名称：<input type="text" name="goodsName" value="${re.content.goodsName }"><br>
		商品id：<input type="text" name="goodsId" value="${re.content.goodsId }"><br>
		<c:if test="${re.state==1 }">
		库存数目：<input type="text" name="goodsNum" value="${re.content.goodsNum }"><br>
		</c:if>
		<c:if test="${re.state==0 }">
		  <span>${re.message }</span><br>
		</c:if>
		<input type="submit" value="查询">
	</form>
</center>
</body>
</html>
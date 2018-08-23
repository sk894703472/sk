<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/1.jpg');background-size: cover;">
<form action="<%=request.getContextPath() %>/orders/update" method="post">
		<input type="hidden" value="${order.ordersId }" name="ordersId">
		<input type="hidden" value="${order.goodsinformation.goodsId }" name="goodsinformation.goodsId">
		用户Id：<input type="text" name="users.id" value="${order.users.id }"><br>
		订购商品：<input type="text" name="goodsinformation.goodsName" value="${order.goodsinformation.goodsName }"><br>
		订单日期：<input type="text" name="time" value="${order.time }"><br>
		<input type="submit" name="" value="修改">
	</form>
</body>
</html>
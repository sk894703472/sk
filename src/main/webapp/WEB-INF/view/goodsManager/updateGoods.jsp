<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/1.jpg');background-size: cover;">

	<form action="<%=request.getContextPath() %>/goods/update" method="post">
		<input type="hidden" value="${good.goodsId }" name="goodsId">
		商品名称：<input type="text" name="goodsName" value="${good.goodsName }"><br>
		商品数量：<input type="text" name="goodsNum" value="${good.goodsNum }"><br>
		商品价格：<input type="text" name="goodsPrice" value="${good.goodsPrice }"><br>
		<input type="submit" name="" value="修改">
	</form>
</body>
</html>
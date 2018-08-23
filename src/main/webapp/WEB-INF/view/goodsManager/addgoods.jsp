<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/1.jpg');background-size: cover;">


<h2>添加商品</h2>&nbsp;&nbsp;<font color="red" size="3"><a href="<%=request.getContextPath() %>/goods/select">查看添加</a></font>
<font color="red">${result.message }</font>
	<form action="<%=request.getContextPath() %>/goods/add" method="post">
		<table>
			<tr>
				<td>商品Id</td><td><input type="text" name="goodsId"></td>
			</tr>
			<tr>
				<td>商品名</td><td><input type="text" name="goodsName"></td>
			</tr>
			<tr>
				<td>数量</td><td><input type="text" name="goodsNum"></td>
			</tr>
			<tr>
				<td>商品价格</td><td><input type="text" name="goodsPrice"></td>
			</tr>
			<tr>
				<td><input type="submit"" value="添加"></td>
			</tr>
		</table>
	</form>
</body>
</html>
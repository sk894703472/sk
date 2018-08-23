<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/1.jpg');background-size: cover;">


<h2>新增订单</h2>&nbsp;&nbsp;
<font color="red">${mess }</font>
	<form action="<%=request.getContextPath() %>/orders/add" method="post">
		<table>
			<tr>
				<td>商品编号</td><td><input type="text" name="goodsId"><font color="red">必填</font></td>
			</tr>
			<tr>
				<td>用户Id</td><td><input type="text" name="id"><font color="red">必填</font></td>
			</tr>
			<tr>
				<td><input type="submit"" value="添加"></td>
			</tr>
		</table>
	</form>
</body>
</html>
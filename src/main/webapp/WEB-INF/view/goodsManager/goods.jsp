<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Store2/static/jquery-1.12.4.min.js"></script>
</head>
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/1.jpg');background-size: cover;">

<%
	String path=request.getContextPath();
	request.setAttribute("path", path);
%>
<center>
	<h2>商品信息管理</h2><br>
	<table border="1" cellspacing="0" cellpadding="1" bgcolor="#96CDCD">
		<tr>
			<td>goodsId</td>
			<td>goodsName</td>
			<td>goodsNumber</td>
			<td>goodsPrice</td>
			<td>执行操作</td>
		</tr>
		
		<c:forEach items="${requestScope.goodsInfo}" var="g">
			<tr>
				<td>${g.goodsId}</td>
				<td>${g.goodsName }</td>
				<td>${g.goodsNum }</td>
				<td>${g.goodsPrice }</td>
				<td><a id="delete" name="${g.goodsId }" href="${path}/goods/delete?id=${g.goodsId }">删除</a> 
					<a id="update" name="${g.goodsId }" href="${path}/goods/toUpdate?id=${g.goodsId }">修改</a>
				</td>
			</tr>
			
		</c:forEach>
	</table>
	</center>
</body>
<script type="text/javascript">
	$(function(){
		var pass="${path}";
		//alert(pass);
		<!--$("#delete").click(function(){
			var id=$(this).attr("name");
			$.get(pass+"/goods/delete",{"id":id},function(data){
				alert("删除成功");
				location.reload();
				$.get(pass+"/goods/select");
			});
			
			return false;
		});-->
		
	})
</script>
</html>
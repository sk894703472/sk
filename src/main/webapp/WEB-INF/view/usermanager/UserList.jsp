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
	<h2>用户信息管理</h2>
</center>
	<a href="${path }/user/showfind"><font size="3">用户查询</font></a>
<center>
	<font color="red" size="3">${re }</font>
	<table border="1" cellspacing="0" cellpadding="1" bgcolor="#a4c2f4" width="500" height="50">
		<tr>
			<td>用户Id</td>
			<td>用户名</td>
			<td>年龄</td>
			<td>执行操作</td>
		</tr>
		
		<c:forEach items="${requestScope.users}" var="g">
			<tr>
				<td>${g.id}</td>
				<td>${g.userName }</td>
				<td>${g.age }</td>
				<td><a name="${g.id }" href="" class="delete">删除</a> 
					<a id="update" name="${g.id }" href="${path}/user/toUpdate?id=${g.id }">修改</a>
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
		$(".delete").click(function(){
			var id=$(this).attr("name");
			//alert(id);
			$.get(pass+"/user/delete",{"id":id},function(data){
					
				alert(data.message);
				//去列表页
				location.reload();
			$.get(pass+"/user/select",{},function(data){
			});
			});
			return false;
		});
		
		//修改操作
		//$("#update").click(function(){
			//var id=$(this).attr("name");
			//$.get(pass+"/goods/update",{"id":id},function(data){
				//if(data=="success"){
					//$.get(pass+"/WEB-INF/view/goodsManager/updateGoods.jsp");
				//}
			//})
		//});
	})
</script>
</html>
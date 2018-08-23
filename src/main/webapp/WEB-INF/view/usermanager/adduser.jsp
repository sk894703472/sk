<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Basic CRUD Application - jQuery EasyUI CRUD Demo</title>
    <link rel="stylesheet" type="text/css" href="css/skins/default.css" />
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <link rel="stylesheet" type="text/css" href="Store2/src/main/webapp/css/themes/default/easyui.css"> 
    <link rel="stylesheet" type="text/css" href="Store2/src/main/webapp/css/themes/icon.css">
    <script type="text/javascript" src="Store2/src/main/webapp/js/iframeTools.js"></script>
    <script type="text/javascript" src="Store2/src/main/webapp/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="Store2/src/main/webapp/js/datagrid-detailview.js"></script>  
    <script type="text/javascript" src="Store2/src/main/webapp/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="Store2/src/main/webapp/js/jquery.uploadify.min.js"></script>
    <script type="text/javascript">
		/* $(function(){
			$("body").after("<script type='text/javascript'>$(function(){$('body').show();});<\/script>");
			$("body").height($(window).height());
			$("body").width($(window).width());
			$(window).resize(function() {
				$("body").height($(window).height());
				$("body").width($(window).width());
				$('#dg').datagrid('resize');
			});
		}); */
	</script>
<title>Insert title here</title>
</head>
<body style="background-image: url('file:///E:/eclipse/workspace/Store2/src/main/webapp/img/1.jpg');background-size: cover;">

<h2>添加用户</h2>
&nbsp;&nbsp;<font color="red" size="3"><a href="<%=request.getContextPath() %>/user/select">查看添加</a></font>
<font color="red">${re}</font>
	<form action="<%=request.getContextPath() %>/user/add" method="post">
		<table>
			<tr>
				<td>用户名</td><td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>年龄</td><td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>密码</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit"" value="添加"></td>
			</tr>
		</table>
	</form>
</body>
</html>
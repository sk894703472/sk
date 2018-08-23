<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta charset="utf-8">
        <style type="text/css">
            .title{
                text-align: center;
                font-size: 30px;
                font-weight: 700;
            }
            .search{
            	margin: 10px;
            	text-align: right;
            }
            #insert{
            	text-align:center;
            }
            ::-webkit-input-placeholder{
            	text-align:center;
            }
            table input{
            	text-align:center;
            }
            table a,table .blue-btn{
            	display:block;
            	width:30px;
            	height:30px;
            	text-decoration:none;
            	color:#fff;
            	font-size:25px;
            	font-weight:500;
            	border:none;
            	text-align:center;
            	border-radius:50%;
            }
            table a{
            	background:#00B2EE no-repeat center center url(images/delete.png);
            	background-size:20px 20px;
            }
            table .blue-btn{
            	background:#00B2EE no-repeat center center url(images/btnEdit.png);
            	background-size:20px 20px;
            }
        </style>
    </head>
    <body>
        <h2 class="title">商品查询与修改</h2>
        <div class="search">
        <form action="/sk/ProductSearch" method="post"  style="text-align:center">
			<input type="text" name="searchvalue" placeholder="请输入搜索字段">
			<select name="protype">
				<option value="id">编号</option>
				<option value="name">名称</option>
				<option value="type">类型</option>
			</select>
			<input type="submit" value="搜索"/>
		</form>
        </div>
        <div class="content">
            <table border="2" cellpadding="10" cellspacing="0" bordercolor="#7FFFD4" align="center">
                <thead>
				<tr>
					<th>编码</th>
					<th>名称</th>
					<th>类型</th>
					<th>价格</th>
					<th>删除</th>
					<th>修改</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.result}" var="product" varStatus="id">
					<tr>
						<form action="/sk/ProductUpdate?idx=${id.index}" method="post">
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.type}</td>
						<td><input type="text" name="pro${id.index}" value="${product.price}"/></td>
						<td><a href="/sk/ProductDelete?idx=${id.index}"></a></td>
						<td><input type="submit" class="blue-btn" value=""/></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
            </table>
        </div>
        <div style="text-align:center;maigin-top:50px;color:red">${msg}</div>
    </body>
</html>
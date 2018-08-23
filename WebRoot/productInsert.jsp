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
        <h2 class="title">商品添加</h2>
        <div>
        <form action="/sk/ProductInsert" method="post" id="insert">
			<input type="text" name="proid" placeholder="编号"/>
			<input type="text" name="proname" placeholder="名称"/>
			<select name="protype" placeholder="品类">
				<option value="food">食物</option>
				<option value="tool">工具</option>
				<option value="fruit">水果</option>
			</select>
			<input type="text" name="proprice" placeholder="价格"/>
			<input type="submit" value="添加"/>
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
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.result}" var="product" varStatus="id">
					<tr>
						<form action="/sk/ProductUpdate?idx=${id.index}" method="post">
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.type}</td>
						<td>${product.price}</td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
            </table>
        </div>
        <div style="text-align:center;maigin-top:50px;color:red">${msg}</div>
    </body>
</html>
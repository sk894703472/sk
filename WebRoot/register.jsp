<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta charset="utf-8">

        <style type="text/css">
            .title{
                 text-align: center;
                font-size: 30px;
                font-weight: 700;
            }
            .content{
            	width:300px;
            	height:350px;
            	position:absolute;
            	top:0;
            	bottom:0;
            	left:0;
            	right:0;
            	margin:auto;
            	border-radius:10px;
            	border:2px solid #7FFFD4;
            	background:#fff;
            }
            input{
            	margin-top:20px;
            }
            body{
            	background:linear-gradient(to right bottom,red,#fff);
            }
        </style>
    </head>
    <body>
    <div class="content">
        <h2 class="title">用户注册</h2>
        <form action="/sk/UserRegister" method="post">
            <table align="center">
                <tr>
                    <td colspan="2"><input type="hidden" name="flag" value="register"/></td>
                </tr>
                <tr>
                    <td>用户名:</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input type="password" name="userpsd"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="注册"/></td>
                    <td><input type="reset" value="重置"/></td>
                </tr>
            </table>
        </form>
    </div>
    </body>
</html>
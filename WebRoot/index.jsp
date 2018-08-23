<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="Head1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery-EasyUI 1.1 应用实例</title>
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.js"></script>
	<script type="text/javascript" src='js/outlook2.js'> </script>
    <script type="text/javascript">
	 var _menus = {"menus":[
						{"menuid":"1","icon":"icon-sys","menuname":"用户管理",
							"menus":[{"menuid":"11","menuname":"信息修改","icon":"icon-nav","url":"/sk/UserQuery"},
							         {"menuid":"11","menuname":"用户信息","icon":"icon-nav","url":"/sk/UserQuery2"}
								]
						},{"menuid":"8","icon":"icon-sys","menuname":"商品管理",
							"menus":[{"menuid":"21","menuname":"商品修改与查询","icon":"icon-nav","url":"/sk/ProductQuery?p=query"},
									{"menuid":"22","menuname":"商品插入","icon":"icon-nav","url":"/sk/ProductQuery?p=insert"}
							
								]
						},{"menuid":"56","icon":"icon-sys","menuname":"库存管理",
							"menus":[{"menuid":"31","menuname":"库存修改与查询","icon":"icon-nav","url":"/sk/InventoryQuery?p=query"},
									 {"menuid":"32","menuname":"库存插入","icon":"icon-nav","url":"/sk/InventoryQuery?p=insert"}
								]
						}
				]};
    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div></noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">欢迎${success}访问${fail} <a href="login.jsp">登录</a>/<a href="/sk/UserExit">退出</a> <a href="register.jsp">注册</a></span>
        <span style="padding-left:10px; font-size: 16px; "><img src="images/blocks.gif" width="20" height="20" align="absmiddle" />电子商务管理系统</span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">By 孙凯 </div>
    </div>
    <div region="west" split="true" title="导航菜单" style="width:180px;" id="west">
		<div class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->	
		</div>
    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;overflow:hidden;" id="home">
				
			<h1>欢迎访问 ${success}电子商务系统!</h1>

			</div>
		</div>
    </div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>


</body>
</html>
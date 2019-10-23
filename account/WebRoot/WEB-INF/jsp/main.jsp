<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-2.1.1.js"></script>
	<style type="text/css">
	#cd,#show{
	float: left;
	}
	#kc div h2,form{
	display: inline-block;
	margin-left: 20px;
	}
	#kc div form{
	margin-left: 150px
	}
	table {
		border-collapse: collapse;	
	}
	</style>
  </head>
  
  <body>
    <p>卡号:${No}&nbsp;&nbsp;<a style="color: DarkMagenta;text-decoration: underline;" onclick="tui()">退出登录</a></p>
    <div id="cd" style=" height: 300px; width: 150px">
    <p><a  href="${pageContext.request.contextPath }/acco/findBalance" target="mainFrame" style="color: DarkMagenta;">查询余额</a></p>
    <p><a  href="${pageContext.request.contextPath }/acco/lookTransfer" target="mainFrame" style="color: DarkMagenta;">转账</a></p>
    <p><a  href="${pageContext.request.contextPath }/acco/lookfind" target="mainFrame" style="color: DarkMagenta;">查询效果记录</a></p>
    <p><a  href="${pageContext.request.contextPath }/acco/lookpass" target="mainFrame" style="color: DarkMagenta;">修改密码</a></p>
    </div>
    <iframe name="mainFrame" style="border: 1px solid blue;width: 700px;height: 300px" src="${pageContext.request.contextPath }/acco/lookTilet">
    </iframe>
  </body>
  <script type="text/javascript">
  function tui(){
	  var bool=confirm("确定要退出吗");
	  if(bool){
	  	location.href="${pageContext.request.contextPath }/acco/eixtAccount";
	  };
  }
		$(function(){  
				$("tbody th").css("background-color","LightCyan");    
		        $("tbody tr:odd").css("background-color","White");
		        $("tbody tr:even").css("background-color","PaleGreen");  
		}) ;
  </script>
  </body>
</html>

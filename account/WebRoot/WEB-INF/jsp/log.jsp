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
    
    <title>My JSP 'log.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-2.1.1.js"></script>
<style type="text/css">
	html, body {
            width: 100%;
            height: 100%;
            margin: 0; 
            padding: 0;
        }
	
	div{
		border: 1px solid;
		width: 500px;
		/* height: 100px; */
		margin: 0 auto;
		background: PaleGreen;
		position: relative; /*设置position属性*/
		top: 50%; /*偏移*/
		margin-top: -150px;
	}
	h1{
	text-align: center;
	}
	</style>
  </head>
  
  <body>
   <div>
    	<h1>个人网上银行</h1>
    	<form action="${pageContext.request.contextPath }/acco/findProjectinfolist" method="post">
    	<p style="text-align: center;">卡号:<input type="text"  name="cardNo" id="cardNo"></p>
    	<p style="text-align: center;">密码:<input type="password" name="password" id="password"></p>
    	<p style="text-align: center;"><input type="submit"  value="登录网上银行"></p>
    	</form>
    </div>
    <input type="hidden" id="err" value="${error}">
    <script type="text/javascript">
     $("document").ready(function(){
     	var err=$("#err").val();
     	if(err!=""){
     		alert(err);
     	}
   		$("form").submit(function(e){
  			var cardNo=$("#cardNo").val();
  			var password=$("#password").val();
  			if(cardNo.length!=16){
  			alert("请正确填写您的16卡号");
  			return false;
  			}
  			if(password.length!=6){
  			alert("请正确填写6位登录密码");
  			return false;
  			}
  			return true;
		});
	 });
	</script>
  </body>
</html>

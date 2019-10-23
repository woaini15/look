<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-2.1.1.js"></script>

  </head>
  
  <body>
    <h3 style="text-align: center; margin-top: 80px">当前操作：修改密码，请按要求填写完整后点“修改”按钮</h3>
		<div style="text-align: center;">
			<form action="${pageContext.request.contextPath }/acco/updatpwass" method="post">
		    	<p style="text-align: center;">请输入现在密码:&nbsp;&nbsp;<input type="password"  name="password" id="password"></p>
		    	<p style="text-align: center;">请输入新密码:&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password1"  id="password1"></p>
		    	<p style="text-align: center;">请再次输入新密码:<input type="password" name="password2"  id="password2"></p>
		    	<p style="text-align: center;"><input type="submit"  value="修改"></p>
	    	</form>
		</div>
		<input type="hidden" id="err" value="${errors}">
		<input type="hidden" id="errs" value="${errs}">
		<script type="text/javascript">
     $("document").ready(function(){
	     var err=$("#err").val();
	     var errs=$("#errs").val();
	     	if(err!=""){
	     		alert(err);
	     	}
	     	if(errs!=""){
	     		alert(errs);
	     		window.location.href = "${pageContext.request.contextPath }/acco/lookTilet";
	     	}
   		$("form").submit(function(e){
  			var password=$("#password").val();
  			var password1=$("#password1").val();
  			var password2=$("#password2").val();
  			if(password==""||password1==""||password2==""){
  			alert("请将表单填写完整");
  			return false;
  			}
  			if(password.length!=6||password1.length!=6||password2.length!=6){
  			alert("密码只能是6们数字 ");
  			return false;
  			}
  			if(password1!=password2){
  			alert("两次输入的新密码不想同");
  			return false;
  			}
		});
	 });
	</script>
  </body>
</html>

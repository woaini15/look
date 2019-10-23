<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'transfer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-2.1.1.js"></script>

  </head>
  
  <body>
   <h3 style="text-align: center; margin-top: 80px">当前操作：转账，请输入帐号和金额后点“转账”按钮</h3>
		<div style="text-align: center;">
			<form action="${pageContext.request.contextPath }/acco/updatBalance" method="post">
		    	<p style="text-align: center;">转入账号:<input type="text"  name="cardNo2" id="cardNo2"></p>
		    	<p style="text-align: center;">转账金额:<input type="text" name="money"  id="money"></p>
		    	<p style="text-align: center;"><input type="submit"  value="转账"></p>
	    	</form>
		</div>
		<input type="hidden" id="err" value="${errorer}">
		<script type="text/javascript">
     $("document").ready(function(){
	     var err=$("#err").val();
	     	if(err!=""){
	     		alert(err);
	     	}
   		$("form").submit(function(e){
  			var cardNo=$("#cardNo2").val();
  			var money=$("#money").val();
  			if(cardNo.length!=16){
  			alert("请正确填写您的16卡号");
  			return false;
  			}
  			if(!(/^\+?(\d*\.\d{2})$/.test(money))){
  			alert("请正确填写转账金额");
  			return false;
  			}
  			return true;
		});
	 });
	</script>
  </body>
</html>

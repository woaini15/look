<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'find.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-2.1.1.js"></script>
	<style type="text/css">
			
			div{
				width: 550px;
				margin: 20px auto;
			}
			td{font-size:20px}
				table tr:nth-child(odd){background:#F4F4F4;}
			table{margin-left: 60px}
			
		</style>
  </head>
  
  <body>
    <div>
  <h3 style="text-align:center">当前操作，查询交易记录，请选择时间范围后点“查询”按钮</h3>
  	<form action="${pageContext.request.contextPath }/acco/findTransalist" method="post">
  		查询日期范围：<input type="text" name="transactionDate1" id="transactionDate1" value="${transactionDate1}">到
  		<input type="text" name="transactionDate2" id="transactionDate2" value="${transactionDate2}">
  		<input type="submit" value="查询">
  	</form>
  	<c:if test="${finds!=null}">
    <table border="1px">
   <tr>
   <th >交易日期</th>
    <th >交易额</th>
     <th >账户余额</th>
      <th >交易类型</th>
      <th >备注</th>
   </tr>
   <c:forEach items="${list}" var="list">
   <tr>
      <td ><fmt:formatDate value="${list.transactionDate}" pattern="yyyy-MM-dd hh:mm" /></td>
      <td >${list.transactionAmount}</td>
      <td >${list.balance}</td>
      <td >${list.transactionType}</td>
      <td >${list.remark}</td>
   </tr>
   </c:forEach>
   </table>
   <p align="center">
	<%
	//page2总页数
	String page2=request.getAttribute("page2").toString();
	//pageNo当前页码
	String pageNo=request.getAttribute("pageNo").toString();
	if(pageNo==null || pageNo.equals("")){
		pageNo="1";
	}
	int pageNo2=Integer.parseInt(pageNo);
	 %>
	当前页数：[<%=pageNo2 %>/<%=page2 %>]&nbsp;
	<a href="${pageContext.request.contextPath}/acco/findTransalist?pageNo=1">首页</a> 
	 
	<a href="${pageContext.request.contextPath}/acco/findTransalist?pageNo=<%=pageNo2-1%>">上一页</a> 
	<%
		if(pageNo2==Integer.parseInt(page2)){
		pageNo2=Integer.parseInt(page2);
	 %>
	 	<a href="${pageContext.request.contextPath}/acco/findTransalist?&pageNo=<%=pageNo2%>">下一页</a>
	 <%
	   }else {
	   %>
	   <a href="${pageContext.request.contextPath}/acco/findTransalist?pageNo=<%=pageNo2+1%>">下一页</a> 
	   <%
	   		
	   }
	  %> 
   
	<a href="${pageContext.request.contextPath}/acco/findTransalist?pageNo=<%=page2%>">末页</a> 
  	</p>
  	 </c:if>
  	 <c:if test="${find!=null}">
  		 <h3  style="text-align: center; margin-top: 80px">此时间范围内没有交易记录</h3>
  	 </c:if>
   </div>
   <script type="text/javascript">
   $("document").ready(function(){
		 $("form").submit(function(){
		 var transactionDate1=$("#transactionDate1").val();
		 var transactionDate2=$("#transactionDate2").val();
		 var date = /^[0-9]{4}-[0-1]?[0-9]{1}-[0-3]?[0-9]{1}$/;
		 if(!(date.test(transactionDate1)&&date.test(transactionDate2))){
		  alert("请正确填写起止日期");
		  return false;
		 }
		 });
		 $("a").click(function(){
			var transactionDate1=$("#transactionDate1").val();
			var transactionDate2=$("#transactionDate2").val();
		 	var aa=$(this).attr('href');
		 	aa=aa+"&transactionDate1="+transactionDate1+"&transactionDate2="+transactionDate2;
		 	$(this).attr("href",aa); 
		 });
	 });
   $(function(){  
				$("tbody th").css("background-color","LightCyan");    
		        $("tbody tr:odd").css("background-color","White");
		        $("tbody tr:even").css("background-color","PaleGreen");  
		}) ;
		  </script>
  </body>
</html>

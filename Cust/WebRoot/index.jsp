<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <h1>客户管理系统</h1>
  <a href="${pageContext.request.contextPath}/addCust.jsp">添加客户</a>
  <a href="${pageContext.request.contextPath}/servlet/ListServlet">查询所有用户</a>
  <a href="${pageContext.request.contextPath}/servlet/PageServlet?thispage=1">分页查询用户</a>
  </body>
</html>

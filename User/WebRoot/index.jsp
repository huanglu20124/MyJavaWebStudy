<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  </head>
  
  <body>
  <h3>我的网站</h3><hr>
  <c:if test="${sessionScope.user != null}">
       欢迎回来 ${sessionScope.user.username}! <a href="${pageContext.request.contextPath}/servlet/LogoutServlet">注销</a>
  </c:if>
  <c:if test="${sessionScope.user == null}">
    欢迎光临游客<br>
    <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
    <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
  </c:if>
  </body>
</html>

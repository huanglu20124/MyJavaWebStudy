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
    <h1>登录界面</h1>
    <font>${msg }</font>
    <form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="POST">
        <table>
           <tr>
               <td>用户名</td>
               <td><input type="text" name="username"></td>
           </tr>
           
           <tr>
                <td>密码</td>
               <td><input type="password" name="password"></td>
           </tr>
           
           <tr>
               <td>
                  <input type="submit" value="登录">
               </td>
               <td><input type="checkbox" value = "ok" name="rename">记住用户名密码</td>
           </tr> 
            
        </table>
    </form>
  </body>
</html>

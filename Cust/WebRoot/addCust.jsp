<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body style="text-align: center;">
  <h1 style="text-align: left">添加客户</h1>
  <form action="${pageContext.request.contextPath}/servlet/AddServlet" method="POST">
      <table border="1">
         <tr>
            <td>客戶姓名</td>
            <td><input type="text" name="name"></td>
         </tr>
         
         <tr>
            <td>客戶性別</td>
            <td>
                <input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女">女
            </td>
         </tr>
                
         <tr>
            <td>出生日期</td>
            <td><input type="text" name="birthday"></td>
         </tr>
         
         <tr>
            <td>电话号码</td>
            <td><input type="text" name="cellphone"></td>
         </tr>
         
         <tr>
            <td>客户爱好</td>
            <td>
                <input type="checkbox" name="preference" value="篮球">篮球
                <input type="checkbox" name="preference" value="乒乓球">乒乓球
                <input type="checkbox" name="preference" value="足球">足球
                <input type="checkbox" name="preference" value="羽毛球">羽毛球
            </td>
         </tr>
         
         <tr>
            <td>客户类型</td>
            <td>
                <select name="cus_type">
                   <option value="钻石客户">钻石客户</option>
                   <option value="黄金客户">黄金客户</option>
                   <option value="白银客户">白银客户</option>
                </select>
            </td>
         </tr>
         
          <tr>
            <td>电子邮箱</td>
            <td><input type="text" name="email"></input></td>
         </tr>
         
         
         <tr>
            <td>描述信息</td>
            <td><textarea name="description"></textarea></td>
         </tr>
         
         <tr >
            <td><input type="submit" value="添加客户"/></td>
         </tr>
         
      </table>
  </form>
  </body>
  
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <%//来自请求域的变量直接用 %>
  <body style="text-align: center;">
  <h1 style="text-align: left">修改客户</h1>
  <form action="${pageContext.request.contextPath}/servlet/UpdateServlet" method="POST">
    <input type="hidden" name="id" value="${cust.id}">
      <table border="1">
         <tr>
            <td>客戶姓名</td>
            <td><input type="text" name="name" 
            readonly="readonly" value="${cust.name}"></td>
         </tr>
         
         <tr>
            <td>客戶性別</td>
            <td>
                <input type="radio" name="gender" value="男"
                    <c:if test="${cust.gender=='男'}">checked='checked'</c:if>
                />男
                <input type="radio" name="gender" value="女"
                    <c:if test="${cust.gender=='女'}">checked='checked'</c:if>
                />女
            </td>
         </tr>
                
         <tr>
            <td>出生日期</td>
            <td><input type="text" name="birthday" value="${cust.birthday}"></td>
         </tr>
         
         <tr>
            <td>电话号码</td>
            <td><input type="text" name="cellphone" value="${cust.cellphone}"></td>
         </tr>
         
         <tr>
            <td>客户爱好</td>
         						
            <td>
                <input type="checkbox" name="preference" value="篮球"
                  		<c:forTokens items="${cust.preference}" delims="," var="pref">
							<c:if test="${pref == '篮球' }">
								checked='checked'
							</c:if>
						</c:forTokens>
                />篮球
                <input type="checkbox" name="preference" value="乒乓球"
                  		<c:forTokens items="${cust.preference}" delims="," var="pref">
							<c:if test="${pref == '乒乓球' }">
								checked='checked'
							</c:if>
						</c:forTokens>
                />乒乓球
                <input type="checkbox" name="preference" value="足球"
                  		<c:forTokens items="${cust.preference}" delims="," var="pref">
							<c:if test="${pref == '足球' }">
								checked='checked'
							</c:if>
						</c:forTokens>
                />足球
                <input type="checkbox" name="preference" value="羽毛球"
                  		<c:forTokens items="${cust.preference}" delims="," var="pref">
							<c:if test="${pref == '羽毛球' }">
								checked='checked'
							</c:if>
						</c:forTokens>
                />羽毛球
            </td>
         </tr>
         
         <tr>
            <td>客户类型</td>
            <td>
                <select name="cus_type">
                   <option value="钻石客户"
                        <c:if test="${cust.cus_type=='钻石客户'}">selected='selected'</c:if>
                   >钻石客户</option>
                   <option value="黄金客户"
                        <c:if test="${cust.cus_type=='黄金客户'}">selected='selected'</c:if>
                   >黄金客户</option>
                   <option value="白银客户"
                        <c:if test="${cust.cus_type=='白银客户'}">selected='selected'</c:if>
                   >白银客户</option>
                </select>
            </td>
         </tr>
         
          <tr>
            <td>电子邮箱</td>
            <td><input type="text" name="email" value="${cust.email}"></input></td>
         </tr>
         
         
         <tr>
            <td>描述信息</td>
            <td><textarea name="description">${cust.description}</textarea></td>
         </tr>
         
         <tr >
            <td><input type="submit" value="修改客户"/></td>
         </tr>
         
      </table>
  </form>
  </body>
  
</html>

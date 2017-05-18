<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript">
       function checkAll(allC){
           var checks =  document.getElementsByName("delId");
           for(var i = 0; i < checks.length; i++){
                 checks[i].checked = allC.checked;
           }
       }
    </script>
  </head>
  <body style="text-align: center;">
  	<h1>客户列表页面</h1><hr>
  	<%//请求参数用param直接获得 %>
  	<form action="${pageContext.request.contextPath}/servlet/QueryOneServlet" method="POST">
  	客户姓名：<input type="text" name="name" value="${param.name}">
  	客户性别：  <input type="radio" name="gender" value="男"
  						<c:if test="${param.gender=='男' }">checked='checked'</c:if>
  					/>男
  					<input type="radio" name="gender" value="女"
  						<c:if test="${param.gender=='女' }">checked='checked'</c:if>
  					/>女
  					<input type="radio" name="gender" value=""/>无
  	客户类型：<select name="cus_type">
  						<option value=""
						<c:if test="${param.cus_type=='' }">
							 selected="selected"
						</c:if>
					></option>
					<option value="钻石客户"
						<c:if test="${param.cus_type=='钻石客户' }">
							 selected="selected"
						</c:if>
					>钻石客户</option>
					<option value="黄金客户"
						<c:if test="${param.cus_type=='黄金客户' }">
							 selected="selected"
						</c:if>
					>黄金客户</option>
					<option value="白银客户"
						<c:if test="${param.cus_type=='白银客户' }">
							 selected="selected"
						</c:if>
					>白银客户</option>
  	          </select>
  	<input type="submit" value="按条件查询">
  	</form>
  	<form action="${pageContext.request.contextPath}/servlet/BatchDelServlet" method="POST">
  	<table border="1" width="100%">
  		<tr>
  			<th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
  			<th>客户姓名</th>
  			<th>客户性别</th>
  			<th>出生日期</th>
  			<th>手机号码</th>
  			<th>电子邮箱</th>
  			<th>客户爱好</th>
  			<th>客户类型</th>
  			<th>描述信息</th>
  			<th>修改</th>
  			<th>删除</th>
  		</tr>
  		<c:forEach items="${requestScope.list}" var="cust">
	  		<tr>
	  			<td><input type="checkbox" name="delId" value="${cust.id }" /></td>
	  			<td><c:out value="${cust.name }"/></td>
	  			<td><c:out value="${cust.gender }"/></td>
	  			<td><c:out value="${cust.birthday }"/></td>
	  			<td><c:out value="${cust.cellphone }"/></td>
	  			<td><c:out value="${cust.email }"/></td>
	  			<td><c:out value="${cust.preference }"/></td>
	  			<td><c:out value="${cust.cus_type}"/></td>
	  			<td><c:out value="${cust.description }"/></td>
	  			<td><a href="${pageContext.request.contextPath }/servlet/InfoServlet?id=${cust.id }">修改</a></td>
	  			<td><a href="${pageContext.request.contextPath}/servlet/DelServlet?id=${cust.id}">删除</a></td>
	  		</tr>
  		</c:forEach>
  	</table>
  	<input type="submit" value="批量删除"/>
  	</form>
  </body>
</html>

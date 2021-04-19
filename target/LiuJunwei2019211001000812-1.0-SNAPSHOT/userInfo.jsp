<%--
  Created by IntelliJ IDEA.
  User: 22637
  Date: 2021/4/12
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/views/header.jsp"%>
<h1>User Info</h1>
<table>
    <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>Email:</td><td><%=request.getAttribute("email")%></td></tr>
    <tr><td>Sex:</td><td><%=request.getAttribute("sex")%></td></tr>
    <tr><td>BirthDate:</td><td><%=request.getAttribute("birth")%></td></tr>
</table>
<%@include file="WEB-INF/views/footer.jsp"%>
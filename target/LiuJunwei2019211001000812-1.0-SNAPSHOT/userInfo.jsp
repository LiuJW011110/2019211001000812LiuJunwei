<%--
  Created by IntelliJ IDEA.
  User: 22637
  Date: 2021/4/12
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.LiuJunwei.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    User user = (User)session.getAttribute("user");
%>
<h1>User Info</h1>

<table border="1">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birth Date</th>
    </tr>
    <tr>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getSex()%></td>
        <td><%=user.getBirth()%></td>
    </tr>

</table>
<a href="updateUser">Update User</a>
<%@include file="footer.jsp"%>-INF/views/footer.jsp"%>
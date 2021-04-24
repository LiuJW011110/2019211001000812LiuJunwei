<%@ page import="com.LiuJunwei.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 22637
  Date: 2021/4/24
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<%
    User u= (User) session.getAttribute("user");
%>

<form  id="updateUserForm" method="post" action="updateUser">

    <legend>Update Info</legend>

    <input type="hidden" name="id" value="<%=u.getId()%>">
    <label for="username">username</label>
    <input id="username" name="username" type="text" value="<%=u.getUsername()%>">

    <label>gender</label>
    <input id="gender_m" name="gender" value="boy" type="radio" <%="boy".equals(u.getSex())?"checked":""%>>boy
    <input id="gender_f" name="gender" value="girl" type="radio" <%="girl".equals(u.getSex())?"checked":""%>>girl

    <label for="password">password</label>
    <input id="password" name="password" type="password" value="<%=u.getPassword()%>">

    <label for="email">Email</label>
    <input id="email" name="email" type="email" value="<%=u.getEmail()%>">

    <label for="birthday">Birthday</label>
    <input id="birthday" name="birthday" type="text" value="<%=u.getBirth()%>">

    <input class="submit" type="submit" value="Save Changes">
</form>


<%@include file="footer.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: 22637
  Date: 2021/4/5
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h2>Welcome to my home page</h2>
<%@include file="header.jsp"%>
<body>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
</form>
<a href="hello">code1<br></a>
<a href="week2/register.jsp">code2<br></a>
<a href="MyJsp.jsp">code3<br></a>
<a href="login.jsp">login<br></a>
</body>
</html>
<%@include file="footer.jsp"%>
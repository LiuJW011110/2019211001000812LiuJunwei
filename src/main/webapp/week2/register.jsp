<%--
  Created by IntelliJ IDEA.
  User: LiuJunwei
  Date: 2021/3/13
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/header.jsp"%>
    <form method="post" action="register">
        Username:<input type="text" name="username"><br/>
        Password:<input name="password" type="password"><br/>
        E-mail:<input name="email" type="email"><br/>
        Gender:<input name="sex" type="radio" value="male">mal
               <input type="radio" name="sex" value="female">female<br/>
        Birth:<input type="text" name="birth"><br/>
        <input type="submit" value="Register">
    </form>
<%@include file="/footer.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2023/4/29
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="modifypwd" method="post">
    用户名：<input type="text" name="userName"/></br>
    旧密码：<input type="password" name="oldpwd"/></br>
    新密码：<input type="password" name="newpwd"/></br>
<input type="submit" text="更改"/>
<input type="reset" text="重置"/>
</form>
</body>
</html>

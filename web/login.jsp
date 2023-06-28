<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2023/4/28
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
    <style type="text/css">
        body div{
          position: fixed;
          width: 300px;
          height: 150px;
          border: 1px solid grey;
          background-color: yellowgreen;
          padding: 5px;
          margin: auto;
          left: 0;
          right: 0;
          top: 0;
          bottom: 0;
        }

        div h2{
          text-align: center;
          font-size: 20px;
        }

    </style>
  </head>
  <body>
  <div>
    <h2>登录</h2>
    <form action="check" method="post">
        用户名：<input type="text" name="userName"/></br>
      密&nbsp&nbsp&nbsp码：<input type="password" name="password"/></br>
        <input type="submit" text="登录"/>
        <input type="reset" text="重置"/>
        <a href="modifyPassword.jsp">修改密码</a>

    </form>
  </div>
  </body>
</html>

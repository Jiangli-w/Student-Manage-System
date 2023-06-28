<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2023/5/14
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
    <style type="text/css">
        #father{
            position: fixed;

            /*margin-top:30px;*/
            /*margin-left:30px;*/
            margin: 5% 10% 5% 5%;
            border:1px solid silver;
            background-color: lightskyblue;
        }
        #father div{
            margin: 50px 10px 50px 10px;
            background-color:white;
            color:black;
            border:1px solid white;
        }
        #show{
            position:absolute;

            margin:20px;
            top:25%;
            left:25%;
            border:1px solid silver;
        }
        #search{
            width: 300px;
            margin: 0 auto;
        }
        table,tr, th, td{
            border:1px solid silver;
        }

        #insert_show{
            position:absolute;

            margin:20px;
            top:25%;
            left:25%;
            border:1px solid silver;
        }
    </style>
    <%--  <script type="text/javascript">--%>

    <%--  </script>--%>
</head>
<body>
<div id="father">
    <div id="userInfo">
        <span>用户管理</span>
    </div>
    <div id="studentInfo">
        <span>学生信息管理</span>
    </div>
    <div id="classInfo">
        <span>班级信息管理</span>
    </div>
    <div id="courseInfo">
        <span>课程信息管理</span>
    </div>
    <div id="courseTableInfo">
        <span>课程表信息管理</span>
    </div>
    <div id="scoreInfo">
        <span>成绩信息管理</span>
    </div>
    <div id="teacherInfo">
        <span>教师信息管理</span>
    </div>
</div>
<div style="width: 300px;margin: 0 auto;">
    <input id="mod" type="button" style="width: 100%;" value="查找信息"/>
</div>

<%--搜索框--%>
<div id="search" style="display: none">
    <select></select><input id='text' type="text" /><input type="button" onclick="onSearchBtn()" value="搜索" />
</div>

<%--  显示信息--%>
<div id="show">

</div>
<div id="insert_show" style="display: none;">

</div>
<script type="text/javascript" src="administrator_js.js"></script>
</body>
</html>

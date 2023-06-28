<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2023/4/29
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生</title>
  <style type="text/css">
    #father{
        position: fixed;

        margin-top:30px;
        margin-left:30px;
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
    table,tr, th, td{
      border:1px solid silver;
    }
  </style>
<%--  <script type="text/javascript">--%>

<%--  </script>--%>
</head>
<body>
  <div id="father">
    <div id="personInfo">
     <span>个人信息</span>
    </div>
    <div id="classInfo">
      <span>班级信息</span>
    </div>
    <div id="courseInfo">
      <span>课程信息</span>
    </div>
    <div id="ctInfo">
      <span>课程表信息</span>
    </div>
    <div id="scoreInfo">
      <span>成绩信息</span>
    </div>

  </div>

<%--  显示信息--%>
  <div id="show">

  </div>
  <script type="text/javascript" src="student_js.js"></script>
</body>
</html>

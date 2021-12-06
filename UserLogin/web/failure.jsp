<%--
  Created by IntelliJ IDEA.
  User: 49636
  Date: 2021/11/22
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failure</title>
    <link rel="stylesheet" type="text/css" href="success.css"/>
</head>
<body>
    <div id="login-box">
        <h1>登录失败啦</h1>
        <div class="input-box">
            <h3>${messageModel.msg}</h3>
        </div>
        <button><a href="login.jsp">重新登录叭</a></button>
    </div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 49636
  Date: 2021/11/22
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="login.css"/>
</head>
<body>
    <div id="login-box">
        <%-- 通过表单提交登录数据到loginServlet --%>
        <form action="registerServlet" method="post">
            <h1>Register</h1>
            <div class="input-box">
                账号名  ：<input type="text" name="uname">
            </div>
            <div class="input-box">
                密码    ：<input type="password" name="upwd">
            </div>
            <div class="input-box">
                确认密码：<input type="password" name="upwd_confirm">
            </div>
            <button>注册</button>
            <div class="tips">
                <h3><a href="login.jsp">已经有账号啦？去登录叭</a></h3>
            </div>
            <h3>${requestScope.messageModel}</h3>
        </form>
    </div>


</body>
</html>

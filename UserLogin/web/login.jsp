<%--
  Created by IntelliJ IDEA.
  User: 49636
  Date: 2021/11/22
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%-- 关联login.css --%>
    <link rel="stylesheet" type="text/css" href="login.css"/>
</head>
<body>
    <div id="login-box">
        <%-- 当注册成功时显示注册成功信息 --%>
        <h3>${requestScope.regSuccess} <br></h3>
        <%-- 通过表单提交登录数据到loginServlet --%>
        <form action="loginServlet" method="post">
            <h1>Login</h1>
            <div class="input-box">
                账号名：<input type="text" name="uname">
            </div>
            <div class="input-box">
                密码  ：<input type="password" name="upwd">
            </div>
            <button>登录</button>
            <div class="tips">
                <h3><a href="register.jsp">还没有账号？来注册叭</a></h3>
            </div>
        </form>
    </div>


</body>
</html>

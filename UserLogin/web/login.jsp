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
</head>
<body>
    <%-- 当注册成功时显示注册成功信息 --%>
    ${requestScope.regSuccess} <br>
    <%-- 通过表单提交登录数据到loginServlet --%>
    <form action="loginServlet" method="post">
        账号名：<input type="text" name="uname"> <br>
        密码  ：<input type="password" name="upwd"> <br>
        <button>登录</button>
<%--        &lt;%&ndash; 获取后台LoginServlet在request作用域中设置的数据，用于提示用户登录错误信息 &ndash;%&gt;--%>
<%--        <span style="color: red; font-size: 12px"><%=request.getAttribute("msg")%></span>--%>

    </form>

    <a href="register.jsp">还没有账号？来注册叭</a>
</body>
</html>

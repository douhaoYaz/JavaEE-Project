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
</head>
<body>
    <%-- 通过表单提交登录数据到loginServlet --%>
    <form action="registerServlet" method="post">
        账号名  ：<input type="text" name="uname"> <br>
        密码    ：<input type="password" name="upwd"> <br>
        确认密码：<input type="password" name="upwd_confirm"> <br>
        <button>注册</button>
        <%-- 获取后台RegisterServlet在request作用域中设置的数据，用于提示用户注册错误信息 --%>
<%--        <span style="color: red; font-size: 12px"><%=request.getAttribute("messageModel")%></span>--%>
        ${requestScope.messageModel}
    </form>

    <a href="login.jsp">已经有账号啦？去登录叭</a>
</body>
</html>

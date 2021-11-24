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
    <%-- 通过表单提交登录数据到loginServlet --%>
    <form action="loginServlet" method="post">
        姓名：<input type="text" name="uname"> <br>
        密码：<input type="password" name="upwd"> <br>
        <button>登录</button>
        <%-- 获取后台LoginServlet在request作用域中设置的数据，用于提示用户登录错误信息 --%>
        <span style="color: red; font-size: 12px"><%=request.getAttribute("msg")%></span>
        <%-- TODO 可将上面的span换成EL表达式 --%>
    </form>

    <%-- TODO 跳转到注册页面register.jsp --%>

</body>
</html>

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
    <title>Success</title>
    <link rel="stylesheet" type="text/css" href="success.css"/>
</head>
<body>
    <div id="login-box">
            <h1>Success!</h1>
            <div class="input-box">
                <h3>啊是${messageModel.getObject().userName}啊！</h3>
            </div>
        <button>${messageModel.msg}</button>
    </div>
</body>
</html>

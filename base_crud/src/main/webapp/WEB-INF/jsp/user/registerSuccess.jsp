<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/11 0011
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Success</title>
    <%-- 实现页面定时刷新,单位 second --%>
    <meta http-equiv="refresh"
          content="1; url=<%=request.getContextPath()%>/user"/>

</head>
<body>
<div align="center" style="margin-top: 100px">
    <h1>Register Success! Congratulations!</h1>
    <h4>This page will turn to login page in 1s...</h4>
</div>

</body>
</html>

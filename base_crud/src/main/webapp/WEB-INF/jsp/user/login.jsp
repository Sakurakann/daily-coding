<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/9 0009
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
</head>
<body>
<div align="center" style="margin-top: 100px">
    <form action="user?cmd=login" method="post" id="login-form">
        <table>
            <thead>
            <tr>
                <td colspan="2" align="center">User login</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td align="right">UserName:</td>
                <td><input placeholder="Please key in username"
                           name="username" id="username"/></td>
                <td><label for="username" id="username-label"></label></td>
            </tr>
            <tr>
                <td align="right">Password:</td>
                <td><input type="password" placeholder="Please key in password"
                           name="password" id="password"/></td>
                <td><label for="password" id="password-label"></label></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <button type="button" onclick="goRegister()">Sign Up
                    </button>
                    <button type="button" onclick="loginCheck()">Sign In
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
<script type="text/javascript">
  function goRegister() {
    window.location.href = "<%=request.getContextPath()%>/user?cmd=registerPre";
  }

  function loginCheck() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    //alert(username + " : " + password);
    var usernameLabel = document.getElementById("username-label");
    if (username === null || "" === (username.trim())) {
      usernameLabel.innerHTML = "UserName can not be empty!";
      //alert(false);
      return false;
    }

    if (username.length < 6 || username.length > 16) {
      usernameLabel.innerHTML = "The length of username must be 6 to 16 digits";
      //alert(false);
      return false;
    }
    document.getElementById("login-form").submit();
  }
</script>
</html>

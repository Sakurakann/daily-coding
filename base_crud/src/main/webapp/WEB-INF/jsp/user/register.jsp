<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/9 0009
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Register</title>
</head>
<body>
<div align="center" style="margin-top: 100px">
    <form action="user?cmd=register" method="post" id="register-form">
        <table>
            <thead>
            <tr>
                <td colspan="2" align="center"></td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td align="right">UserName:</td>
                <td><input placeholder="userName" name="username" id="username">
                </td>
                <td><label for="username" id="username-label"></label></td>
            </tr>
            <tr>
                <td align="right">PassWord:</td>
                <td><input type="password" placeholder="passWord"
                           name="password" id="password"></td>
                <td><label for="password" id="password-label"></label></td>
            </tr>
            <tr>
                <td align="right">E-Mail:</td>
                <td><input placeholder="email" name="email" id="email"></td>
                <td><label for="email" id="email-label"></label></td>
            </tr>
            <tr>
                <td>VerifyCode:</td>
                <td><input placeholder="verifyCode" id="verifyCode"></td>
                <td><label for="verifyCode" id="verifyCode-label"></label></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <button type="button" onclick="registerCheck()">Sign Up
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
<script type="text/javascript">
  function registerCheck() {

    var username = document.getElementById("username").value;
    var usernameLabel = document.getElementById("username-label");
    if (username === null || username.trim() === "") {
      usernameLabel.innerHTML = "Username can not be empty!";
      return false;
    }
    if (username.length < 6 || username.length > 16) {
      usernameLabel.innerHTML = "The length of username must between 6 and 16!";
      return false;
    }
    usernameLabel.innerHTML = "";

    var password = document.getElementById("password").value;
    var passwordLabel = document.getElementById("password-label");
    if (password === null || password.trim() === "") {
      passwordLabel.innerHTML = "Password can not be empty!";
      return false;
    }
    if (password.length < 6 || password.length > 16) {
      passwordLabel.innerHTML = "The length of password must between 6 and 16!";
      return false;
    }
    passwordLabel.innerHTML = "";
    // 至少8位,并包含字母\数字\特殊字符至少各一个
    var passwordRegExp =
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,}$/;

    var email = document.getElementById("email").value;
    var emailLabel = document.getElementById("email-label");
    var emailRegExp = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    if (!emailRegExp.exec(email)) {
        emailLabel.innerHTML = "Error Email!";
      return false;
    }
    emailLabel.innerHTML = "";
    document.getElementById("register-form").submit();
  }
  //registerCheck();
</script>
</html>

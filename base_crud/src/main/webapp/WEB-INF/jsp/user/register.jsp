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
        <form action="">
            <table>
                <thead>
                <tr>
                    <td colspan="2" align="center"></td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td align="right">UserName: </td>
                    <td><input placeholder="userName" name="username"></td>
                </tr>
                <tr>
                    <td align="right">PassWord: </td>
                    <td><input type="password" placeholder="passWord" name="password"></td>
                </tr>
                <tr>
                    <td align="right">E-Mail: </td>
                    <td><input placeholder="email" name="email"></td>
                </tr>
                <tr>
                    <td>VerifyCode: </td>
                    <td><input aria-placeholder="verifyCode"></td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <input type="submit" value="Sign Up"/>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>

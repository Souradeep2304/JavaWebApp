<%--
  Created by IntelliJ IDEA.
  User: devyanshitiwari
  Date: 2019-03-22
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<form action="controller" method='GET'>
    <fieldset>
        <legend style="font-family:Arial Black;">Welcome User</legend>
        <table>
            <tr><td>Email:</td>
                <td><input type='text' name='email' /></td>
            </tr>
            <tr><td>Password:</td>
                <td><input type='text' name='password' /></td>
            </tr>
            <tr><td>Confirm Password:</td>
                <td><input type='text' name='cpassword' /></td>
            </tr>
            <tr><td><input type='submit' value='SignUp' name='act'/></td>
                <td><input type='submit' value='SignIn' name='act'/></td>
            </tr>


        </table>
    </fieldset>
</form>
</body>
</html>

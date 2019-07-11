<%--
  Created by IntelliJ IDEA.
  User: devyanshitiwari
  Date: 2019-03-22
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Account</title>

</head>

<body>
<input type="hidden" name="act1" value="del1"/>
<form action="controller" onsubmit="check()" method="get">

<fieldset>
    <input type="hidden" name="m" value=${userName1}>


<legend style="font-family:Arial Black;">User Information</legend>
<table>
    <tr>
        <td>Username</td>
        <td><%= request.getAttribute("userName1")%></td>
    </tr>
    <tr>
        <td>Date of Sign Up</td>
        <td><%= request.getAttribute("date")%></td>
    </tr>
    <tr>
        <td>Last Date of Sign In</td>
        <td><%= request.getAttribute("l")%></td>
    </tr>
    <tr>
        <td>Last Date of Application Access</td>
        <td><%= request.getAttribute("l1")%></td>
    </tr>
    <tr>
       <td><input type="submit" name="act" value="SignOut" /> </td>
        <td><input type="submit" name="act" value="Update" /> </td>
        <td><input type="checkbox" name="act1" value="del"/>Delete</td>
    </tr>
</table>
</fieldset>
</form>

</body>
</html>

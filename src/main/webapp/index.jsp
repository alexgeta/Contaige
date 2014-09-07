<%--
  Created by IntelliJ IDEA.
  User: Alex_Stuff
  Date: 8/7/2014
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Contaige</title>

</head>
<body bgcolor="#fff5d7">

<table style="width:100%; height:100%; vertical-align:middle;">
    <tr>
        <td>
            <form action="/draw" method="post">
            <table align="center">

            <tr>
                <td colspan="2" align="right">
                    <b>Please input your contact info:</b>
                </td>
            </tr>

            <tr>
                <td align="right">Phone number:</td>
                <td><input type="text" name="phone"  /></td>

            </tr>

            <tr>
                <td align="right">E-mail:</td>
                <td><input type="text" name="email"  /></td>
            </tr>

            <tr>
                <td align="right">Skype:</td>
                <td><input type="text" name="skype" /></td>
            </tr>
            <tr>
                <td align="right">ICQ#:</td>
                <td><input type="text" name="icq"  /></td>
            </tr>
            <tr>
                <td  colspan="2" align="right">
                    <input type="submit" value="Draw !">
                <td/>
            </tr>

            </table>
            </form>
        </td>
    </tr>
</table>


</body>
</html>

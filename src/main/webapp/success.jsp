<%--
  Created by IntelliJ IDEA.
  User: Alex_Stuff
  Date: 8/17/2014
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success!</title>
</head>
<body bgcolor="#fff5d7">
<table style="width:100%; height:100%; vertical-align:middle;">

    <tr>
        <td>
            <table align="center">
                <tr>
                    <td colspan="2" align="center">
                        <b>Generate was successful !</b>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <img src="${directLink}" alt="generated image">
                    </td>
                </tr>

                <tr>
                    <td>
                        <b>Here is your contaige direct link:</b>
                    </td>
                    <td>
                        ${directLink}
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>Here is your contaige download URL:</b>
                    </td>
                    <td>
                        ${downloadUrl}
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>Here is your contaige delete URL:</b>
                    </td>
                    <td>
                        ${deleteUrl}
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <a href="index.jsp">Click Here to create another one</a>
                    </td>
                </tr>
            </table>
        </td>


    </tr>
</table>


</body>
</html>

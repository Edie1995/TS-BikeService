<%-- 
    Document   : loginPage
    Created on : Apr 22, 2019, 9:41:40 PM
    Author     : Martyna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body> 
    <center>
        <header><h2>Log in!</h2></header>
        <table>
            <thead>
                <tr>
                    <th>login</th>
                    <th>password</th>
                </tr>
            </thead>

            <c:forEach items ="${users}" var ="user">
                <tr>
                    <td><c: out value = "${user.login}"/></td>
                <td><c: out value = "${user.password}"/></td>
                </tr>
            </c:forEach>
            <form action="login" method = "POST">
                <tr>
                   
                    <td><input type = "text" name = "login" /></td>
                    <td><input type = "password" name = "password" /></td>

                </tr>

                <tr>
                       <td>&nbsp;</td>
                    <td><input type="submit" value = "Ok"/></td>
                </tr>
            </form>

        </table>
    </center>
</body>
</html>
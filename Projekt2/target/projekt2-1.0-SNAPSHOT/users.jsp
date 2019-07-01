<%-- 
    Document   : services.jsp
    Created on : 2019-06-13, 09:57:49
    Author     : Magda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body> 
    <center>
        <header><h2>Obsługa uzytkownikow</h2></header>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>login</th>
                    <th>password</th>
                    <th>position</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items ="${users}" var ="user">
                <tr>
                    <td><c: out value = "${user.id}"/></td>
                <td><c: out value = "${user.login}"/></td>
                <td><c: out value = "${user.password}"/></td>
                <td><c: out value = "${user.position}"/></td>
                </tr>
            </c:forEach>
            <form action="users" method = "POST">
                <tr>
                    <td>&nbsp;</td>
                    <td><input type = "text" name = "login" /></td>
                    <td><input type = "text" name = "password" /></td>
                    <td><input type = "text" name = "position" /></td>
                </tr>


                <table>
                    <tr>
                        <td>
                            <input type="radio"  name="action" value = "dodaj"/>Dodaj</td>
                    </tr>
                    <tr>
                        <td><input type="radio"  name="action" value = "usun"/>Usun</td>
                    </tr>
                    <tr>
                        <td><input type="radio"  name="action" value = "zmien"/>Zmien</td>
                    </tr>
                </table>
                <tr>
                    <td><input type="submit" value = "Ok"/></td>
                </tr>
            </form>
            </tbody>
        </table></center>
</body>
</html>
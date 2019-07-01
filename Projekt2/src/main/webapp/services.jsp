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
        <title>Services</title>
    </head>
    <body> 
    <center>
       <header><h2>Obsługa serwisu</h2></header>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>userLogin</th>
                    <th>name</th>
                    <th>date</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items ="${services}" var ="service">
                <tr>
                    <td><c: out value = "${service.id}"/></td>
                <td><c: out value = "${service.userLogin}"/></td>
                <td><c: out value = "${service.name}"/></td>
                <td><c: out value = "${service.date}"/></td>
                </tr>
            </c:forEach>
            <form action="services" method = "POST">
                <tr>
                    <td>&nbsp;</td>
                    <td><input type = "text" name = "userLogin" /></td>
                    <td><input type = "text" name = "name" /></td>
                    <td><input type = "date" name = "date" /></td>
                </tr>


                <table>
                    <tr>

                        <td><input type="radio"  name="action" value = "dodaj"/>Dodaj</td>   </tr>
                    <tr> <td><input type="radio"  name="action" value = "usun"/>Usun</td>  </tr>
                    <tr>     <td><input type="radio"  name="action" value = "zmien"/>Zmien</td>  </tr>
                </table>
                <tr><td><input type="submit" value = "Ok"/></td></tr>
            </form>
        </tbody>
        </table></center>
</body>
</html>
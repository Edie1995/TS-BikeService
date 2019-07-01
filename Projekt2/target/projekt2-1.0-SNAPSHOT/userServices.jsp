<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UserServices</title>
    </head>
    <body> 
    <center>
        <header><h2>Obsługa Twojego serwisu</h2></header>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>date</th>
                </tr>
            </thead>
            <tbody>
            <form action="userServices" method="get">
                <thead>
                    <c:forEach items ="${services}" var ="service">
                        <tr>
                            <td><c:out value = "${service.id}"/></td>
                            <td><c:out value = "${service.name}"/></td>
                            <td><c:out value = "${service.data}"/></td>
                        </tr>
                    </c:forEach>
                </thead>
            </form>
            <form action="userServices" method = "POST">
                <tr>
                   <td>&nbsp;</td>
                    <td><input type = "text" name = "name" /></td>
                    <td><input type = "date" name = "data" /></td>
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
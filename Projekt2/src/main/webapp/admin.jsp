<%-- 
    Document   : admin
    Created on : 2019-06-13, 13:48:43
    Author     : kruko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><center>
        <h1>Co dalej?</h1>
        <form action="admin" method = "POST">
             <table>
                    <tr>

                        <td><input type="radio"  name="action" value = "dodaj klienta"/>Dodaj Klienta</td>   </tr>
                    <tr> <td><input type="radio"  name="action" value = "zobacz serwisy"/>Zobacz Serwisy</td>  </tr>
            <tr>
                <td><input type="submit"  value = "Ok"/></td>
            </tr
           
        </form>
    </center>
</body>
</html>

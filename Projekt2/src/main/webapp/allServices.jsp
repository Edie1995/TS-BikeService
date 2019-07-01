<%-- 
    Document   : allServices
    Created on : 2019-06-13, 16:45:57
    Author     : kruko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Services</title>
    </head>
    <body> 

    <center>
        <header><h2>Wszystkie serwisy</h2></header>
        <DIV class="pv4 pv2-ns ph2 bg-light-gray overflow-y-scroll w-70-ns"  style="background-image: linear-gradient(to right, rgba(30, 75, 115, 1), rgba(255, 255, 255, 0)">
            <blockquote class="lh-copy">
                <table >
                    <!-- Table header -->

                    <thead>
                        <tr>
                            <th>id</th>
                            <th>username</th>
                            <th>name</th>
                            <th>data</th>
                        </tr>
                    </thead>

                    <tbody>
                    <form action="allServices" method="get">
                    <thead>

                        <c:forEach items ="${services}" var ="service">
                            <tr>
                                <td><c:out value = "${service.id}"/></td>
                                <td><c:out value = "${service.username}"/></td>
                                <td><c:out value = "${service.name}"/></td>
                                <td><c:out value = "${service.data}"/></td>
                            </tr>
                        </c:forEach>

                    </thead>
                    </form>
                    </tbody>
                </table>
            </blockquote>
        </div>

    </center>
</body>
</html>

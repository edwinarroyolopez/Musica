<%-- 
    Document   : mostrar
    Created on : Mar 12, 2018, 11:28:15 AM
    Author     : zero
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Lista de artistas</h1>
        
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                <td>Edad</td>
                <td>Pais</td>
            </tr>
            
            <c:forEach var="f" items="${requestScope.listaArtistas}" >
                <tr>
                    <td>${f.id}</td>
                    <td>${f.nombre}</td>
                    <td>${f.edad}</td>
                    <td>${f.pais}</td>
                </tr>
            </c:forEach>
            
        </table>
        
        
    </body>
</html>

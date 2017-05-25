<%-- 
    Document   : recuperandosenha
    Created on : 16/05/2017, 11:47:45
    Author     : rogerd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Srecuperarsenha" method="POST">
            Informe seu CPF:
            <br>
            <input type="text" name="cpf" pattern="[0-9]{11}" title="exemplo: 03458965099" required="required" maxlength="11">
            <br>
            <input type="submit">
        </form>
    </body>
</html>

<%-- 
    Document   : Cadastro_Editora
    Created on : 16/05/2017, 08:19:06
    Author     : estudos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Admin.jsp"/>
        <h3> Cadastro de Editoras </h3>
        <form action="Scontroler?acao=inserireditora" method="POST">
            Nome: <input type="text" name="Nome" title= "exemplo: Novatec"  maxlength="50" />
            <br>
            <input type="submit" value="Salvar" />
            <input type="submit" value="Cancelar" />
        </form>
        
    </body>
</html>

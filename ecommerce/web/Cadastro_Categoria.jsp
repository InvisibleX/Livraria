<%-- 
    Document   : Cadastro_Categoria
    Created on : 16/05/2017, 08:16:56
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
        <h3>Cadastro de Categorias</h3>
        <form method="POST" action="Scontroler?acao=inserircategoria">
            Nome: <input type="text" name="Nome" title= "exemplo: Banco de Dados"  pattern="[a-z\s]+$"  />
            <br>
            <input type="submit" value="Salvar" />
            <input type="submit" value="Cancelar" />
        </form>
    </body>
</html>

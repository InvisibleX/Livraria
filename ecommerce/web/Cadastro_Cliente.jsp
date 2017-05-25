<%-- 
    Document   : Cadastro_Cliente
    Created on : 16/05/2017, 08:20:33
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
        <h3>Cadastro de Clientes</h3>
        <form action="Scontroler?acao=inserircliente" method="POST">
            Nome: <input type="text" title= "exemplo: Roger Denardi" name="Nome" pattern="[a-z\s]+$" maxlength="50" size="40" />
            <br>
            CPF: <input type="text" name="CPF" pattern="[0-9]{11}" title="exemplo: 03458965099" required="required" maxlength="11" value="" />
            <br>
            Email: <input type="text" name="Email"  required="required" title="exemplo: rogerdenardimachado@hotmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"   maxlength="50" />
            <br>
            Senha: <input type="password" name="Senha" required="required"   
                           maxlength="16" size="20"/>
            <br>
            <input type="submit" value="Salvar" />
            <input type="submit" value="Cancelar" />
        </form>
        
    </body>
</html>

<%-- 
    Document   : Log
    Created on : 16/05/2017, 12:30:03
    Author     : rogerd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/css_login.css">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="container">
            <img src="img/admin.png">
            <form action="Slogin" method="GET" >
                <div class="form-input">
                    <input type="text" name="Email" placeholder="Email">
                </div>
                <div class="form-input">
                    <input type="password" name="Senha" placeholder="Senha">
                </div>
                <input type="submit" name="Login" value="Entrar" id="btl" >
                <br>
                <a href="Scontroler?acao=recuperarsenha">Perdeu a senha?</a>
            <br>
            <a href="Scontroler?acao=cadastrocliente">Cadastre-se</a>
            <br>
            </form>
        </div>
        
    </body>
</html>

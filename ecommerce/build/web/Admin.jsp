<%-- 
    Document   : menu
    Created on : 16/05/2017, 20:00:19
    Author     : rogerd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css"  href="css/Estilo.css" />
       
    </head>
    <body>
        <ul>
            <li><a href="Admin.jsp">Home</a></li>
            <li class="dropdown"><a href="#" class="dropdown-btn">Categoria</a>
                <div class="dropdown-menu">
                    <a href="Scontroler?acao=cadastrocategoria">Cadastrar categoria</a>
                    <a href="Scontroler?acao=consultarcategoria">Consultar categoria</a>
                </div>
            
            </li>
            <li class="dropdown"><a href="#" class="dropdown-btn">Editora</a>
                <div class="dropdown-menu">
                    <a href="Scontroler?acao=cadastroeditora">Cadastrar editora</a>
                    <a href="Scontroler?acao=consultareditora">Consultar editora</a>
                </div>
            
            </li>
            <li class="dropdown"><a href="#" class="dropdown-btn">Cliente</a>
                <div class="dropdown-menu">
                    <a href="Scontroler?acao=cadastrocliente">Cadastrar cliente</a>
                    <a href="Scontroler?acao=consultarcliente">Consultar cliente</a>
                </div>
            
            </li>
            <li class="dropdown"><a href="#" class="dropdown-btn">Produto</a>
                <div class="dropdown-menu">
                    <a href="Scontroler?acao=cadastroproduto">Cadastrar produto</a>
                    <a href="Scontroler?acao=consultarproduto">Consultar produto</a>
                </div>
            
            </li>
              <li class="dropdown"><a href="#" class="dropdown-btn">Venda</a>
                <div class="dropdown-menu">
                    <a href="Scontroler?acao=consultarvenda">Consultar venda</a>
                    <a href="Scontroler?acao=consultaritv">Consultar itens de venda</a>
                </div>
            
            </li>
             <li class="dropdown"><a href="#" class="dropdown-btn">Relatorio</a>
                <div class="dropdown-menu">
                    <a href="#">Produto mais vendido</a>
                    <a href="#">Cliente que mais comprou</a>
                </div>
            
            </li>
            <li id="sair"><a href="login.jsp">Sair</a></li>
        </ul>
        
    </body>
</html>

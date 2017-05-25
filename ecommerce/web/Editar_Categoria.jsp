<%-- 
    Document   : Editar_Categoria
    Created on : 16/05/2017, 08:27:45
    Author     : estudos
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.Categoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Admin.jsp" />
        <h3>Editar Categoria</h3>
        <form method="POST" action="Scontroler?acao=alterandocategoria">
             <%
            List<Categoria> lista = (List<Categoria>)request.getAttribute("lista");
            Iterator i = lista.iterator();
            while(i.hasNext()){
                //criar uma instancia do cliente 
                Categoria categoria = (Categoria) i.next();
                %>
            Nome: <input type="text" name="Nome" value="<%=categoria.getNome()%>" title= "exemplo: Banco de Dados"  pattern="[a-z\s]+$" maxlength="50"/>
            <input type="text" name="Id" value="<%=categoria.getId()%>" hidden><br>
            <input type="submit" value="Salvar" />
            <input type="submit" value="Cancelar" />
           
            <%
                }
            %>
        </form>
            
        
    </body>
</html>

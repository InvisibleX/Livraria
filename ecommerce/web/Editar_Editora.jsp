<%-- 
    Document   : Editar_Categoria
    Created on : 16/05/2017, 08:27:45
    Author     : estudos
--%>

<%@page import="model.Editora"%>
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
        <h3>Editar Editora</h3>
        <form method="POST" action="Scontroler?acao=alterandoeditora">
             <%
            List<Editora> lista = (List<Editora>)request.getAttribute("lista");
            Iterator i = lista.iterator();
            while(i.hasNext()){
                //criar uma instancia do cliente 
                Editora editora = (Editora) i.next();
                %>
            Nome: <input type="text" name="Nome" value="<%=editora.getNome()%>" title= "exemplo: Banco de Dados"  pattern="[a-z\s]+$" maxlength="50"/>
            <input type="text" name="Id" value="<%=editora.getId()%>" hidden><br>
            <input type="submit" value="Salvar" />
            <input type="submit" value="Cancelar" />
           
            <%
                }
            %>
        </form>
            
        
    </body>
</html>

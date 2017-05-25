<%-- 
    Document   : Consultar_Categoria
    Created on : 20/05/2017, 16:19:20
    Author     : rogerd
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
        <link rel="stylesheet" type="text/css"  href="css/Estilo.css" />
    </head>
    <jsp:include page="Admin.jsp"/>
    <body>
        <br>
        <table> 
            <thead>
            <th hidden>id </th>
                <th>Nome</th>
                <th>Excluir</th>
                <th>Alterar</th>
                
        </thead>
        <%
            List<Categoria> listadecategoria = (List<Categoria>)request.getAttribute("lista");
            Iterator i = listadecategoria.iterator();
            while(i.hasNext()){
                //criar uma instancia do cliente 
                Categoria categoria = (Categoria) i.next();
                %>
                <tr>
                 <td hidden><%=categoria.getId() %></td>
                 <td><%=categoria.getNome() %></td>
                 <td><a href="Scontroler?acao=excluircategoria&id=<%=categoria.getId()%>">Excluir</a></td>
                 <td><a href="Scontroler?acao=alterarcategoria&id=<%=categoria.getId()%>">Alterar</a></td>
                 </tr>
                 <%
            }
            
            %>
        
    </table>
    </body>
</html>

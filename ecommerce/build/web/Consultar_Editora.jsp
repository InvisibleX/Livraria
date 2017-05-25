<%-- 
    Document   : Consultar_Categoria
    Created on : 20/05/2017, 16:19:20
    Author     : rogerd
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
            List<Editora> listadeeditora = (List<Editora>)request.getAttribute("lista");
            Iterator i = listadeeditora.iterator();
            while(i.hasNext()){
                //criar uma instancia do cliente 
                Editora editora = (Editora) i.next();
                %>
                <tr>
                 <td hidden><%=editora.getId() %></td>
                 <td><%=editora.getNome() %></td>
                 <td><a href="Scontroler?acao=excluireditora&id=<%=editora.getId()%>">Excluir</a></td>
                 <td><a href="Scontroler?acao=alterareditora&id=<%=editora.getId()%>">Alterar</a></td>
                 </tr>
                 <%
            }
            
            %>
        
    </table>
    </body>
</html>

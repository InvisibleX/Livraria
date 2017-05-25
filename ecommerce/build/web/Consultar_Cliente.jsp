<%-- 
    Document   : Consultar_Categoria
    Created on : 20/05/2017, 16:19:20
    Author     : rogerd
--%>

<%@page import="model.Cliente"%>
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
            <th hidden>Id</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Email</th>
                <th>Senha</th>
                <th>Nível</th>
                <th>Excluir</th>
                <th>Alterar</th>
                
        </thead>
        <%
            List<Cliente> listadecliente = (List<Cliente>)request.getAttribute("lista");
            Iterator i = listadecliente.iterator();
            while(i.hasNext()){
                //criar uma instancia do cliente 
                Cliente cliente = (Cliente) i.next();
                %>
                <tr>
                 <td hidden><%=cliente.getId() %></td>
                 <td><%=cliente.getNome() %></td>
                 <td><%=cliente.getCpf() %></td>
                 <td><%=cliente.getEmail() %></td>
                 <td><%=cliente.getSenha() %></td>
                 <td><%=cliente.getNivel() %></td>
                 <td><a href="Scontroler?acao=excluircliente&id=<%=cliente.getId()%>">Excluir</a></td>
                 <td><a href="Scontroler?acao=alterarcliente&id=<%=cliente.getId()%>">Alterar</a></td>
                 </tr>
                 <%
            }
            
            %>
        
    </table>
    </body>
</html>

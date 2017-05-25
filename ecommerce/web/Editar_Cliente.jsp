<%-- 
    Document   : Editar_Cliente2
    Created on : 21/05/2017, 19:03:08
    Author     : rogerd
--%>

<%@page import="model.Cliente"%>
<%@page import="java.util.Iterator"%>
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
        <br>
        <h3>Alterar Cliente</h3>
        <form action="Scontroler?acao=alterandocliente" method="POST">
            <%
            List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
            Iterator i = lista.iterator();
            while(i.hasNext()){
                //criar uma instancia do cliente 
                Cliente cliente = (Cliente) i.next();
                %>
            <input type="text" name="Id" value="<%=cliente.getId() %>" hidden>
            <br>
            Nome: <input type="text" name="Nome" value="<%=cliente.getNome() %>" title= "exemplo: Banco de Dados"  pattern="[a-z\s]+$" maxlength="50"/>
            <br>
            CPF: <input type="text" name="CPF" value="<%=cliente.getCpf() %>" pattern="[0-9]{11}" title="exemplo: 03458965099" required="required" maxlength="11" />
            <br>
            Email: <input type="text" name="Email" value="<%=cliente.getEmail() %>" required="required" title="exemplo: rogerdenardimachado@hotmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"   />
            <br>
            Senha: <input type="text" name="Senha" value="<%=cliente.getSenha() %>" required="required" 
                          title="exemplo: roger123A"  
                          >
            <br>
            Nível:
            <br>
            <select name="Nivel">
                <option value="<%=cliente.getNivel() %>"><%=cliente.getNivel() %></option>
                <%
                        if(cliente.getNivel().equals("usuario")){
                            %>
                            <option value="administrador">administrador</option> 
                  <%
                     
                        }else{
                       %>
                       <option value="usuario">usuario</option> 
                       <%
}
                        
}
                %>
            </select>
                    
                <br>
            
            <input type="submit" value="Salvar" />
            <input type="submit" value="Cancelar" />
        </form>
    </body>
</html>

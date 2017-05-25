<%-- 
    Document   : Cadastro_Produto
    Created on : 16/05/2017, 08:21:35
    Author     : estudos
--%>

<%@page import="model.Categoria"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Editora"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Admin.jsp"/>
        <h3>Cadastro de Produtos</h3>
        
        <form action="Inserirproduto" method="POST" enctype="multipart/form-data">
            Nome: <input type="text" name="Nome"  maxlength="50" />
            <br>
            Volume: <input type="number" name="Volume"/>
            <br>
            Editora: 
             <%
            List<Editora> listadeeditora = (List<Editora>)request.getAttribute("listadeeditora");
            Iterator i = listadeeditora.iterator();
            while(i.hasNext()){
                //criar uma instancia do cliente 
                Editora editora = (Editora) i.next();
                %>
                <br>
                <input type="radio" name="id_editora" value="<%=editora.getId() %>"><%=editora.getNome()%>
                
              <%
            }
            
            %>
            <br>
            Descrição: <input type="text" name="Descricao" pattern="[a-z\s]+$"/>
            <br>
            Imagem: <input type="file" name="Imagem" >
            <br>
            Preço: <input type="number" name="Preco" title="exemplo: 100" required="required"/> R$
            <br>
            Quantidade: <input type="number" name="Quantidade" title="exemplo: 2" required="required"/> 
            <br>            
            Categoria: 
            <%
            List<Categoria> listadecategoria = (List<Categoria>)request.getAttribute("listadecategoria");
            Iterator i2 = listadecategoria.iterator();
            while(i2.hasNext()){
                //criar uma instancia do cliente 
                Categoria categoria = (Categoria) i2.next();
                %>
                <br>
                <input type="radio" name="id_categoria" value="<%=categoria.getId() %>"><%=categoria.getNome()%>
                
              <%
            }
            
            %>
            <br>
            <input type="text" name="destino" value="c:\Users\rogerd\NetbeansProjects\ecommerce\web\imagem"> 
            <input type="submit" value="Salvar" />
            <input type="submit" value="Cancelar" />
        </form>
        
    </body>
</html>

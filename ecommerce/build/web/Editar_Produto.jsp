<%-- 
    Document   : Editar_Produto
    Created on : 16/05/2017, 08:29:03
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
        
        <form action=" " method="POST">
            Nome: <input type="text" name="Nome" value="" required="required" title= "exemplo: Roger Denardi"  pattern="[a-z\s]+$" maxlength="50"/>
            <br>
            Volume: <input type="number" name="Volume" value=""  required="required"/>
            <br>
            Editora: <input type="text" name="Editora" value="" />
            <br>            
            Descrição: <input type="text" name="Descricao" value="" required="required"/>
            <br>
            Imagem: <input type="file" name="Imagem" required="required" accept="image/*" >
            <br>
            Preço: <input type="number" name="Preco" value=""/>
            <br>
            Quantidade: <input type="number" name="Quantidade" value=""/>
            <br>            
            Categoria: <input type="text" name="Categoria" value="" />
            <br>                        
            <input type="submit" value="Salvar" />
            <input type="submit" value="Cancelar" />
        </form>
        
    </body>
</html>

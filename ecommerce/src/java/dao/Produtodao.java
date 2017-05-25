/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.UnavailableException;
import model.Produto;

/**
 *
 * @author rogerd
 */
public class Produtodao {
    private Connection con;
    public void Conectar() throws UnavailableException{
   try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomerce", "root", "");

        } catch (Exception e) {
            throw new UnavailableException(e.toString());
        }
    }
    public Produtodao() throws UnavailableException{
        Conectar();
    }
    public void Inserirproduto(Produto produto) throws SQLException{
        try{
             String sql = "INSERT INTO produto VALUES(NULL,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareCall(sql);
        pstmt.setString(1, produto.getNome());
        pstmt.setInt(2, produto.getVolume());
        pstmt.setInt(3, produto.getId_editora());
        pstmt.setString(4, produto.getDescricao());
        pstmt.setString(5, produto.getImagem());
        pstmt.setInt(6, (int) produto.getPreco());
        pstmt.setInt(7, produto.getQuantidade());
        pstmt.setInt(8, produto.getId_categoria());
        pstmt.execute();
        pstmt.close();
        }catch(Exception e){
            System.out.println("erro ao inserir: "+e.getMessage());
        }
       
    }
    public void Excluirproduto(Produto produto) throws SQLException{
       try{
           String sql = "DELETE FROM produto WHERE id = ?";
           PreparedStatement pstmt = con.prepareCall(sql);
           pstmt.setInt(1, produto.getId());
           pstmt.execute();
           pstmt.close();
       }catch(Exception e){
           System.out.println("erro: "+e.getMessage());
       }
    }
    public void Editarproduto(Produto produto) throws SQLException{
        try{
            String sql = "UPDATE produto SET nome = ? , volume = ?, id_editora = ?, descricao = ?, imagem = ?, preco = ?, quantidade = ?, id_categoria = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareCall(sql);
           
        pstmt.setString(1, produto.getNome());
        pstmt.setInt(2, produto.getVolume());
        pstmt.setInt(3, produto.getId_editora());
        pstmt.setString(4, produto.getDescricao());
        pstmt.setString(5, produto.getImagem());
        pstmt.setInt(6, (int) produto.getPreco());
        pstmt.setInt(7, produto.getQuantidade());
        pstmt.setInt(8, produto.getId_categoria());
        pstmt.setInt(9, produto.getId());
        pstmt.execute();
        pstmt.close();
        }catch(Exception e){
            System.out.println("erro: "+e.getMessage());
        }
    }
    public List Consultar(Produto produto) throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM produto WHERE id = ?");
            pstmt.setInt(1, produto.getId());
            ResultSet rs = pstmt.executeQuery();

            List<Produto> listadeproduto = new ArrayList<Produto>();
            while (rs.next()) {
                Produto produto2 = new Produto();
                produto2.setId(Integer.parseInt(rs.getString("id")));
                produto2.setNome(rs.getString("nome"));
                produto2.setVolume(Integer.parseInt(rs.getString("volume")));
                produto2.setId_editora(Integer.parseInt(rs.getString("id_editora")));
                produto2.setDescricao(rs.getString("descricao"));
                produto2.setImagem(rs.getString("imagem"));
                produto2.setPreco(Integer.parseInt(rs.getString("preco")));
                produto2.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                produto2.setId_categoria(Integer.parseInt(rs.getString("id_categoria")));
                listadeproduto.add(produto2);

            }
            pstmt.close();
            rs.close();
            return listadeproduto;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
     public List listaproduto() throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM produto");
            ResultSet rs = pstmt.executeQuery();

            List<Produto> listadeproduto = new ArrayList<Produto>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(Integer.parseInt(rs.getString("id")));
                produto.setNome(rs.getString("nome"));
                produto.setVolume(Integer.parseInt(rs.getString("volume")));
                produto.setId_editora(Integer.parseInt(rs.getString("id_editora")));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagem(rs.getString("imagem"));
                produto.setPreco(Integer.parseInt(rs.getString("preco")));
                produto.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                produto.setId_categoria(Integer.parseInt(rs.getString("id_categoria")));
                listadeproduto.add(produto);

            }
            pstmt.close();
            rs.close();
            return listadeproduto;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    
    
    
}

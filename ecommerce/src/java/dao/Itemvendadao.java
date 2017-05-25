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
import model.Itemvenda;

/**
 *
 * @author rogerd
 */
public class Itemvendadao {
    private Connection con;
    public void Conectar() throws UnavailableException{
   try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomerce", "root", "");

        } catch (Exception e) {
            throw new UnavailableException(e.toString());
        }
    }
    public Itemvendadao() throws UnavailableException{
        Conectar();
    }
    public void Inseriritemvenda(Itemvenda it) throws SQLException{
        try{
            String sql = "INSERT INTO itemvenda VALUES(NULL,?,?,?)";
        PreparedStatement pstmt = con.prepareCall(sql);
        pstmt.setInt(1, it.getCodvenda());
        pstmt.setInt(2, it.getCodproduto()); 
        pstmt.setInt(3, it.getQuantidade());
        pstmt.execute();
        pstmt.close();
        }catch(Exception e){
            System.out.println("erro: "+e.getMessage());
        }
        
    }
    public void Excluiritemvenda(Itemvenda it) throws SQLException{
        try{
            String sql = "DELETE FROM itemvenda WHERE id = ?";
            PreparedStatement pstmt = con.prepareCall(sql);
        pstmt.setInt(1, it.getId());
        pstmt.execute();
        pstmt.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
    public void Editaritemvenda(Itemvenda it){
        try{
            String sql = "UPDATE itemvenda SET codvenda = ?, codproduto = ?, quantidade = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareCall(sql);
        pstmt.setInt(1, it.getCodvenda());
        pstmt.setInt(2, it.getCodproduto());
        pstmt.setInt(3, it.getQuantidade());
        pstmt.setInt(1, it.getId());
        pstmt.execute();
        pstmt.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
     public List Consultar(Itemvenda it) throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM itemvenda WHERE id = ?");
            pstmt.setInt(1, it.getId());
            ResultSet rs = pstmt.executeQuery();

            List<Itemvenda> listadeit = new ArrayList<Itemvenda>();
            while (rs.next()) {
                Itemvenda it2 = new Itemvenda();
                it2.setId(Integer.parseInt(rs.getString("id")));
                it2.setCodvenda(Integer.parseInt(rs.getString("codvenda")));
                it2.setCodproduto(Integer.parseInt(rs.getString("codproduto")));
                it2.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                
                listadeit.add(it2);

            }
            pstmt.close();
            rs.close();
            return listadeit;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    
}
     
}

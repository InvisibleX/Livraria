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
import model.Categoria;
import model.Cliente;


/**
 *
 * @author rogerd
 */
public class Categoriadao {
    private Connection con;
    public void Conectar() throws UnavailableException{
   try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomerce", "root", "");

        } catch (Exception e) {
            throw new UnavailableException(e.toString());
        }
    }
    public Categoriadao() throws UnavailableException{
        Conectar();
    }
    public void Inserircategoria(Categoria categoria){
         try {
            PreparedStatement pstmt = con.prepareCall("INSERT INTO categoria VALUES(NULL,?)");
            pstmt.setString(1, categoria.getNome());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }
    }
    public void Excluircategoria(Categoria categoria){
         try {
            PreparedStatement pstmt = con.prepareCall("DELETE FROM categoria WHERE id = ?");
            pstmt.setInt(1, categoria.getId());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }
    }
    public void Editarcategoria(Categoria categoria){
        try {
            PreparedStatement pstmt = con.prepareCall("UPDATE categoria SET nome = ? WHERE id = ?");
            pstmt.setString(1, categoria.getNome());
            pstmt.setInt(2, categoria.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
    public List Consultar(Categoria categoria) throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM categoria WHERE id = ?");
            pstmt.setInt(1, categoria.getId());
            ResultSet rs = pstmt.executeQuery();

            List<Categoria> listadecategoria = new ArrayList<Categoria>();
            while (rs.next()) {
                Categoria categoria2 = new Categoria();
                categoria2.setId(Integer.parseInt(rs.getString("id")));
                categoria2.setNome(rs.getString("nome"));
                
                listadecategoria.add(categoria2);

            }
            pstmt.close();
            rs.close();
            return listadecategoria;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
     public List Listarcategoria() throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM categoria");
            ResultSet rs = pstmt.executeQuery();

            List<Categoria> listacategoria = new ArrayList<Categoria>();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(Integer.parseInt(rs.getString("id")));
                categoria.setNome(rs.getString("nome"));
                listacategoria.add(categoria);

            }
            pstmt.close();
            rs.close();
            return listacategoria;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

    
}

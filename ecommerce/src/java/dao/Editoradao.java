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
import model.Editora;

/**
 *
 * @author rogerd
 */
public class Editoradao {
    private Connection con;
    public void Conectar() throws UnavailableException{
   try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomerce", "root", "");

        } catch (Exception e) {
            throw new UnavailableException(e.toString());
        }
    }
    public Editoradao() throws UnavailableException{
        Conectar();
    }
    public void Inserireditora(Editora editora){
         try {
            PreparedStatement pstmt = con.prepareCall("INSERT INTO editora VALUES(NULL,?)");
            pstmt.setString(1, editora.getNome());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }
    }
    public void Excluireditora(Editora editora){
         try {
            PreparedStatement pstmt = con.prepareCall("DELETE FROM editora WHERE id = ?");
            pstmt.setInt(1, editora.getId());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }
    }
    public void Editareditora(Editora editora){
        try {
            PreparedStatement pstmt = con.prepareCall("UPDATE editora SET nome = ? WHERE id = ?");
            pstmt.setString(1, editora.getNome());
            pstmt.setInt(2, editora.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
    public List Consultar(Editora editora) throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM editora WHERE id = ?");
            pstmt.setInt(1, editora.getId());
            ResultSet rs = pstmt.executeQuery();

            List<Editora> listadeeditora = new ArrayList<Editora>();
            while (rs.next()) {
                Editora editora2 = new Editora();
                editora2.setId(Integer.parseInt(rs.getString("id")));
                editora2.setNome(rs.getString("nome"));
                
                listadeeditora.add(editora2);

            }
            pstmt.close();
            rs.close();
            return listadeeditora;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    public List Listareditora() throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM editora");
            ResultSet rs = pstmt.executeQuery();

            List<Editora> listaeditora = new ArrayList<Editora>();
            while (rs.next()) {
                Editora editora = new Editora();
                editora.setId(Integer.parseInt(rs.getString("id")));
                editora.setNome(rs.getString("nome"));
                listaeditora.add(editora);

            }
            pstmt.close();
            rs.close();
            return listaeditora;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }

    
    
}

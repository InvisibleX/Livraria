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
import model.Venda;

/**
 *
 * @author rogerd
 */
public class Vendadao {
    private Connection con;
    
    
    public void Conectar() throws UnavailableException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomerce", "root", "");

        } catch (Exception e) {
            throw new UnavailableException(e.toString());
        }
    }
    public Vendadao() throws UnavailableException{
        Conectar();
    }
    public void Inserirvenda(Venda venda){
         try {
            PreparedStatement pstmt = con.prepareCall("INSERT INTO Venda VALUES(NULL,?,?)");
            pstmt.setInt(1, venda.getId_cliente());
            pstmt.setInt(2, (int) venda.getTotal());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }
    }
    public void Excluirvenda(Venda venda) throws SQLException{
        try{
            String sql = "DELETE FROM venda WHERE id = ?";
            PreparedStatement pstmt = con.prepareCall(sql);
            pstmt.setInt(1, venda.getId());
            pstmt.execute();
            pstmt.close();
        }catch(Exception e){
            System.out.println("erro: "+e.getMessage());
        }
    }
    public List Listarvenda() throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM venda");
            ResultSet rs = pstmt.executeQuery();

            List<Venda> listavenda = new ArrayList<Venda>();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(Integer.parseInt(rs.getString("id")));
                venda.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
                venda.setTotal(Integer.parseInt(rs.getString("total")));
                listavenda.add(venda);

            }
            pstmt.close();
            rs.close();
            return listavenda;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
 
    
}

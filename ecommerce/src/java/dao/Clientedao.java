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
import model.Cliente;

/**
 *
 * @author rogerd
 */
public class Clientedao {
    private Connection con;
    public String email = "";
    public String nivel = "";
    
    public void Conectar() throws UnavailableException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomerce", "root", "");

        } catch (Exception e) {
            throw new UnavailableException(e.toString());
        }
    }
    public Clientedao() throws UnavailableException{
    Conectar();
}
    public void Inserircliente(Cliente cliente){
        try {
            PreparedStatement pstmt = con.prepareCall("INSERT INTO cliente VALUES(NULL,?,?,?,?,DEFAULT)");
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getSenha());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }
    }
    public void Excluircliente(Cliente cliente) throws SQLException{
        try {
            PreparedStatement pstmt = con.prepareCall("DELETE FROM cliente WHERE id = ?");
            pstmt.setInt(1, cliente.getId());
            pstmt.execute();
            pstmt.close();
    }catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
    public void Editarcliente(Cliente cliente){
        try {
            PreparedStatement pstmt = con.prepareCall("UPDATE cliente SET cpf = ?, nome = ?, email = ?, senha = ?, nivel = ? WHERE id = ?");
            pstmt.setString(1, cliente.getCpf());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getSenha());
            pstmt.setString(5, cliente.getNivel());
            pstmt.setInt(6, cliente.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
    public String verifica(Cliente cliente) throws SQLException{
        String sql = "SELECT email FROM cliente WHERE cpf = ?";
        PreparedStatement pstmt = con.prepareCall(sql);
        pstmt.setString(1, cliente.getCpf());
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
        email = rs.getString("email");
        }
        rs.close(); 
        pstmt.close();
        return email;
       
    }
    public void Alterasenha(Cliente cliente) throws SQLException{
         String sql = "UPDATE cliente SET senha = ? WHERE cpf = ?";
        PreparedStatement pstmt = con.prepareCall(sql);
        pstmt.setString(1, cliente.getSenha());
        pstmt.setString(2, cliente.getCpf());
        pstmt.executeUpdate();
        pstmt.close();
        
    }
    public List Consultar(Cliente cliente) throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM cliente WHERE id = ?");
            pstmt.setInt(1, cliente.getId());
            ResultSet rs = pstmt.executeQuery();

            List<Cliente> listadecliente = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente cliente2 = new Cliente();
                cliente2.setId(Integer.parseInt(rs.getString("id")));
                cliente2.setNome(rs.getString("nome"));
                cliente2.setCpf(rs.getString("cpf"));
                cliente2.setEmail(rs.getString("email"));
                cliente2.setSenha(rs.getString("senha"));
                cliente2.setNivel(rs.getString("nivel"));
                listadecliente.add(cliente2);

            }
            pstmt.close();
            rs.close();
            return listadecliente;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    public List Listarcliente() throws SQLException {
        try {
            PreparedStatement pstmt = con.prepareCall("SELECT * FROM cliente");
            ResultSet rs = pstmt.executeQuery();

            List<Cliente> listacliente = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(rs.getString("id")));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setNivel(rs.getString("nivel"));
                listacliente.add(cliente);

            }
            pstmt.close();
            rs.close();
            return listacliente;
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
            return null;
        }
    }
    public String verificalog(Cliente cliente) throws SQLException{
        String sql = "SELECT nivel FROM cliente WHERE email = ? AND senha = ?";
        PreparedStatement pstmt = con.prepareCall(sql);
        pstmt.setString(1, cliente.getEmail());
        pstmt.setString(2, cliente.getSenha());
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            nivel = rs.getString("nivel");
        }
        rs.close();
        pstmt.close();
        return nivel;
    }

}
    


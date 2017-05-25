/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.Clientedao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author rogerd
 */
public class Srecuperarsenha extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, EmailException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Cliente cliente = new Cliente(); 
            cliente.setCpf(request.getParameter("cpf"));
            Clientedao dao = new Clientedao();
            String senha = gerasenha();
            cliente.setSenha(senha);
            String email = dao.verifica(cliente);
            dao.Alterasenha(cliente);
            geraremail(email,senha);
        }
    }
    public String gerasenha(){
        String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","@","#"};

    String senha="";


    for (int x=0; x<10; x++){
        int j = (int) (Math.random()*carct.length);
        senha += carct[j];
    }
    return senha;
    
    }
    public void geraremail(String email2, String senha) throws EmailException{
        SimpleEmail email =  new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSslSmtpPort("465");
        email.setAuthentication("rogerdenardi3@gmail.com", "roger@#$%");
        email.setSSLOnConnect(true);
        email.setFrom("rogerdenardi3@gmail.com", "LivraTec - Conhecimento a um clique");
        email.setSubject("Nova Senha");
        email.setMsg("sua nova senha é: "+senha+"\n Este é um email automático, favor não respondê-lo.");
        email.addTo(email2);
        email.send();
       
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Srecuperarsenha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmailException ex) {
            Logger.getLogger(Srecuperarsenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Srecuperarsenha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmailException ex) {
            Logger.getLogger(Srecuperarsenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.Categoriadao;
import dao.Clientedao;
import dao.Editoradao;
import dao.Produtodao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Cliente;
import model.Editora;
import model.Produto;

/**
 *
 * @author rogerd
 */
@WebServlet(name = "Scontroler", urlPatterns = {"/Scontroler"})
public class Scontroler extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String acao = request.getParameter("acao");
            if (acao.equals("inserircategoria")) {
                Categoria categoria = new Categoria();
                categoria.setNome(request.getParameter("Nome"));
                Categoriadao dao = new Categoriadao();
                dao.Inserircategoria(categoria);
                List lista = dao.Listarcategoria();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Categoria.jsp");
                view.forward(request, response);
            } else if (acao.equals("inserireditora")) {
                Editora editora = new Editora();
                editora.setNome(request.getParameter("Nome"));
                Editoradao dao = new Editoradao();
                dao.Inserireditora(editora);
                List lista = dao.Listareditora();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Editora.jsp");
                view.forward(request, response);
            } else if (acao.equals("inserircliente")) {
                Cliente cliente = new Cliente();
                cliente.setNome(request.getParameter("Nome"));
                cliente.setCpf(request.getParameter("CPF"));
                cliente.setEmail(request.getParameter("Email"));
                cliente.setSenha(request.getParameter("Senha"));
                Clientedao dao = new Clientedao();
                dao.Inserircliente(cliente);
                List lista = dao.Listarcliente();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Cliente.jsp");
                view.forward(request, response);

            } if (acao.equals("consultarcliente")){
                 Clientedao dao = new Clientedao();
                List lista = dao.Listarcliente();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Cliente.jsp");
                view.forward(request, response);
                }else{
                if(acao.equals("excluircliente")){
                    Cliente cliente = new Cliente();
                    cliente.setId(Integer.parseInt(request.getParameter("id")));
                    Clientedao dao = new Clientedao();
                    dao.Excluircliente(cliente);
                    List lista = dao.Listarcliente();
                    request.setAttribute("lista", lista);
                    RequestDispatcher view = request.getRequestDispatcher("Consultar_Cliente.jsp");
                    view.forward(request, response);
                }else{
                    if(acao.equals("alterarcliente")){
                        Cliente cliente = new Cliente();
                        cliente.setId(Integer.parseInt(request.getParameter("id")));
                        Clientedao dao = new Clientedao();
                        List lista = dao.Consultar(cliente);
                        request.setAttribute("lista", lista);
                        RequestDispatcher view = request.getRequestDispatcher("Editar_Cliente.jsp");
                        view.forward(request, response);
                    }else{
                         if(acao.equals("alterandocliente")){
                            Cliente cliente = new Cliente();
                            cliente.setId(Integer.parseInt(request.getParameter("Id")));
                            cliente.setCpf(request.getParameter("CPF"));
                            cliente.setNome(request.getParameter("Nome"));
                            cliente.setEmail(request.getParameter("Email"));
                            cliente.setSenha(request.getParameter("Senha"));
                            cliente.setNivel(request.getParameter("Nivel"));
                            Clientedao dao = new Clientedao();
                            dao.Editarcliente(cliente);
                            List lista = dao.Listarcliente();
                            request.setAttribute("lista", lista);
                            RequestDispatcher view = request.getRequestDispatcher("Consultar_Cliente.jsp");
                            view.forward(request, response);
                    }
                    }
            }
                   
            if (acao.equals("recuperarsenha")) {
                RequestDispatcher view = request.getRequestDispatcher("recuperandosenha.jsp");
                view.forward(request, response);
            } else if (acao.equals("cadastrocliente")) {
                RequestDispatcher view = request.getRequestDispatcher("Cadastro_Cliente.jsp");
                view.forward(request, response);
            } else if (acao.equals("cadastrocategoria")) {
                RequestDispatcher view = request.getRequestDispatcher("Cadastro_Categoria.jsp");
                view.forward(request, response);
            } else if (acao.equals("cadastroeditora")) {
                RequestDispatcher view = request.getRequestDispatcher("Cadastro_Editora.jsp");
                view.forward(request, response);
            } else if (acao.equals("cadastroproduto")) {
                Editoradao dao = new Editoradao();
                List listadeeditora = dao.Listareditora();
                Categoriadao dao2 = new Categoriadao();
                List listadecategoria = dao2.Listarcategoria();
                request.setAttribute("listadeeditora", listadeeditora);
                request.setAttribute("listadecategoria", listadecategoria);
                RequestDispatcher view = request.getRequestDispatcher("Cadastro_Produto.jsp");
                view.forward(request, response);
            } else if (acao.equals("consultarcategoria")) {
                Categoriadao dao = new Categoriadao();
                List lista = dao.Listarcategoria();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Categoria.jsp");
                view.forward(request, response);
            } else if (acao.equals("excluircategoria")) {
                Categoria categoria = new Categoria();
                categoria.setId(Integer.parseInt(request.getParameter("id")));
                Categoriadao dao = new Categoriadao();
                dao.Excluircategoria(categoria);
                List lista = dao.Listarcategoria();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Categoria.jsp");
                view.forward(request, response);
            } else if (acao.equals("alterarcategoria")) {
                Categoria categoria = new Categoria();
                categoria.setId(Integer.parseInt(request.getParameter("id")));
                Categoriadao dao = new Categoriadao();
                List lista = dao.Consultar(categoria);
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Editar_Categoria.jsp");
                view.forward(request, response);
            } else if (acao.equals("editandocategoria")) {
                Categoria categoria = new Categoria();
                categoria.setId(Integer.parseInt(request.getParameter("Id")));
                categoria.setNome(request.getParameter("Nome"));
                Categoriadao dao = new Categoriadao();
                dao.Editarcategoria(categoria);
                List lista = dao.Listarcategoria();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Categoria.jsp");
                view.forward(request, response);
            } else if (acao.equals("alterandocategoria")) {
                Categoria categoria = new Categoria();
                categoria.setId(Integer.parseInt(request.getParameter("Id")));
                categoria.setNome(request.getParameter("Nome"));
                Categoriadao dao = new Categoriadao();
                dao.Editarcategoria(categoria);
                List lista = dao.Listarcategoria();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Categoria.jsp");
                view.forward(request, response);
            } else if (acao.equals("consultareditora")) {
                Editoradao dao = new Editoradao();
                List lista = dao.Listareditora();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Editora.jsp");
                view.forward(request, response);

            } else if (acao.equals("excluireditora")) {
                Editora editora = new Editora();
                editora.setId(Integer.parseInt(request.getParameter("id")));
                Editoradao dao = new Editoradao();
                dao.Excluireditora(editora);
                List lista = dao.Listareditora();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Editora.jsp");
                view.forward(request, response);
            } else if (acao.equals("alterareditora")) {
                Editora editora = new Editora();
                editora.setId(Integer.parseInt(request.getParameter("id")));
                Editoradao dao = new Editoradao();
                List lista = dao.Consultar(editora);
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Editar_Editora.jsp");
                view.forward(request, response);
            } else if (acao.equals("alterandoeditora")) {
                Editora editora = new Editora();
                editora.setId(Integer.parseInt(request.getParameter("Id")));
                editora.setNome(request.getParameter("Nome"));
                Editoradao dao = new Editoradao();
                dao.Editareditora(editora);
                List lista = dao.Listareditora();
                request.setAttribute("lista", lista);
                RequestDispatcher view = request.getRequestDispatcher("Consultar_Editora.jsp");
                view.forward(request, response);
            }
        }
        }
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
            Logger.getLogger(Scontroler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Scontroler.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}



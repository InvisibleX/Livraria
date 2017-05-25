package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\"  href=\"css/Estilo.css\" />\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"Admin.jsp\">Home</a></li>\n");
      out.write("            <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-btn\">Categoria</a>\n");
      out.write("                <div class=\"dropdown-menu\">\n");
      out.write("                    <a href=\"Scontroler?acao=cadastrocategoria\">Cadastrar categoria</a>\n");
      out.write("                    <a href=\"Scontroler?acao=consultarcategoria\">Consultar categoria</a>\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-btn\">Editora</a>\n");
      out.write("                <div class=\"dropdown-menu\">\n");
      out.write("                    <a href=\"Scontroler?acao=cadastroeditora\">Cadastrar editora</a>\n");
      out.write("                    <a href=\"Scontroler?acao=consultareditora\">Consultar editora</a>\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-btn\">Cliente</a>\n");
      out.write("                <div class=\"dropdown-menu\">\n");
      out.write("                    <a href=\"Scontroler?acao=cadastrocliente\">Cadastrar cliente</a>\n");
      out.write("                    <a href=\"Scontroler?acao=consultarcliente\">Consultar cliente</a>\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("            </li>\n");
      out.write("            <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-btn\">Produto</a>\n");
      out.write("                <div class=\"dropdown-menu\">\n");
      out.write("                    <a href=\"Scontroler?acao=cadastroproduto\">Cadastrar produto</a>\n");
      out.write("                    <a href=\"Scontroler?acao=consultarproduto\">Consultar produto</a>\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("            </li>\n");
      out.write("              <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-btn\">Venda</a>\n");
      out.write("                <div class=\"dropdown-menu\">\n");
      out.write("                    <a href=\"Scontroler?acao=consultarvenda\">Consultar venda</a>\n");
      out.write("                    <a href=\"Scontroler?acao=consultaritv\">Consultar itens de venda</a>\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("            </li>\n");
      out.write("             <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-btn\">Relatorio</a>\n");
      out.write("                <div class=\"dropdown-menu\">\n");
      out.write("                    <a href=\"#\">Produto mais vendido</a>\n");
      out.write("                    <a href=\"#\">Cliente que mais comprou</a>\n");
      out.write("                </div>\n");
      out.write("            \n");
      out.write("            </li>\n");
      out.write("            <li id=\"sair\"><a href=\"login.jsp\">Sair</a></li>\n");
      out.write("        </ul>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

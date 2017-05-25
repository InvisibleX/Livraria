package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Cliente;
import java.util.Iterator;
import java.util.List;

public final class Editar_005fCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Admin.jsp", out, false);
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <h3>Alterar Cliente</h3>\n");
      out.write("        <form action=\"Scontroler?acao=alterandocliente\" method=\"POST\">\n");
      out.write("            ");

            List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
            Iterator i = lista.iterator();
            while(i.hasNext()){
                //criar uma instancia do cliente 
                Cliente cliente = (Cliente) i.next();
                
      out.write("\n");
      out.write("            <input type=\"text\" name=\"Id\" value=\"");
      out.print(cliente.getId() );
      out.write("\" hidden>\n");
      out.write("            <br>\n");
      out.write("            Nome: <input type=\"text\" name=\"Nome\" value=\"");
      out.print(cliente.getNome() );
      out.write("\" title= \"exemplo: Banco de Dados\"  pattern=\"[a-z\\s]+$\" maxlength=\"50\"/>\n");
      out.write("            <br>\n");
      out.write("            CPF: <input type=\"text\" name=\"CPF\" value=\"");
      out.print(cliente.getCpf() );
      out.write("\" pattern=\"[0-9]{11}\" title=\"exemplo: 03458965099\" required=\"required\" maxlength=\"11\" />\n");
      out.write("            <br>\n");
      out.write("            Email: <input type=\"text\" name=\"Email\" value=\"");
      out.print(cliente.getEmail() );
      out.write("\" required=\"required\" title=\"exemplo: rogerdenardimachado@hotmail.com\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$\"   />\n");
      out.write("            <br>\n");
      out.write("            Senha: <input type=\"text\" name=\"Senha\" value=\"");
      out.print(cliente.getSenha() );
      out.write("\" required=\"required\" \n");
      out.write("                          title=\"exemplo: roger123A\"  \n");
      out.write("                          pattern=\"(?=^.{8,16}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\"/>\n");
      out.write("            <br>\n");
      out.write("            Nível:\n");
      out.write("            <br>\n");
      out.write("            <input type=\"radio\" value=\"");
      out.print(cliente.getNivel() );
      out.write("\" >\n");
      out.write("                    ");

                        
}
                
      out.write("\n");
      out.write("                <br>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Salvar\" />\n");
      out.write("            <input type=\"submit\" value=\"Cancelar\" />\n");
      out.write("        </form>\n");
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

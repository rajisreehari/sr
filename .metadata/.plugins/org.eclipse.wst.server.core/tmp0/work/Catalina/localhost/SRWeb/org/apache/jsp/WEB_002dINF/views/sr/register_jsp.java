package org.apache.jsp.WEB_002dINF.views.sr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/head.jsp", out, false);
      out.write("\n");
      out.write("    <!-- Full Page Image Header Area -->\n");
      out.write("    <div id=\"top\" class=\"header\">\n");
      out.write("        <div class=\"vert-text\">\n");
      out.write("            <h1>Register</h1>\n");
      out.write("<!-- START FROM -->\n");
      out.write("<br><br>\n");
      out.write("<form class=\"form-horizontal\" action='' method=\"POST\">\n");
      out.write("  <fieldset>\n");
      out.write("    <div class=\"control-group\">\n");
      out.write("      <!-- Username -->\n");
      out.write("      <label class=\"control-label\"  for=\"username\">Username</label>\n");
      out.write("      <div class=\"controls\">\n");
      out.write("        <input type=\"text\" id=\"username\" name=\"username\" placeholder=\"\" class=\"input-xlarge\">\n");
      out.write("        <p class=\"help-block\">Username can contain any letters<br> or numbers, without spaces</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write(" \n");
      out.write("    <div class=\"control-group\">\n");
      out.write("      <!-- E-mail -->\n");
      out.write("      <label class=\"control-label\" for=\"email\">E-mail</label>\n");
      out.write("      <div class=\"controls\">\n");
      out.write("        <input type=\"text\" id=\"email\" name=\"email\" placeholder=\"\" class=\"input-xlarge\">\n");
      out.write("        <p class=\"help-block\">Please provide your E-mail</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write(" \n");
      out.write("    <div class=\"control-group\">\n");
      out.write("      <!-- Password-->\n");
      out.write("      <label class=\"control-label\" for=\"password\">Password</label>\n");
      out.write("      <div class=\"controls\">\n");
      out.write("        <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"\" class=\"input-xlarge\">\n");
      out.write("        <p class=\"help-block\">Password should be at least 4 characters</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write(" \n");
      out.write("    <div class=\"control-group\">\n");
      out.write("      <!-- Password -->\n");
      out.write("      <label class=\"control-label\"  for=\"password_confirm\">Password (Confirm)</label>\n");
      out.write("      <div class=\"controls\">\n");
      out.write("        <input type=\"password\" id=\"password_confirm\" name=\"password_confirm\" placeholder=\"\" class=\"input-xlarge\">\n");
      out.write("        <p class=\"help-block\">Please confirm password</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write(" \n");
      out.write("    <div class=\"control-group\">\n");
      out.write("      <!-- Button -->\n");
      out.write("      <div class=\"controls\">\n");
      out.write("        <button class=\"btn btn-lg btn-primary\">Register</button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </fieldset>\n");
      out.write("\n");
      out.write("<!-- END FORM -->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- /Full Page Image Header Area -->\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/footer.jsp", out, false);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

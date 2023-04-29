package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    if (request.getParameter("submit") != null) {
        String name = request.getParameter("sname");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");

        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Management", "dhruv", "dhruv");
        PreparedStatement ps = con.prepareStatement("insert into DHRUV.RECORD(st_name,course,fee) values(?,?,?)");

        ps.setString(1, name);
        ps.setString(2, course);
        ps.setString(3, fee);
        ps.executeUpdate();

      out.write("\n");
      out.write("<script>\n");
      out.write("    alert(\"Record Added\");\n");
      out.write("</script>\n");

    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Student Registration System CRUD using - JSP</h1>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-4\">\n");
      out.write("                <form method=\"post\" action=\"#\">\n");
      out.write("                    <div align=\"left\" class=\"mt-3\">\n");
      out.write("                        <label class=\"form-label\">Student Name</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Student Name\" name=\"sname\" id=\"sname\" required>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div align=\"left\" class=\"mt-3\">\n");
      out.write("                        <label class=\"form-label\">Course</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"course\" name=\"course\" id=\"course\" required>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div align=\"left\" class=\"mt-3\">\n");
      out.write("                        <label class=\"form-label\">Fee</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Fee\" name=\"fee\" id=\"fee\" required>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div align=\"right\" class=\"mt-3\">\n");
      out.write("                        <input type=\"submit\" value=\"submit\" name=\"submit\" id=\"submit\" class=\"btn btn-info\">\n");
      out.write("                        <input type=\"reset\" value=\"reset\" name=\"reset\" id=\"reset\" class=\"btn btn-warning\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-8\" >\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <table id=\"tbl-student\" class=\"table table-responsive table-bordered mt-3\" cellpadding=\"0\" width=\"100%\" >\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Student Name</th>\n");
      out.write("                                <th>Course</th>\n");
      out.write("                                <th>Fee</th>\n");
      out.write("                                <th>Edit</th>\n");
      out.write("                                <th>Delete</th>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            ");

                                String query = "select * from DHRUV.RECORD";
                                Class.forName("org.apache.derby.jdbc.ClientDriver");
                                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Management", "dhruv", "dhruv");
                                PreparedStatement ps = con.prepareStatement(query);
                                ResultSet rs = ps.executeQuery();

                                while (rs.next()) {
                                    String id = rs.getString("id");

                            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(rs.getString("st_name"));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(rs.getString("course"));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(rs.getString("fee"));
      out.write("</td>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            ");

                                }

                            
      out.write("\n");
      out.write("\n");
      out.write("                        </thead>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
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

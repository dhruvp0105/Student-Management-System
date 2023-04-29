

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>


<%
    if (request.getParameter("submit") != null) {
        String id = request.getParameter("id");
        String name = request.getParameter("sname");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");

        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Management", "dhruv", "dhruv");
        PreparedStatement ps = con.prepareStatement("update DHRUV.RECORD set st_name=?,course=?,fee=? where id=?");

        ps.setString(1, name);
        ps.setString(2, course);
        ps.setString(3, fee);
        ps.setString(4, id);
        ps.executeUpdate();
%>
<script>
    alert("Record Updated");
</script>
<%
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h1>Student Update</h1>
        <div class="row">
            <div class="col-sm-4">
                <form method="post" action="#">

                    <%
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Management", "dhruv", "dhruv");
                        String id = request.getParameter("id");
                        PreparedStatement ps = con.prepareStatement("select * from DHRUV.RECORD where id=?");
                        ps.setString(1, id);
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                    %>

                    <div align="left" class="mt-3">
                        <label class="form-label">Student Name</label>
                        <input type="text" class="form-control" placeholder="Student Name" name="sname" value="<%=rs.getString("st_name")%>" id="sname" required>
                    </div>

                    <div align="left" class="mt-3">
                        <label class="form-label">Course</label>
                        <input type="text" class="form-control" placeholder="course" name="course" value="<%=rs.getString("course")%>" id="course" required>
                    </div>

                    <div align="left" class="mt-3">
                        <label class="form-label">Fee</label>
                        <input type="text" class="form-control" placeholder="Fee" name="fee" value="<%=rs.getString("fee")%>" id="fee" required>
                    </div>
                    <%
                        }
                    %>

                    <div align="right" class="mt-3">
                        <input type="submit" value="submit" name="submit" id="submit" class="btn btn-info">
                        <input type="reset" value="reset" name="reset" id="reset" class="btn btn-warning">
                    </div>

                    <div align="right" class="mt-4">
                        <a href="index.jsp">Click Back</a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

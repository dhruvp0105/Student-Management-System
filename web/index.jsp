

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
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
%>
<script>
    alert("Record Added");
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
        <h1>Student Registration System CRUD using - JSP</h1>
        <div class="row">
            <div class="col-sm-4">
                <form method="post" action="#">
                    <div align="left" class="mt-3">
                        <label class="form-label">Student Name</label>
                        <input type="text" class="form-control" placeholder="Student Name" name="sname" id="sname" required>
                    </div>

                    <div align="left" class="mt-3">
                        <label class="form-label">Course</label>
                        <input type="text" class="form-control" placeholder="course" name="course" id="course" required>
                    </div>

                    <div align="left" class="mt-3">
                        <label class="form-label">Fee</label>
                        <input type="text" class="form-control" placeholder="Fee" name="fee" id="fee" required>
                    </div>

                    <div align="right" class="mt-3">
                        <input type="submit" value="submit" name="submit" id="submit" class="btn btn-info">
                        <input type="reset" value="reset" name="reset" id="reset" class="btn btn-warning">
                    </div>
                </form>
            </div>
            <div class="col-sm-8" >
                <div class="panel-body">
                    <table id="tbl-student" class="table table-responsive table-bordered mt-3" cellpadding="0" width="100%" >
                        <thead>
                            <tr>
                                <th>Student Name</th>
                                <th>Course</th>
                                <th>Fee</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>

                            <%
                                String query = "select * from DHRUV.RECORD";
                                Class.forName("org.apache.derby.jdbc.ClientDriver");
                                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Management", "dhruv", "dhruv");
                                PreparedStatement ps = con.prepareStatement(query);
                                ResultSet rs = ps.executeQuery();

                                while (rs.next()) {
                                    String id = rs.getString("id");

                            %>


                            <tr>
                                <td><%=rs.getString("st_name")%></td>
                                <td><%=rs.getString("course")%></td>
                                <td><%=rs.getString("fee")%></td>
                                <td><a href="update.jsp?id=<%=id%>">Edit</a></td>
                                <td><a href="delete.jsp?id=<%=id%>">Delete</a></td>
                            </tr>

                            <%
                                }

                            %>

                        </thead>
                    </table>
                </div>
            </div>
        </div>

    </body>
</html>

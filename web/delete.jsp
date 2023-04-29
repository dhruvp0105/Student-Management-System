<%@page import="java.sql.*"%>

<%
    
        String id=request.getParameter("id");
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Student_Management", "dhruv", "dhruv");
        PreparedStatement ps = con.prepareStatement("delete from DHRUV.RECORD where id = ?");
        ps.setString(1,id);
        ps.executeUpdate();
%>
<script>
    alert("Record Deleted");
</script>


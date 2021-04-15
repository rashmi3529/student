<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<%
String name=request.getParameter("name");
String qr="delete from product where name=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,name);
ps.executeUpdate();
response.sendRedirect("Show.jsp");
%>

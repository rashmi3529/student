<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<%
String name=request.getParameter("name");
String p=request.getParameter("price");
int price=Integer.parseInt(p);
String cat=request.getParameter("cat");
String com=request.getParameter("com");
String qr="update product set price=?,cat=?,com=? where name=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(4,name);
ps.setInt(1,price);
ps.setString(2,cat);
ps.setString(3,com);
ps.executeUpdate();
response.sendRedirect("Show.jsp");
%>

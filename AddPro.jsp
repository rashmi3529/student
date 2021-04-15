<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<%
String name=request.getParameter("name");
String p=request.getParameter("price");
int price=Integer.parseInt(p);
String cat=request.getParameter("cat");
String com=request.getParameter("com");

String qr="insert into product values(?,?,?,?)";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,name);
ps.setInt(2,price);
ps.setString(3,cat);
ps.setString(4,com);
int i=ps.executeUpdate();
if(i>0)
{
	out.println("added");
	
}
else
{
	out.println("not added");
}
con.close();
%>
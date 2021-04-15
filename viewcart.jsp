<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<a href="Logout">Logout</a>
<%!int total=0; %>
<%
String email=request.getParameter("email");
String qr="select * from cart where email=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,email);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
	do
	{
		String name=rs.getString("name");
		int price=rs.getInt("price");
		String cat=rs.getString("cat");
		String com=rs.getString("com");
		total=total+price;
		%>
		<center><div style="height: 120px;width: 30%;background-color: pink">
		NAME: <%=name %><br>
		PRICE: <%=price %><br>
		CATEGORY: <%=cat %><br>
		COMPANY: <%=com %><br>
		
		</div></center><hr>
		
	<% 
		
	}while(rs.next());
}
else
{
	out.println("no record found");
}
con.close();
%>
<center><div style="height: 120px;width: 30%;background-color: pink">
<h3 align="center">TOTAL AMOUNT IS : <%=total %></h3>
<a href="https://www.paypal.com/in/signin">CHECK OUT</a>
</div></center>

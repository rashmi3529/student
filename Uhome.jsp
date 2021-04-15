<%@page errorPage="error.jsp"  %>
<%@include file="db.jsp" %>
<h1>welcome to user home</h1>
<% 
String email=(String) session.getAttribute("id");//downcasting
out.println("welcome "+email);
%> 
<a href="logout">LOGOUT</a>
<a href="viewcart.jsp?email=<%= email %>">VIEW CART</a>
<%
String qr="select * from product";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(qr);
if(rs.next())
{
	do
	{
		String name=rs.getString("name");
		int price=rs.getInt("price");
		String cat=rs.getString("cat");
		String com=rs.getString("com");
		%>
		<center><div style="height: 120px;width: 30%background-color: pink">
		NAME: <%=name %><br>
		PRICE: <%=price %><br>
		CATEGORY: <%=cat %><br>
		COMPANY: <%=com %><br>
		<a href="https://www.paypal.com/in/signin">BUY NOW></a>
		<a href="addcart.jsp?name=<%=name %>&price=<%=price %>&cat=<%=cat %>&com=<%=com %>&email=<%=email %>">ADD TO CART</a>
		</div></center><hr>
		<% 
	}while(rs.next());
}
else{
out.println("no record found");
}
con.close();
%>
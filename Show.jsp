<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<table border="1" align="centre">
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
<tr>
<td><%=name %></td>
<td><%=price %></td>
<td><%=cat %></td>
<td><%=com %></td>
<td><a href=Delete.jsp?name=<%=name%> >Delete></a></td>
<td><a href=UpdatePro.jsp?name=<%=name%>&price=<%=price%> &cat=<%=cat%>&com=<%=com%>>Update></a></td>

</tr>
<% 
}while(rs.next());
}
else
{
	out.println("no record found");
}
con.close();
%>
</table>
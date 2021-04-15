<%
String name=request.getParameter("name");
String price=request.getParameter("price");

String cat=request.getParameter("cat");
String com=request.getParameter("com");
%>
<form action="Update.jsp">
<%=name %>
<input type=hidden name=name value=<%=name %> >
<pre>
PRICE<input type=text name=price value=<%=price %> >
CATEGORY<input type=text name=cat value=<%=cat %> >
COMPANY<input type=text name=com value=<%=com %> >
<input type=submit value="update" >
</pre>
</form>
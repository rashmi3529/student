<%
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");
if(id.equals("admin")&&pwd.equals("12345"))
{
	response.sendRedirect("adminhome.html");
	
}
else
{ 
out.println("invalid id and password");
}
%>
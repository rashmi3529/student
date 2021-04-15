<%@page errorPage="error.jsp" %>
<%
String n1=request.getParameter("n1");
String n2=request.getParameter("n2");
int a=Integer.parseInt(n1);
int b=Integer.parseInt(n2);
String ch=request.getParameter("ch");
switch(ch)
{
case "ADD":
    out.println("add is "+(a+b));
    break;
case "SUB":
    out.println("sub is "+(a-b));
    break;
 case "MUL":
    out.println("mul is "+(a*b));
    break;
 case "DIV":
    out.println("div is "+(a/b));
    break;
}
%>


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Alogin
 */
@WebServlet("/Alogin")
public class Alogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		if(id.equals("admin")&&pwd.equals("12345"))
		{
			//response.sendRedirect("AdminHome");
			RequestDispatcher rd=request.getRequestDispatcher("adminhome.html");
			rd.forward(request,response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("admin.html");
			rd.include(request,response);
			out.println("<script>window.alert('invalid id and password');</script>");
		}

	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

/**
 * Servlet implementation class Ulogin
 */
@WebServlet("/Ulogin")
public class Ulogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Ulogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param <RequestDispatcher>
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected <RequestDispatcher> void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
			String qr="select * from user where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(qr);
	        ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				HTTPException session=request.getSession();
			 session.setAttribute("id", email);//upcasting
				response.sendRedirect("Uhome.jsp");
			}	
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("user.html");
				rd.include(request, response);
				out.println("script>window.alert('Invalid id and password');</script>");
			}
			con.close();
		} catch (Exception e) {
			
     out.println(e);
		}
	}

}

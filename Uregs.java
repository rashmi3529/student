

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Uregs
 */
@WebServlet("/Uregs")
public class Uregs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uregs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
			String qr="insert into user values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, name);
			
			ps.setString(2, email);
			ps.setString(3, pwd);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("user.html");
				rd.include(request,response);
				out.println("successfully registered");
				
			}	
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("uregs.html");
				rd.include(request, response);
				out.println("registered failed");
			}
			con.close();
		} catch (Exception e) {
			
     out.println(e);
		}
	}

}

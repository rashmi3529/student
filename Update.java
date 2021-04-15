

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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		String p=request.getParameter("price");
		int price=Integer.parseInt(p);
		String cat=request.getParameter("cat");
		String com=request.getParameter("com");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
			String qr="update product set price=?,cat=?,com=? where name=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(4, name);
			ps.setInt(1, price);
			ps.setString(2, cat);
			ps.setString(3, com);
			int i=ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("show");
			if(i>0)
			{
				rd.include(request,response);
				out.println("updated");
				
			}	
			else
			{
				rd.include(request, response);
				out.println("not updated");
			}
			con.close();
		} catch (Exception e) {
			
     out.println(e);
		}
	}
}



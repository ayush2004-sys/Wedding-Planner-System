package cscorner;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class signInServlet
 */
public class signInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/santtun1","root","3745kris");
			
			String n = request.getParameter("username");
			String p = request.getParameter("password");
			
//			System.out.println("Error during Connection...");
			System.out.println("Connection Happen");
			
			PreparedStatement ps = con.prepareStatement("select username from user where username=? and password = ?");
			
			ps.setString(1, n);
			ps.setString(2,p);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("Religion.html");
				rd.forward(request, response);
			}
			else {
//				RequestDispatcher rd = request.getRequestDispatcher("LogIn.jsp");
//				rd.forward(request, response);
				
//				out.println("<font color=red size = 18 > Login Failed!! ");
//				out.println("<a href = LogIn.jsp> Try AGAIN!!</a>");
//				response.sendRedirect("LogIn.jsp?error=1");

			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
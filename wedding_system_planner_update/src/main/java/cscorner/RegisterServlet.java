package cscorner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connection.DBUtil;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
  

        try {
            // Establish database connection
            Connection connection = DBUtil.getConnection();

            // SQL statement to insert user data
            String insertQuery = "INSERT INTO User (Username, Email, Password) VALUES (?, ?, ?)";

            // Create prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
          
            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Close the resources
            preparedStatement.close();
            connection.close();

            // Check if user insertion was successful
            if (rowsAffected > 0) {
            	
                response.sendRedirect("signin.jsp?"); // Redirect to login page after successful registration
            } else {
                // Handle registration failure
                // You can redirect to an error page or show an error message
            	
                response.sendRedirect("register.jsp?error=1");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            // You can redirect to an error page or show an error message
            response.sendRedirect("register.jsp?error=2");
        }
	}

}

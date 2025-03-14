package cscorner;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connection.DBUtil;

/**
 * Servlet implementation class HinduServlet
 */
public class ChristianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChristianServlet() {
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
        String contactNumber= request.getParameter("contactNumber");
        String location = request.getParameter("location");
        String weddingDate = request.getParameter("weddingDate");
        String totalBudget = request.getParameter("totalBudget");
        
  

        try {
            // Establish database connection
            Connection connection = DBUtil.getConnection();

            // SQL statement to insert user data
            String insertQuery3 = "INSERT INTO christian(firstName, lastName, contactNumber, location, weddingDate, totalBudget) VALUES (?, ?, ?, ?, ?, ?)";



            // Create prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery3);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, contactNumber);
            preparedStatement.setString(4, location);
            preparedStatement.setString(5, weddingDate);
            preparedStatement.setString(6, totalBudget);
          
            // Execute the query
            int rowsAffected3 = preparedStatement.executeUpdate();

            // Close the resources
//            preparedStatement.close();
//            connection.close();

            // Check if user insertion was successful
            if (rowsAffected3> 0) {
            	
                response.sendRedirect("sucessfully.html"); // Redirect to login page after successful registration
            } else {
                // Handle registration failure
                // You can redirect to an error page or show an error message
            	
                response.sendRedirect("Christian.jsp?error=1");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            // You can redirect to an error page or show an error message
            response.sendRedirect("Christian.jsp?error=2");
        }
	}

}

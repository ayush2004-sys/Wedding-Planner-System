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

public class HinduServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HinduServlet() {
        super();
    }

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
            String insertQuery1 = "INSERT INTO hindu(firstName, lastName, contactNumber, location, weddingDate, totalBudget) VALUES (?, ?, ?, ?, ?, ?)";

            // Create prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery1);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, contactNumber);
            preparedStatement.setString(4, location);
            preparedStatement.setString(5, weddingDate);
            preparedStatement.setString(6, totalBudget);

            // Execute the query
            int rowsAffected1 = preparedStatement.executeUpdate();

            // Close the resources
//            preparedStatement.close();
//            connection.close();

            // Check if user insertion was successful
            if (rowsAffected1 > 0) {
                response.sendRedirect("sucessfully.html"); // Corrected URL
            } else {
                // Handle registration failure
                response.sendRedirect("Hindu.jsp?error=1");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            response.sendRedirect("Hindu.jsp?error=2");
        }
    }
}

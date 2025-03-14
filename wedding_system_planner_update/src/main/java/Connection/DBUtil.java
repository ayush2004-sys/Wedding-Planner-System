package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // Corrected database URL without unnecessary spaces
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/santtun1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "3745kris";

    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Handle the exception appropriately, e.g., log it or throw a runtime exception
            // Printing the stack trace is not the best practice, but it's fine for debugging
            e.printStackTrace();
            throw new RuntimeException("Failed to load MySQL JDBC driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            // Establish database connection
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            // Handle the exception appropriately, e.g., log it or throw a runtime exception
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbConnection {

    // Database credentials
    private static final String URL = "jdbc:mariadb://localhost:3306/mysql";
    private static final String USER = "root";  
    private static final String PASSWORD = "kk205056";  

    private static Connection connection;

    // Method to get the connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connected to the database successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Database connection failed!");
            }
        }
        return connection;
    }

    // Method to prepare SQL statement
    public static PreparedStatement prepareStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}

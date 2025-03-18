package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DatabaseTest {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:h2:tcp://localhost/~/test"; 
        String username = "sa"; 
        String password = ""; 

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Successfully connected to H2 database!");
            connection.close();
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }


}

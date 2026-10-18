//1. Create a program to connect Java with database and display database connection status. 

import java.sql.Connection;
import java.sql.DriverManager;

public class assignment20_DatabaseConnection {

    public static void main(String[] args) {

        // Database URL, username and password
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try {
            // Establish database connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Check connection status
            if (con != null) {
                System.out.println("Database Connection Successful!");
                System.out.println("Connection Status: Connected");
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            System.out.println("Connection Status: Not Connected");
            System.out.println("Error: " + e.getMessage());
        }
    }
}

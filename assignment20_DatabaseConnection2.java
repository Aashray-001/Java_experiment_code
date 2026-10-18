// . Create a Java program to connect with a database and display the connection status. 
// After successful connection, show a message indicating that the Student database is
// connected successfully. 

import java.sql.Connection;
import java.sql.DriverManager;

public class assignment20_DatabaseConnection2 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connection Successful!");
            System.out.println("Student database is connected successfully.");

            con.close();

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            System.out.println("Connection Status: Not Connected");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
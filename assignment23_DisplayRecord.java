import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class assignment23_DisplayRecord {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Hospital";
        String username = "root";
        String password = "root";

        try {
            // Establish database connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");
            System.out.println("\n===== HOSPITAL STAFF RECORDS =====");

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute query
            String query = "SELECT * FROM staff";
            ResultSet rs = stmt.executeQuery(query);

            // Display records one by one
            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Login ID: " + rs.getString("login_id"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println("Role: " + rs.getString("role"));
                System.out.println("----------------------------");
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
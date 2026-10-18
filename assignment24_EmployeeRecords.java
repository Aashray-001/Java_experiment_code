import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class assignment24_EmployeeRecords {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Company";
        String username = "root";
        String password = "root";

        try {
            // Connect to database
            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.println("Database Connected Successfully!");
            System.out.println("\n===== EMPLOYEE RECORDS =====");

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute SQL query
            String query = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(query);

            // Display records one by one
            while (rs.next()) {

                System.out.println("Employee ID: "
                        + rs.getInt("employee_id"));

                System.out.println("Name: "
                        + rs.getString("name"));

                System.out.println("Department: "
                        + rs.getString("department"));

                System.out.println("Salary: "
                        + rs.getDouble("salary"));

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
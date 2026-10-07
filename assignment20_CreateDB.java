import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class assignment20_CreateDB {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "root"; // your mysql password

        try {

            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to MySQL Database!");

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            // Display Data
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                System.out.println(id + " " + name + " " + marks);
            }

            // Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

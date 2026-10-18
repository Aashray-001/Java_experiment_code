import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class assignment21_login {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Student";
        String username = "root";
        String password = "root";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, user);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
                System.out.println("Welcome, " + user);
            } else {
                System.out.println("Invalid Username or Password!");
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
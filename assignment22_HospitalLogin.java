import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class assignment22_HospitalLogin {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Hospital";
        String dbUsername = "root";
        String dbPassword = "root";

        Scanner sc = new Scanner(System.in);

        System.out.println("===== HOSPITAL STAFF LOGIN =====");

        System.out.print("Enter Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String query = "SELECT role FROM staff WHERE login_id = ? AND password = ?";

        try {
            Connection con = DriverManager.getConnection(
                    url, dbUsername, dbPassword
            );

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, loginId);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                String role = rs.getString("role");

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println("Login Successful!");
                    System.out.println("Access Granted: Doctor Dashboard");
                    System.out.println("Welcome, Doctor!");

                } else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println("Login Successful!");
                    System.out.println("Access Granted: Nurse Dashboard");
                    System.out.println("Welcome, Nurse!");

                } else {
                    System.out.println("Login Successful!");
                    System.out.println("Access Granted: Staff Dashboard");
                }

            } else {
                System.out.println("Login Failed!");
                System.out.println("Access Denied: Invalid Login ID or Password.");
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
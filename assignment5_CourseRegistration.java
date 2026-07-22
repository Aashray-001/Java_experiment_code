import java.util.ArrayList;
import java.util.Scanner;

public class assignment5_CourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> courses = new ArrayList<>();

        while (true) {
            System.out.println("\n===== COURSE REGISTRATION =====");
            System.out.println("1. Register Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter course name: ");
                String course = sc.nextLine();
                courses.add(course);
                System.out.println("Course registered successfully.");

            } else if (choice == 2) {
                if (courses.isEmpty()) {
                    System.out.println("No registered courses.");
                } else {
                    System.out.print("Enter course number to remove: ");
                    int index = sc.nextInt();

                    if (index >= 1 && index <= courses.size()) {
                        courses.remove(index - 1);
                        System.out.println("Course removed successfully.");
                    } else {
                        System.out.println("Invalid course number.");
                    }
                }

            } else if (choice == 3) {
                if (courses.isEmpty()) {
                    System.out.println("No registered courses.");
                } else {
                    StringBuffer sb = new StringBuffer();
                    sb.append("\n----- REGISTERED COURSES -----\n");

                    for (int i = 0; i < courses.size(); i++) {
                        sb.append(i + 1)
                        .append(". ")
                        .append(courses.get(i))
                        .append("\n");
                    }

                    System.out.println(sb);
                }

            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
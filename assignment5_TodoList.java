import java.util.ArrayList;
import java.util.Scanner;

public class assignment5_TodoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter task: ");
                String task = sc.nextLine();
                tasks.add(task);
                System.out.println("Task added successfully.");

            } else if (choice == 2) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                } else {
                    System.out.print("Enter task number to remove: ");
                    int index = sc.nextInt();

                    if (index >= 1 && index <= tasks.size()) {
                        tasks.remove(index - 1);
                        System.out.println("Task removed successfully.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                }

            } else if (choice == 3) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                } else {
                    StringBuffer sb = new StringBuffer();
                    sb.append("\n----- TO-DO TASKS -----\n");

                    for (int i = 0; i < tasks.size(); i++) {
                        sb.append(i + 1)
                        .append(". ")
                        .append(tasks.get(i))
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
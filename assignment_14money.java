import java.util.Scanner;

public class assignment_14money {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            int pin = 1234;
            int amt = 10000;

            System.out.println("Enter amount to withdraw:");
            int money = sc.nextInt();

            if (money <= 0) {
                System.out.println("Invalid amount");
            }
            else {
                System.out.println("Enter your pin:");
                int pass = sc.nextInt();

                if (pass == pin) {
                    amt = amt - money;
                    System.out.println("Withdrawal successful");
                    System.out.println("Remaining balance = " + amt);
                }
                else {
                    System.out.println("Wrong Pin");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        sc.close();
    }
}
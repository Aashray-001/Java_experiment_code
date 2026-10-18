class BankAccount {

    private int balance = 1000;

    // Deposit operation
    synchronized void deposit(int amount) {
        balance = balance + amount;

        System.out.println(
            "Deposit: Rs." + amount +
            " | Balance: Rs." + balance
        );
    }

    // Withdrawal operation
    synchronized void withdraw(int amount) {

        if (balance >= amount) {
            balance = balance - amount;

            System.out.println(
                "Withdrawal: Rs." + amount +
                " | Balance: Rs." + balance
            );
        } else {
            System.out.println(
                "Withdrawal: Rs." + amount +
                " | Insufficient Balance"
            );
        }
    }
}

// Deposit Thread
class DepositThread extends Thread {

    BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            account.deposit(500);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Withdrawal Thread
class WithdrawalThread extends Thread {

    BankAccount account;

    WithdrawalThread(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            account.withdraw(300);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Main class
public class assignment25_BankTransactions {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        DepositThread deposit =
            new DepositThread(account);

        WithdrawalThread withdrawal =
            new WithdrawalThread(account);

        // Start both threads
        deposit.start();
        withdrawal.start();
    }
}
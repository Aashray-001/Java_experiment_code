class BankAccount {

    final int accountNumber;   // Final variable
    String accountHolder;
    double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void display() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
    }

    public static void main(String[] args) {

        BankAccount b = new BankAccount(1001, "Aashray", 25000);

        b.display();

        // b.accountNumber = 2002; // Error: Cannot change final variable
    }
}
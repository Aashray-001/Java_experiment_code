//. Method Overriding:
//A banking system has a base class BankAccount that provides a method to calculate the interest rate.
// Different types of bank accounts (e.g., SavingsAccount, CurrentAccount) have different interest rates,
// so they should override the method.

// Method Overriding Example

class BankAccount {

    void calculateInterest() {
        System.out.println("Interest Rate: 4%");
    }
}

class SavingsAccount extends BankAccount {

    void calculateInterest() {
        System.out.println("Savings Account Interest Rate: 6%");
    }
}

class CurrentAccount extends BankAccount {

    void calculateInterest() {
        System.out.println("Current Account Interest Rate: 2%");
    }
}

public class Day3_Bank {
    public static void main(String[] args) {

        BankAccount b1 = new SavingsAccount();
        BankAccount b2 = new CurrentAccount();

        b1.calculateInterest();
        b2.calculateInterest();
    }
}
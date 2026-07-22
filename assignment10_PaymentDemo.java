abstract class Payment {

    abstract void makePayment(double amount);
}

class CreditCard extends Payment {

    void makePayment(double amount) {
        System.out.println("Payment made using Credit Card.");
        System.out.println("Amount: ₹" + amount);
    }
}

class UPI extends Payment {

    void makePayment(double amount) {
        System.out.println("Payment made using UPI.");
        System.out.println("Amount: ₹" + amount);
    }
}

public class assignment10_PaymentDemo {
    public static void main(String[] args) {

        Payment p1 = new CreditCard();
        p1.makePayment(2500);

        System.out.println();

        Payment p2 = new UPI();
        p2.makePayment(1200);
    }
}
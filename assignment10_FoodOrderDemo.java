abstract class FoodOrder {

    double amount;

    FoodOrder(double amount) {
        this.amount = amount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {

    DineInOrder(double amount) {
        super(amount);
    }

    void calculateBill() {
        double total = amount + (amount * 0.10); // 10% service charge
        System.out.println("Dine-In Order");
        System.out.println("Food Amount : ₹" + amount);
        System.out.println("Total Bill  : ₹" + total);
    }
}

class TakeAwayOrder extends FoodOrder {

    TakeAwayOrder(double amount) {
        super(amount);
    }

    void calculateBill() {
        double total = amount + 30; // ₹30 packing charge
        System.out.println("Take Away Order");
        System.out.println("Food Amount : ₹" + amount);
        System.out.println("Total Bill  : ₹" + total);
    }
}

public class assignment10_FoodOrderDemo {
    public static void main(String[] args) {

        FoodOrder order1 = new DineInOrder(500);
        order1.calculateBill();

        System.out.println();

        FoodOrder order2 = new TakeAwayOrder(500);
        order2.calculateBill();
    }
}
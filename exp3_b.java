//Develop a Restaurant Billing Application where overloaded methods calculate bills for
//dine-in, takeaway, and delivery orders, while static variables track total orders.

class Restaurant {

    // Static variable to track total orders
    static int totalOrders = 0;

    // Dine-in bill
    double bill(double amount) {
        totalOrders++;
        return amount;
    }

    // Takeaway bill (with packing charge)
    double bill(double amount, double packingCharge) {
        totalOrders++;
        return amount + packingCharge;
    }

    // Delivery bill (with packing and delivery charges)
    double bill(double amount, double packingCharge, double deliveryCharge) {
        totalOrders++;
        return amount + packingCharge + deliveryCharge;
    }
}

public class exp3_b {
    public static void main(String[] args) {

        Restaurant r = new Restaurant();

        System.out.println("Dine-in Bill = " + r.bill(500));
        System.out.println("Takeaway Bill = " + r.bill(500, 20));
        System.out.println("Delivery Bill = " + r.bill(500, 20, 50));

        System.out.println("Total Orders = " + Restaurant.totalOrders);
    }
}
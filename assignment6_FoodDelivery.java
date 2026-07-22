class FoodDelivery {

    String customer = "Rahul";
    String food = "Pizza";
    int quantity = 2;

    // Inner Class
    class OrderDetails {
        void displayOrder() {
            System.out.println("Customer Name : " + customer);
            System.out.println("Food Item     : " + food);
            System.out.println("Quantity      : " + quantity);
        }
    }

    // Interface for Anonymous Class
    interface DeliveryStatus {
        void status();
    }

    public static void main(String[] args) {

        FoodDelivery fd = new FoodDelivery();

        // Inner class object
        OrderDetails order = fd.new OrderDetails();
        order.displayOrder();

        // Anonymous class
        DeliveryStatus ds = new DeliveryStatus() {
            public void status() {
                System.out.println("Order is out for delivery.");
            }
        };

        ds.status();
    }
}
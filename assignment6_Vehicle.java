class Vehicle {

    String name = "Car";
    String model = "Toyota";
    int year = 2024;

    // Inner Class
    class VehicleDetails {
        void display() {
            System.out.println("Vehicle Name : " + name);
            System.out.println("Model        : " + model);
            System.out.println("Year         : " + year);
        }
    }

    // Interface for Anonymous Class
    interface Action {
        void perform();
    }

    public static void main(String[] args) {

        Vehicle v = new Vehicle();

        // Inner class object
        VehicleDetails details = v.new VehicleDetails();
        details.display();

        // Anonymous class
        Action a = new Action() {
            public void perform() {
                System.out.println("Vehicle is running.");
            }
        };

        a.perform();
    }
}
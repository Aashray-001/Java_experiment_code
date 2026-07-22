class Vehicle {
    String vehicleNo;
    String ownerName;

    Vehicle(String vehicleNo, String ownerName) {
        this.vehicleNo = vehicleNo;
        this.ownerName = ownerName;
    }

    void displayVehicle() {
        System.out.println("Vehicle Number : " + vehicleNo);
        System.out.println("Owner Name     : " + ownerName);
    }
}

class CarInsurance extends Vehicle {
    double premium;

    CarInsurance(String vehicleNo, String ownerName, double premium) {
        super(vehicleNo, ownerName);   // Calling parent constructor
        this.premium = premium;
    }

    void displayInsurance() {
        super.displayVehicle();        // Calling parent method
        System.out.println("Premium Amount : " + premium);
    }
}

public class assignment8_InsuranceDemo {
    public static void main(String[] args) {

        CarInsurance car = new CarInsurance("MH12AB1234", "Amit", 15000);

        car.displayInsurance();
    }
}
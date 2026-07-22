interface Product {
    void displayDetails();
}

class ProductInfo {
    int id;
    String name;
    double price;

    ProductInfo(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Electronic extends ProductInfo implements Product {

    Electronic(int id, String name, double price) {
        super(id, name, price);
    }

    public void displayDetails() {
        System.out.println("\nElectronic Product");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}

class Clothing extends ProductInfo implements Product {

    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public void displayDetails() {
        System.out.println("\nClothing Product");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}

class Grocery extends ProductInfo implements Product {

    Grocery(int id, String name, double price) {
        super(id, name, price);
    }

    public void displayDetails() {
        System.out.println("\nGrocery Product");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}

public class assignment7_EcommerceDemo {
    public static void main(String[] args) {

        Electronic e = new Electronic(101, "Laptop", 65000);
        Clothing c = new Clothing(102, "T-Shirt", 799);
        Grocery g = new Grocery(103, "Rice Bag", 1200);

        e.displayDetails();
        c.displayDetails();
        g.displayDetails();
    }
}
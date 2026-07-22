//2. Develop a Mobile Phone Inventory System using different constructors to initialize mobile
//details and create duplicate object records.
class Mobile{
    String brand;
    int price;

Mobile(){
    brand="Apple";
    price=60000;
}

Mobile(String b,int p){
    brand=b;
    price=p;
}

Mobile(Mobile m){
    brand=m.brand;
    price=m.price;
}

void display(){
    System.out.println("Brand Name="+brand+"    Price="+price);
}

}

public class exp2_b {
    public static void main(String[] args) {
        Mobile mob1=new Mobile("Oneplus",50000);
        mob1.display();
        Mobile mob2=new Mobile();
        mob2.display();
        System.out.println("Duplicate Object Record:");
        Mobile mob3=new Mobile(mob1);
        mob3.display();
    }
}
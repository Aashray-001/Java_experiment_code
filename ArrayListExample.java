import java.util.ArrayList;

public class ArrayListExample{
    public static void main(String[] args){
        ArrayList<String> fruits= new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Jackfruit");

        System.out.println("Fruits:"+fruits);
        fruits.remove("Banana");
        System.out.println("After removing Banana: "+fruits);

        System.out.println("Size: "+fruits.size());
        System.out.println("Contains Apple?"+fruits.contains("Apple"));
    }
}
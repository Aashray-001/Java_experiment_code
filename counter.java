class Counter{
    static int count =0; //Static Variable

    Counter(){
        count++; //Increment static variable
        System.out.println("Object Created. Current Count: "+count);
    }
}

public class counter{
    public static void main(String[] args){
        Counter obj1=new Counter();
        Counter obj2=new Counter();
        Counter obj3=new Counter();

        System.out.println("Final Count: "+Counter.count); //Access using class name
    }
}
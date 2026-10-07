/*Create an interface Switchable with a method turnOn(). Implement the interface in
Light and Fan classes to display the device status. */
interface Switchable {
    void turnOn();
}

class Light implements Switchable{
    public void turnOn(){
        System.out.println("Device On");
    }
}

class Fan implements Switchable{
    public void turnOn(){
        System.out.println("Device on");
    }
}

public class assignment11_Printable{
    public static void main(String[] args){
        Light l=new Light();
        l.turnOn();
        Fan f=new Fan();
        f.turnOn();
    }
}
abstract class Shape{
    abstract void draw();

    void message(){
        System.out.println("This is a shape");
    }
}

class Circle extends Shape{
    void draw() {
        System.out.println("Drawing a circle");
    }
}

public class day3_AbstractExample{
    public static void main(String[] args){
        Shape s=new Circle();
        s.draw();
        s.message();
    }
}
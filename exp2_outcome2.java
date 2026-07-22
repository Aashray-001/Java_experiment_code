class student{
    String name;
    int age;

student(){
    name="Aashray Kayastha";
    age=18;
}

void display(){
    System.out.println("Name:"+name+",Age:"+age);
}
}

public class exp2_outcome2{
    public static void main(String[] args) {
        student student1=new student();
        student1.display();
    }
}
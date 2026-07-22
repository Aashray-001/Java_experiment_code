class Student{
    String name;
    int age;

Student(String n,int a){
    name=n;
    age=a;
}

void display(){
    System.out.println("Name:"+name+",Age:"+age);

}
}

public class exp2_outcome1{
    public static void main(String[] args) {
        Student student1=new Student("Aashray",005);
        student1.display();
    }
}
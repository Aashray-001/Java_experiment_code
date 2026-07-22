class Student {
    String name;
    int roll;

    Student() {
        name = "Unknown";
        roll = 0;
    }

    Student(String n, int r) {
        name = n;
        roll = r;
    }

    void display() {
        System.out.println("Name = " + name + ", Roll No = " + roll);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Aashray", 20);
        student1.display();

        Student student2 = new Student();
        student2.display();
    }
}
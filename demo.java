class Student {
    String name;
    int age;

    // Parameterized Constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    // Copy Constructor
    Student(Student s) {
        name = s.name;
        age = s.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class demo {
    public static void main(String[] args) {
        Student student1 = new Student("David", 20);
        Student student2 = new Student(student1);

        student1.display();
        student2.display();
    }
}
class Employee {
    int empId;
    String empName;
    double salary;

    Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    void displayEmployee() {
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Salary        : " + salary);
    }
}

class Manager extends Employee {
    String department;

    Manager(int empId, String empName, double salary, String department) {
        super(empId, empName, salary);   // Calling parent constructor
        this.department = department;
    }

    void displayManager() {
        super.displayEmployee();         // Calling parent method
        System.out.println("Department    : " + department);
    }
}

public class assignment8_EmployeeDemo {
    public static void main(String[] args) {

        Manager m = new Manager(101, "Aashray", 50000, "Sales");

        m.displayManager();
    }
}
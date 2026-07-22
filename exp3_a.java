class Calculator {

    static int count = 0;

    // Overloaded method for integers
    int add(int a, int b) {
        count++;
        return a + b;
    }

    // Overloaded method for decimals
    double add(double a, double b) {
        count++;
        return a + b;
    }
}

public class exp3_a {
    public static void main(String[] args) {

        Calculator cal = new Calculator();

        System.out.println("Integer Addition = " + cal.add(10, 20));
        System.out.println("Decimal Addition = " + cal.add(10.5, 20.5));

        System.out.println("Total Calculations = " + Calculator.count);
    }
}
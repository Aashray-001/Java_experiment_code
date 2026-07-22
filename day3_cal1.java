//Method Overloading

//A software company is developing a calculator application that should support addition of different types of inputs:

//Two integers

//Two floating-point numbers

//Three integer


class calculator{

    int add(int a,int b){
        return a+b;
    }

    double add(double a,double b){
        return a+b;
    }

    int add(int a,int b,int c){
        return a+b+c;
    }
}

public class day3_cal1{
    public static void main(String[] args)
    {
        calculator cal=new calculator();
        System.out.println("Sum of two numbers="+cal.add(2,3));
        System.out.println("Sum of two decimals="+cal.add(1.5,3.5));
        System.out.println("Sum of three numbers="+cal.add(5,3,2));
    }
}
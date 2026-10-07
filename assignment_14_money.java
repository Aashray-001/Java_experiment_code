//1. Create an ATM program handling invalid withdrawal amount using try-catch

import java.util.Scanner;
import java.io.IOException;

public class assignment_14_money{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            int pin=1234;
            int amt=10000;

            System.out.println("Enter amount to withdraw=");
            int money=sc.nextInt();
            if(money<=0){
                System.out.println("Invalid amount");
            }
            else{
            System.out.println("Enter you pin=");
            int pass=sc.nextInt();
            
            if(pass==pin){
                amt=amt-money;
                System.out.println("Withdrawal successfull");
                System.out.println("Remaining balance="+amt);
            }
            else{
                System.out.println("Wrong Pin");
            }
            }
    }
    catch(IOException e){
        System.out.println("Error");
        e.printStackTrace();
    }
}
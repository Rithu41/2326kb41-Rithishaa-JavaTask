package tasks.java;

import java.util.Scanner;
//Simple interest//
public class Task2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time in years: ");
        double time = sc.nextDouble();

        double interest = (principal * rate * time) / 100;
        System.out.println("Simple Interest = " + interest);
    }
}
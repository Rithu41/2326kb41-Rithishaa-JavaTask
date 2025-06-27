package Hometask.java;

import java.util.Scanner;

public class StudentGrade 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks for Subject 1: ");
        int mark1 = sc.nextInt();
        System.out.print("Enter marks for Subject 2: ");
        int mark2 = sc.nextInt();
        System.out.print("Enter marks for Subject 3: ");
        int mark3 = sc.nextInt();

        int total = mark1 + mark2 + mark3;
        double average = total / 3.0;

        char grade;
        if (average >= 90) 
        {
            grade = 'A';
        } 
        else if (average >= 80)
        {
            grade = 'B';
        }
        else if (average >= 70)
        {
            grade = 'C';
        }
        else if (average >= 60) 
        {
            grade = 'D';
        } 
        else 
        {
            grade = 'F';
        }

        System.out.println("\n--- Student Report ---");
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + total);
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Grade: " + grade);
    }
}
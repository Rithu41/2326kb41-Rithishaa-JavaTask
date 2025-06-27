package tasks.java;

import java.util.Scanner;

class Student 
{
    int rollNo;
    String name;
    int mark1, mark2, mark3;

    public void acceptDetails(Scanner sc)
    {
			System.out.print("Enter Roll Number: ");
			rollNo = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter Name: ");
			name = sc.nextLine();

			System.out.print("Enter Mark 1: ");
			mark1 = sc.nextInt();
			System.out.print("Enter Mark 2: ");
			mark2 = sc.nextInt();
			System.out.print("Enter Mark 3: ");
			mark3 = sc.nextInt();
	
    }

    public int totalMarks()
    {
        return mark1 + mark2 + mark3;
    }

    public float averageMarks()
    {
        return totalMarks() / 3.0f;
    }

    public void displayDetails()
    {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + mark1 + ", " + mark2 + ", " + mark3);
        System.out.println("Total Marks: " + totalMarks());
        System.out.println("Average Marks: " + averageMarks());

        if (mark1 >= 35 && mark2 >= 35 && mark3 >= 35)
        {
            System.out.println("Result: PASS");
        } else 
        {
            System.out.println("Result: FAIL");
        }
        System.out.println("-----------------------");
     }
}

public class Task4 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++)
        {
            System.out.println("\nEnter details for Student " + (i + 1));
            students[i] = new Student();
            students[i].acceptDetails(sc);
        }
        
        System.out.println("\n===== Student Results =====");
        for (Student s : students) 
        {
            s.displayDetails();
        }

        sc.close();
    }
}
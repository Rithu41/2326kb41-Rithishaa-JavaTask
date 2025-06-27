package Hometask.java;

import java.util.*;

public class MiniManagement 
{
	static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<String, ArrayList<String>> studentCourses = new HashMap<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student and Courses");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    searchStudent(sc);
                    break;
                case 3:
                    deleteStudent(sc);
                    break;
                case 4:
                    displayAll();
                    break;
                case 5:
                    System.out.println("Exiting App.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }

    static void addStudent(Scanner sc) 
    {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        studentNames.add(name);

        ArrayList<String> courses = new ArrayList<>();
        System.out.print("How many courses? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter course " + (i + 1) + ": ");
            courses.add(sc.nextLine());
        }

        studentCourses.put(id, courses);
        System.out.println("Student added successfully.");
    }

    static void searchStudent(Scanner sc) 
    {
        System.out.print("Enter student ID to search: ");
        String id = sc.nextLine();

        if (studentCourses.containsKey(id))
        {
            System.out.println("Courses for student ID " + id + ":");
            for (String course : studentCourses.get(id))
            {
                System.out.println(" - " + course);
            }
        } 
        else 
        {
            System.out.println("Student ID not found.");
        }
    }

    static void deleteStudent(Scanner sc)
    {
        System.out.print("Enter student ID to delete: ");
        String id = sc.nextLine();

        if (studentCourses.remove(id) != null) 
        {
            System.out.println("Student deleted.");
        } 
        else
        {
            System.out.println("Student ID not found.");
        }
    }

    static void displayAll() 
    {
        System.out.println("\nAll Students and Their Courses:");
        for (String id : studentCourses.keySet())
        {
            System.out.println("ID: " + id);
            System.out.println("Courses:");
            for (String course : studentCourses.get(id))
            {
                System.out.println("  - " + course);
            }
            System.out.println();
        }
    }
}
package Tasks.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Task4 
{
    public static void main(String[] args) 
    {
        ArrayList<String> students = new ArrayList<>();
        HashMap<String, ArrayList<String>> studentCourses = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Student Course Enrollment System ---");
            System.out.println("1. Add Student and Courses");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students and Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice)
            {
                case 1:
                    // Add student	
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    if (!students.contains(studentName))
                    {
                        students.add(studentName);
                        studentCourses.put(studentName, new ArrayList<>());
                    }

                    // Add courses
                    System.out.print("Enter number of courses: ");
                    int numCourses = scanner.nextInt();
                    scanner.nextLine(); 

                    for (int i = 0; i < numCourses; i++)
                    {
                        System.out.print("Enter course " + (i + 1) + ": ");
                        String course = scanner.nextLine();
                        studentCourses.get(studentName).add(course);
                    }
                    System.out.println("Student and courses added successfully.");
                    break;

                case 2:
                    // Remove student
                    System.out.print("Enter student name to remove: ");
                    String removeName = scanner.nextLine();
                    if (students.remove(removeName))
                    {
                        studentCourses.remove(removeName);
                        System.out.println("Student removed.");
                    } else
                    {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    // Display students and their courses
                    System.out.println("\nStudent Enrollments:");
                    Iterator<String> studentIterator = students.iterator();
                    
                    while (studentIterator.hasNext()) 
                    {
                        String name = studentIterator.next();
                        System.out.println("Student: " + name);
                        ArrayList<String> courses = studentCourses.get(name);

                        Iterator<String> courseIterator = courses.iterator();
                        while (courseIterator.hasNext())
                        {
                            System.out.println("  - " + courseIterator.next());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
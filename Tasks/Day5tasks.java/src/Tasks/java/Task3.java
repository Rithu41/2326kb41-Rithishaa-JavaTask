package Tasks.java;

import java.util.HashMap;

public class Task3
{
    public static void main(String[] args) 
    {
        HashMap<String, Integer> students = new HashMap<>();

        students.put("Ravi", 80);
        students.put("Meena", 90);
        students.put("Arun", 75);
        students.put("Divya", 85);

        System.out.println("Student Marks:");
        for (String name : students.keySet()) 
        {
            System.out.println(name + " : " + students.get(name));
        }
        
        int total = 0;
        for (int mark : students.values()) 
        {
            total += mark;
        }

        double average = (double) total / students.size();
        System.out.println("\nAverage Marks: " + average);
    }
}

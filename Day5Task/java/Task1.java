package Tasks.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Task1 
{
    public static void main(String[] args)
    {
        ArrayList<String> students = new ArrayList<>();

        students.add("Akhil");
        students.add("Bhavna");
        students.add("Charan");
        students.add("Deepa");

        System.out.println("Student List:");
        Iterator<String> itr = students.iterator();
        
        while (itr.hasNext())
        {
            String student = itr.next();
            System.out.println(student);
        }
    }
}
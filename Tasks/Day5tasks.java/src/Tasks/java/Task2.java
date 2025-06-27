package Tasks.java;

import java.util.HashSet;

public class Task2 
{
    public static void main(String[] args)
    {
        HashSet<String> emails = new HashSet<>();

        emails.add("john@example.com");
        emails.add("alice@example.com");
        emails.add("bob@example.com");
        emails.add("john@example.com"); // Duplicate email
        
        System.out.println("Unique Email Addresses:");
        for (String email : emails)
        {
            System.out.println(email);
        }
    }
}
package tasks.java;
import java.util.Scanner;

public class Task3 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = s.nextLine();
        String[] words = sentence.split(" ");
        System.out.println("Words in the sentence:");
        for (String word : words)
        {
            System.out.println(word);
        }
        s.close();
    }
}

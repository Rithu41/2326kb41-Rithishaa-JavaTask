package tasks.java;
import java.util.Scanner;
//Vowels//

public class Task2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String:");
		String input = sc.nextLine();
		
		int vowels=0;
		int consonants=0;
		input=input.toLowerCase();
		
		for(int i=0;i<input.length();i++)
		{
			char ch = input.charAt(i);
			if(ch>='a' && ch<='z')
			{
				if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
				{
					vowels++;
				}
				else
				{
					consonants++;
				}
			}
		 }
		System.out.println("Number of vowels: " +vowels);
		System.out.println("Number of consonants: " +consonants);
	}
}

package Hometask.java;
import java.util.Scanner;
public class MiniAddressBook
{
	public static void main(String args[])
		{
			Scanner in = new Scanner(System.in);
			final int contact = 3;
			String[] name = new String[contact];
			String[] phone = new String[contact];
			String[] email = new String[contact];
			System.out.println("Enter detail upto "+contact+" contacts");
			for(int i=0;i<contact;i++)
			{
				    System.out.println("\nContact " + (i + 1) + " : ");
				    System.out.print("Name: ");
				    name[i] = in.nextLine();
			
				    System.out.print("Phone No: ");
				    phone[i] = in.nextLine();
				    
				    System.out.print("Email: ");
				    email[i] = in.nextLine();
			}
			System.out.println("-- Mini Address Book --");
			for (int i = 0; i < contact; i++)
				{
				    System.out.println("Name: " + name[i]);
				    System.out.println("Phone No: " + phone[i]);
				    System.out.println("Email: " + email[i]);
				    System.out.println();
				}
			in.close();
			}
}

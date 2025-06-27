package Hometask.java;

import java.util.ArrayList;
import java.util.Scanner;

class Library
{
    private ArrayList<String> books = new ArrayList<>();

    public void addBook(String bookName)
    {
        books.add(bookName);
        System.out.println("'" + bookName + "' added to the library.");
    }
    public void removeBook(String bookName)
    {
        if (books.remove(bookName))
        {
            System.out.println("'" + bookName + "' removed from the library.");
        }
        else
        {
            System.out.println("'" + bookName + "' not found in the library.");
        }
    }
    public void issueBook(String bookName)
    {
        if (books.contains(bookName)) 
        {
            books.remove(bookName);
            System.out.println("'" + bookName + "' has been issued.");
        } 
        else 
        {
            System.out.println("'" + bookName + "' is not available.");
        }
    }
    public void displayBooks() 
    {
        if (books.isEmpty())
        {
            System.out.println("No books available in the library.");
        } 
        else
        {
            System.out.println("Books available in the library:");
            for (String book : books)
            {
                System.out.println(" - " + book);
            }
        }
    }
}

public class Librarybook 
{
    public static void main(String[] args)
    {
        Library lib = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;
        String bookName;

        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice)
            {
                case 1:
                    System.out.print("Enter book name to add: ");
                    bookName = scanner.nextLine();
                    lib.addBook(bookName);
                    break;
                case 2:
                    System.out.print("Enter book name to remove: ");
                    bookName = scanner.nextLine();
                    lib.removeBook(bookName);
                    break;
                case 3:
                    System.out.print("Enter book name to issue: ");
                    bookName = scanner.nextLine();
                    lib.issueBook(bookName);
                    break;
                case 4:
                    lib.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

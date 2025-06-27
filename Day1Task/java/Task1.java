package tasks.java;

import java.util.Scanner;
//Even numbers//

public class Task1
{
   public static void main(String args[])
   {
       System.out.println("Even numbers between 0 to 100:");
       for(int i=0;i<=100;i++)
       {
       if(i%2==0)
       {
           System.out.println(i);
       }
       }
    }
}
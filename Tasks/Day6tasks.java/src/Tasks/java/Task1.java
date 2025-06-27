package Tasks.java;

class Task extends Thread 
{
 public void run() 
 {
     for (int i = 1; i <= 10; i++)
     {
         System.out.println("Number: " + i);
         try
         {
             Thread.sleep(500);
         }
         catch (InterruptedException e) 
         {
             System.out.println("Thread interrupted");
         }
     }
 }
}

public class Task1 
{
 public static void main(String[] args) 
 {
     Task t1 = new Task();
     t1.start();
 }
}
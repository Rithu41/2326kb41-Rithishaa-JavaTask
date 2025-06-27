package Tasks.java;

class MyThread extends Thread
{
    public void run() 
    {
        for (int i = 1; i <= 3; i++) 
        {
            System.out.println(getName() + " - Count: " + i);
            try 
            {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e)
            {
                System.out.println(getName() + " interrupted");
            }
        }
        System.out.println(getName() + " finished.");
    }
}

public class Task3
{
    public static void main(String[] args)
    {
        System.out.println("Main thread starts");
        
        MyThread t1 = new MyThread();
        t1.setName("Thread-1");

        MyThread t2 = new MyThread();
        t2.setName("Thread-2");

        t1.start();
        
        try
        {
            t1.join(); 
        } catch (InterruptedException e) 
        {
            System.out.println("Main thread interrupted");
        }

        t2.start(); 
        
        try
        {
            t2.join(); 
        }
        catch (InterruptedException e) 
        {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread ends");
    }
}
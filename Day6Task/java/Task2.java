package Tasks.java;

class MyMessage implements Runnable
{
 String message;
 MyMessage(String message)
 {
     this.message = message;
 }

 public void run() 
 {
     System.out.println(message + " - from " + Thread.currentThread().getName());
 }
}

public class Task2
{
 public static void main(String[] args) 
 {
     MyMessage msg1 = new MyMessage("Hello");
     MyMessage msg2 = new MyMessage("Welcome");
     MyMessage msg3 = new MyMessage("Goodbye");

     Thread t1 = new Thread(msg1, "Thread-1");
     Thread t2 = new Thread(msg2, "Thread-2");
     Thread t3 = new Thread(msg3, "Thread-3");

     t1.start();
     t2.start();
     t3.start();
 }
}
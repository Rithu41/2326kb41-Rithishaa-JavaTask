package Hometask.java;

class BankAccount 
{
 private int balance = 1000; 
 public synchronized void withdraw(String user, int amount)
 {
     System.out.println(user + " is trying to withdraw ₹" + amount);

     if (amount > balance)
     {
         System.out.println("❌ " + user + " - Not enough balance. Available: ₹" + balance + "\n");
         return;
     }

     System.out.println("Processing withdrawal for " + user + "...");
     try
     {
         Thread.sleep(1000); // Simulate delay
     }
     catch (InterruptedException e)
     {
         System.out.println(user + " - Transaction interrupted.");
     }

     balance -= amount;
     System.out.println("✔ " + user + " withdrew ₹" + amount + ". Remaining balance: ₹" + balance + "\n");
 }
}

class UserThread extends Thread
{
 private BankAccount account;
 private int amount;

 public UserThread(BankAccount account, String name, int amount)
 {
     super(name); 
     this.account = account;
     this.amount = amount;
 }

 public void run()
 {
     account.withdraw(getName(), amount); 
 }
}

public class Bankapp 
{
 public static void main(String[] args)
 {
     BankAccount sharedAccount = new BankAccount();

     UserThread user1 = new UserThread(sharedAccount, "User-1", 400);
     UserThread user2 = new UserThread(sharedAccount, "User-2", 500);
     UserThread user3 = new UserThread(sharedAccount, "User-3", 300);

     user1.start();
     user2.start();
     user3.start();
 }
}

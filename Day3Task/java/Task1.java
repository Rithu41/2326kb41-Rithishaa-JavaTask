package tasks.java;

class BankAccount
{
    double balance;
    BankAccount(double initialBalance)
    {
       balance = initialBalance;
    }

   public void deposit(double amount)
   {
       balance += amount;
   }

   public void withdraw(double amount)
   {
       if (amount <= balance) 
       {
           balance -= amount;
       }
       else 
       {
           System.out.println("Not enough funds.");
       }
   }

   public void displayBalance() 
   {
       System.out.println("Current balance: ₹" + balance);
   }
}
 public class Task1
 {
   public static void main(String[] args)
   {
       BankAccount myAccount = new BankAccount(5000);
       myAccount.deposit(2000);
       myAccount.withdraw(1000);
       myAccount.displayBalance();
   }
}



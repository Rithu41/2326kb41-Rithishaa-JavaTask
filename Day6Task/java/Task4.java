package Tasks.java;

class TicketBooking 
{
    int availableSeats = 5;

    public void bookTicket(String user, int seatsRequested)
    {
        synchronized (this)
        {
            System.out.println(user + " is trying to book " + seatsRequested + " ticket(s).");

            if (seatsRequested <= availableSeats)
            {
                System.out.println("Booking for " + user + " in progress...");
                try
                {
                    Thread.sleep(1000); // Simulate delay
                } 
                catch (InterruptedException e)
                {
                    System.out.println("Booking interrupted for " + user);
                }

                availableSeats -= seatsRequested;
                System.out.println("Booking successful for " + user + ". Seats booked: " + seatsRequested);
            } 
            else 
            {
                System.out.println("Booking failed for " + user + ". Not enough seats.");
            }

            System.out.println("Remaining seats: " + availableSeats + "\n");
        }
    }
}

class User extends Thread
{
    TicketBooking booking;
    String userName;
    int seats;

    public User(TicketBooking booking, String userName, int seats)
    {
        this.booking = booking;
        this.userName = userName;
        this.seats = seats;
    }

    public void run()
    {
        booking.bookTicket(userName, seats);
    }
}

public class Task4 
{
    
	public static void main(String[] args)
    {
        TicketBooking booking = new TicketBooking();

        User u1 = new User(booking, "User1", 2);
        User u2 = new User(booking, "User2", 3);
        User u3 = new User(booking, "User3", 2);

        u1.start();
        u2.start();
        u3.start();
    }
}
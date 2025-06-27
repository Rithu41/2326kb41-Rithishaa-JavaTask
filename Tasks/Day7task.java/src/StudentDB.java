import java.sql.*;
import java.util.Scanner;

public class StudentDB 
{
    static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "Rithu@18";

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            while (true) {
                System.out.println("\n=== Student DB Manager ===");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                if (choice == 1)
                {         
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    String sql = "INSERT INTO db (name, age, grade) VALUES (?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, name);
                    stmt.setInt(2, age);
                    stmt.setString(3, grade);

                    int rows = stmt.executeUpdate();
                    System.out.println("Student added successfully. Rows affected: " + rows);

                }
                else if (choice == 2)
                {
                    String sql = "SELECT * FROM db";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    System.out.println("\n--- Student List ---");
                    while (rs.next()) {
                        System.out.println(", Name: " + rs.getString("name") +
                                           ", Age: " + rs.getInt("age") +
                                           ", Grade: " + rs.getString("grade"));
                    }
                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
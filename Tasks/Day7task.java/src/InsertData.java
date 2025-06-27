import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";  
        String user = "root";  
        String password = "Rithu@18"; 

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student course: ");
        String course = sc.nextLine();

        System.out.print("Enter student marks: ");
        int marks = sc.nextInt();

        String query = "INSERT INTO students (name, course, marks) VALUES (?, ?, ?)";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, course);
            pst.setInt(3, marks);
     
            int rows = pst.executeUpdate();
            System.out.println(rows + " student inserted successfully.");

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

public class DisplayData {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/studentdb"; 
        String username = "root"; 
        String password = "Rithu@18";   

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(jdbcURL, username, password);

            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM display";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Student Records:");
            while (rs.next()) 
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


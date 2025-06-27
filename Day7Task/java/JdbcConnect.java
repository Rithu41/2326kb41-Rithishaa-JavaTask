package Tasks.java;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class JdbcConnect 
	{
	    public static void main(String[] args)
	    {
	        String url = "jdbc:mysql://localhost:3306/student";  
	        String user = "root";                                 
	        String password = "Rithu@18";                   

	        try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection conn = DriverManager.getConnection(url, user, password);
	            System.out.println("✅ Connected to MySQL!");

	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM student_table");

	            while (rs.next()) 
	            {
	                System.out.println("ID: " + rs.getInt("id") +
	                                   ", Name: " + rs.getString("name") +
	                                   ", Marks: " + rs.getInt("marks"));
	            }

	            conn.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}
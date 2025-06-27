package Hometask.java;

import java.sql.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class StudentInv {
    private static final String URL = "jdbc:mysql://localhost:3306/inventorydb";
    private static final String USER = "root";
    private static final String PASS = "Rithu@18";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            while (true) {
                System.out.println("\n1.Add  2.View All  3.Search by ID  4.Exit");
                switch (sc.nextInt()) {
                    case 1 -> addProduct(conn, sc);
                    case 2 -> viewAll(conn);
                    case 3 -> searchById(conn, sc);
                    case 4 -> { return; }
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addProduct(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Name: "); String name = sc.next();
        System.out.print("Category: "); String cat = sc.next();
        System.out.print("Price: "); BigDecimal price = sc.nextBigDecimal();
        System.out.print("Quantity: "); int qty = sc.nextInt();
        String sql = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, cat);
            ps.setBigDecimal(3, price);
            ps.setInt(4, qty);
            ps.executeUpdate();
            System.out.println("Product added!");
        }
    }

    private static void viewAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM products";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.printf("%-4s %-20s %-15s %-10s %-8s%n",
                              "ID", "Name", "Category", "Price", "Qty");
            while (rs.next()) {
                System.out.printf("%-4d %-20s %-15s %-10.2f %-8d%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getBigDecimal("price"),
                    rs.getInt("quantity"));
            }
        }
    }

    private static void searchById(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter product ID: ");
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, sc.nextInt());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.printf("ID: %d | Name: %s | Cat: %s | Price: %.2f | Qty: %d%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"));
                } else {
                    System.out.println("Not found.");
                }
            }
        }
    }
}

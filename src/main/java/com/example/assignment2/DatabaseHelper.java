package com.example.assignment2;
import java.sql.*;
public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:users.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase(){
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "username TEXT NOT NULL UNIQUE," +
                     "password TEXT NOT NULL)";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            stmt.execute("INSERT OR IGNORE INTO users (username, password) VALUES ('admin', '1234'");
        } catch (SQLException e){
            System.out.println("DB Init Error: " + e.getMessage());
        }
    }

    public static boolean checkLogin(String username, String password){
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e){
            System.out.println("Login Check Error: " + e.getMessage());
            return false;
        }
    }
}

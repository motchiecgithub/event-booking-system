package com.example.assignment2.model;
import java.sql.*;

public class UserDAO {
    private static final String DB_URL = "jdbc:sqlite:users.db";

    public static void initDB(){
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
        ){
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    preferred_name TEXT
                );
            """);
        } catch (SQLException e){
            System.out.println("DB Init Error: "+ e.getMessage());
        }
    }

    public static boolean register (User user){
        String sql = "INSERT INTO users (username, password, preferred_name) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getPreferredName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    public static User login(String username, String password){
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return new User(username, password, rs.getString("preferred_name"));
            }

        } catch (SQLException e) {
            System.out.println("Login Error: " + e.getMessage());
        }
        return null;
    }
}

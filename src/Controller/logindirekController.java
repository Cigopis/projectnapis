/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import Model.direktur.dashboardDirectors;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yudo P
 */
public class logindirekController {
    String username,password,level;
     private String hashPassword(String password) throws NoSuchAlgorithmException {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new NoSuchAlgorithmException("Hashing algorithm not found.");
        }
    }
    
    public boolean login(String email, String password) {
        try (Connection connection = connect.koneksiDb()) {
            String sql = "SELECT * FROM account WHERE email = ? AND password = ? AND level = 'director'";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, hashPassword(password)); // Hash password sebelum membandingkan
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        level = resultSet.getString("level");
                        JOptionPane.showMessageDialog(null, "Login Success, Selamat Datang " + email);
                        username = email;
                        dashboardDirectors dash = new dashboardDirectors(username);
                        dash.setVisible(true);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Email atau password salah");
                        return false;
                    }
                }
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }
}

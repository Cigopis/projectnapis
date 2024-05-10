/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import Model.karyawan.loginKaryawan;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yudo P
 */
public class registerkarController {
    
    private String pass,mail;
    
    
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
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
    
    public void register(String mail,String pass, String confirmPass) {
        
        if (pass.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password Minimal 8 karakter");
        } else if (!pass.equals(confirmPass)) {
            JOptionPane.showMessageDialog(null, "Password Tidak Sesuai");
        } else {
            try (Connection connection = connect.koneksiDb()) {
                String sql = "INSERT INTO account (email, password, level) VALUES (?, ?, 'karyawan')";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, mail);
                    statement.setString(2, hashPassword(pass));
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Register Berhasil");
                    loginkarController control = new loginkarController();
                    loginKaryawan frame = new loginKaryawan(control);
                    frame.setVisible(true);
                }
            } catch (SQLException | NoSuchAlgorithmException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}

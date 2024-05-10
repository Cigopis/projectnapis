/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import Model.direktur.dashboardDirectors;
import Model.direktur.loginDirectors;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.json.JSONObject;
/**
 *
 * @author Yudo P
 */
public class registerdirekController {
     private String pass,mail;
    
    
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
    
   public void register(String mail, String pass, String confirmPass) {
    if (pass.length() < 8) {
        JSONObject errorObject = new JSONObject();
        errorObject.put("error", "Password Minimal 8 karakter");
        JOptionPane.showMessageDialog(null, errorObject.toString());
    } else if (!pass.equals(confirmPass)) {
        JSONObject errorObject = new JSONObject();
        errorObject.put("error", "Password Tidak Sesuai");
        JOptionPane.showMessageDialog(null, errorObject.toString());
    } else if (!mail.contains("@")) { // Validasi apakah alamat email mengandung karakter '@'
        JSONObject errorObject = new JSONObject();
        errorObject.put("error", "Alamat email harus menyertakan karakter '@'");
        JOptionPane.showMessageDialog(null, errorObject.toString());
    } else {
        try (Connection connection = connect.koneksiDb()) {
            String sql = "INSERT INTO account (email, password, level) VALUES (?, ?, 'director')";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, mail);
                statement.setString(2, hashPassword(pass));
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Register Berhasil");
                logindirekController control = new logindirekController();
                loginDirectors frame = new loginDirectors(control);
                frame.setVisible(true);
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            JSONObject errorObject = new JSONObject();
            errorObject.put("error", e.getMessage());
            JOptionPane.showMessageDialog(null, errorObject.toString());
        }
    }
}

}

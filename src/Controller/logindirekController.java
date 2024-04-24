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
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Yudo P
 */
public class logindirekController {
    String username,password,level;
    int pengeluaran,gaji;
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
                    // Mendapatkan alamat email tanpa bagian setelah karakter '@'
                    String[] parts = email.split("@");
                    String username = parts[0];
                    
                    level = resultSet.getString("level");
                    JOptionPane.showMessageDialog(null, "Login Success, Selamat Datang " + username);
                    logindirekController controller = new logindirekController();
                    agendaController controlagenda = new agendaController();// Gunakan nama kelas yang benar
                    dashboardDirectors dash = new dashboardDirectors(username, controller,controlagenda); // Gunakan nama kelas yang benar
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

       public void getPemasukan(JTextField masuk){
           try{
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM finance_income";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                masuk.setText(rs.getString("total"));
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       }
       public void getGaji(){
           try{
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT SUM(total) FROM salary";
            ResultSet rs = st.executeQuery(sql_tingkat);
            if (rs.next()){
                gaji =rs.getInt(1);
            }else{
                gaji=0;
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       }
       public void getPengeluaran(JTextField keluar) {
    try {
        getGaji(); // Pastikan gaji sudah diinisialisasi sebelumnya
        Connection kon = connect.koneksiDb();
        Statement st = kon.createStatement();
        String sql_tingkat = "SELECT SUM(total) FROM finance_expenses";
        ResultSet rs = st.executeQuery(sql_tingkat);
        if (rs.next()) {
            pengeluaran = rs.getInt(1);
        } else {
            pengeluaran = 0;
        }
        // Tambahkan nilai gaji ke pengeluaran
        pengeluaran += gaji;
        // Atur nilai pengeluaran dalam JTextField keluar
        keluar.setText(String.valueOf(pengeluaran));
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    } 
}
       public void closeFocus(JTextField masuk,JTextField keluar,JTextField user){
           masuk.setFocusable(false);
           keluar.setFocusable(false);
           user.setFocusable(false);
       }


}

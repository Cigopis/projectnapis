/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yudo P
 */
public class klienController {
    String idklien;
    public void addKlien(JTextField txtNamaInstansi, JTextField txtNamaKlien,JTextField txtPosisi,JTextArea areaAddress,JTextField txtEmail,JTextField txtContact) {
    try {
        // Establishing a database connection
        Connection kon = connect.koneksiDb();
        
        // Creating a statement and prepared statement for SQL execution
        Statement st = kon.createStatement(); 
        PreparedStatement prs = kon.prepareStatement("INSERT INTO klien (id_klien, name_instansi, name_klien, possition_klien, address, email, contact) VALUES(null,?,?,?,?,?,?)");
        
        // Setting values for prepared statement parameters
        prs.setString(1, txtNamaInstansi.getText());
        prs.setString(2, txtNamaKlien.getText());
        prs.setString(3, txtPosisi.getText());
        prs.setString(4, areaAddress.getText());
        prs.setString(5, txtEmail.getText());
        prs.setString(6, txtContact.getText());
        
        // Executing the SQL query
        prs.executeUpdate();
        
        // Showing success message if the data insertion is successful
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Masukan");
    } catch (Exception e) {
        // Showing error message if any exception occurs
        JOptionPane.showMessageDialog(null, "Gagal" + e.getMessage());
    }
}
    private void getIdKlien(JTextField txtNamaInstansi){
           try{
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM klien WHERE name_instansi ='" + txtNamaInstansi.getText()+ "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idklien=rs.getString("id_klien");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateKlien(JTextField txtNamaInstansi, JTextField txtNamaKlien,JTextField txtPosisi,JTextArea areaAddress,JTextField txtEmail,JTextField txtContact) {
    try {
        getIdKlien(txtNamaInstansi);
        // Establishing a database connection
        Connection kon = connect.koneksiDb();
        
        // Creating a statement and prepared statement for SQL execution
        Statement st = kon.createStatement(); 
        PreparedStatement prs = kon.prepareStatement("UPDATE klien  set name_instansi = ?, name_klien = ?, position_klien = ?, address = ?, email = ?, contact = ? WHERE id_klien = ?");
        
        // Setting values for prepared statement parameters
        prs.setString(1, txtNamaInstansi.getText());
        prs.setString(2, txtNamaKlien.getText());
        prs.setString(3, txtPosisi.getText());
        prs.setString(4, areaAddress.getText());
        prs.setString(5, txtEmail.getText());
        prs.setString(6, txtContact.getText());
        prs.setString(7, idklien);
        
        // Executing the SQL query
        prs.executeUpdate();
        
        // Showing success message if the data insertion is successful
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Masukan");
    } catch (Exception e) {
        // Showing error message if any exception occurs
        JOptionPane.showMessageDialog(null, "Gagal" + e.getMessage());
    }
}
    DefaultTableModel tabel = new DefaultTableModel();
    String gender;
    public void tabel(JTable tabelklien) {
        tabelklien.setModel(tabel);
        tabel.addColumn("NAMA INSTANSI");
        tabel.addColumn("NAMA KLIEN");
        tabel.addColumn("JABATAN KLIEN");
        tabel.addColumn("ALAMAT INSTANSI");
        tabel.addColumn("EMAIL");
        tabel.addColumn("KONTAK");
    String query = "SELECT name_instansi,name_klien,possition_klien,address,email,contact FROM klien ORDER BY id_klien ASC";

    try {
        Connection conn = connect.koneksiDb(); // Memanggil koneksi
        Statement sttmnt = conn.createStatement(); // Membuat statement
        ResultSet rslt = sttmnt.executeQuery(query); // Menjalankan query

        int no = 1; // Inisialisasi nomer baris
        while (rslt.next()) {
            // Menampung data sementara
            String d1 = rslt.getString(1);
            String d2 = rslt.getString(2);
            String d3 = rslt.getString(3);
            String d4 = rslt.getString(4);
          
            String d5 = rslt.getString(5);
            String d6 = rslt.getString(6);
            

            // Mengonversi hash kode menjadi string
           
            // Menambahkan nomer baris ke data
            String nomer = String.valueOf(no++);
            // Menambahkan semua data ke dalam array
            String[] data = {nomer, d1, d2, d3, d4, d5, d6};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabel.addRow(data);
        }
        // Mengeset nilai yang ditampung agar muncul di tabel
        tabelklien.setModel(tabel);

    } catch (Exception e) {
        System.out.println(e);
    }
    }
}

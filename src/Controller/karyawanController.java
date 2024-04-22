package Controller;

import Connection.connect;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class karyawanController {
    private String gender;

    public karyawanController() {

    }

    public void add(JTextField norfid, JTextField txtNoktp, JTextField txtName, JDateChooser tgl_birth, JRadioButton L, JRadioButton P, JTextField txtEmail, JTextField txtContact, JComboBox<String> comboPosition) {
        if (L.isSelected()) {
            gender = "L";
        } else if (P.isSelected()) {
            gender = "P";
        }
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = String.valueOf(date.format(tgl_birth.getDate()));
            Connection kon = connect.koneksiDb();
            PreparedStatement prs = kon.prepareStatement("INSERT INTO karyawan (norfid,noktp,name,birthday,gender,email,contact,possition) VALUES(?,?,?,?,?,?,?,?)");
            prs.setString(1, norfid.getText());
            prs.setString(2, txtNoktp.getText());
            prs.setString(3, txtName.getText());
            prs.setString(4, tanggal);
            prs.setString(5, gender);
            prs.setString(6, txtEmail.getText());
            prs.setString(7, txtContact.getText());
            prs.setString(8, comboPosition.getSelectedItem().toString());
            prs.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
        }
    }

    public void clear(JTextField norfid, JTextField txtNoktp, JTextField txtName, JDateChooser tgl_birth, ButtonGroup jk, JTextField txtEmail, JTextField txtContact, JComboBox<String> comboPosition) {
        norfid.setText("");
        txtNoktp.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtContact.setText("");
        comboPosition.setSelectedItem("Pilih");
        jk.clearSelection();
        tgl_birth.setDate(null);
    }

    DefaultTableModel tabel = new DefaultTableModel();

    public void tabel(JTable tabelKaryawan) {
    // Mengatur model tabel
    tabelKaryawan.setModel(tabel);
    
    // Menambahkan kolom pada model tabel
    tabel.addColumn("ID Karyawan");
    tabel.addColumn("No KTP");
    tabel.addColumn("Nama Karyawan");
    tabel.addColumn("Tanggal Lahir");
    tabel.addColumn("Jenis Kelamin");
    tabel.addColumn("Email");
    tabel.addColumn("Contact");
    tabel.addColumn("Posisi");
    
    // Mengosongkan tabel sebelum menambahkan data baru
    tabel.setRowCount(0);
   
    String query = "SELECT noktp, name, birthday, gender, email, contact, possition FROM karyawan ORDER BY id_karyawan ASC";

    try {
        Connection conn = connect.koneksiDb(); // Memanggil koneksi
        Statement sttmnt = conn.createStatement(); // Membuat statement
        ResultSet rslt = sttmnt.executeQuery(query); // Menjalankan query

        int no = 1; // Inisialisasi nomor baris
        while (rslt.next()) {
            // Menampung data sementara
            String d1 = rslt.getString(1);
            String d2 = rslt.getString(2);
            String d3 = rslt.getString(3);
            String d4 = rslt.getString(4);
            String gender;
            if (d4.equals("L")) {
                gender = "Laki-Laki";
            } else if (d4.equals("P")) {
                gender = "Perempuan";
            } else {
                gender = "Undefined";
            }
            String d5 = rslt.getString(5);
            String d6 = rslt.getString(6);
            String d7 = rslt.getString(7);

            // Menambahkan nomor baris ke data
            String nomer = String.valueOf(no++);
            // Menambahkan semua data ke dalam array
            String[] data = {nomer, d1, d2, d3, gender, d5, d6, d7};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabel.addRow(data);
        }
    } catch (Exception e) {
        System.out.println("Error while populating table: " + e.getMessage());
    }
    
}

}
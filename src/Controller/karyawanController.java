package Controller;

import Connection.connect;
import Model.karyawan.dataKaryawan;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Timer timer;
    public karyawanController() {

    }

    public void add(JTextField norfid, JTextField txtNoktp, JTextField txtName, JDateChooser tgl_birth, JRadioButton L, JRadioButton P, JTextField txtEmail, JTextField txtContact, JComboBox<String> comboPosition,JTable tabelKaryawan) {
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
            tabel(tabelKaryawan);
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

    public void headerTabel(JTable tabelKaryawan){
        tabelKaryawan.setModel(tabel);
    
    // Menambahkan kolom pada model tabel
    tabel.addColumn("NO RFID");
    tabel.addColumn("No KTP");
    tabel.addColumn("Nama Karyawan");
    tabel.addColumn("Tanggal Lahir");
    tabel.addColumn("Jenis Kelamin");
    tabel.addColumn("Email");
    tabel.addColumn("Contact");
    tabel.addColumn("Posisi");
    }
    public void tabel(JTable tabelKaryawan) {
    // Mengatur model tabel
    
    // Mengosongkan tabel sebelum menambahkan data baru
    int row = tabelKaryawan.getRowCount();
        for(int a = 0 ; a < row ; a++){
            tabel.removeRow(0);
        }
    String query = "SELECT norfid,noktp, name, birthday, gender, email, contact, possition FROM karyawan ORDER BY id_karyawan ASC";

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
            
            String d5 = rslt.getString(5);
            if (d5.equals("L")) {
                gender = "Laki-Laki";
            } else if (d5.equals("P")) {
                gender = "Perempuan";
            } else {
                gender = "Undefined";
            }
            String d6 = rslt.getString(6);
            String d7 = rslt.getString(7);
             String d8 = rslt.getString(8);

            // Menambahkan nomor baris ke data
            // Menambahkan semua data ke dalam array
            String[] data = {d1, d2, d3, d4, gender, d6, d7, d8};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabel.addRow(data);
        }
    } catch (Exception e) {
        System.out.println("Error while populating table: " + e.getMessage());
    }
    
}
    String idkaryawan, jk;
    public void idKaryawan(JTextField txtNoktp, JTextField txtName){
         try{
            java.sql.Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM karyawan WHERE name ='" + txtName.getText() + "' OR noktp ='"+txtNoktp.getText()+"'";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idkaryawan=rs.getString("id_karyawan");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void edit(JTextField norfid, JTextField txtNoktp, JTextField txtName, JDateChooser tgl_birth, JRadioButton L, JRadioButton P, JTextField txtEmail, JTextField txtContact, JComboBox<String> comboPossition,JTable tabelKaryawan){
        idKaryawan(txtNoktp,txtName);
        if(txtNoktp.getText().equals("") && txtName.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Maaf Anda Belum Mengisi");
     }else{
            if(L.isSelected()){
                jk ="L";
            }else if(P.isSelected()){
                jk="P";
            }
        int jawab = JOptionPane.showOptionDialog(null, 
                    "Yakin Ingin Mengedit?", 
                    "Peringatan", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
       
        if(jawab == JOptionPane.NO_OPTION){
            
        }else{
        try{
           
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = String.valueOf(date.format(tgl_birth.getDate()));
            
                String sql_up = "UPDATE karyawan SET noktp='" + txtNoktp.getText()
                        + "',name='" + txtName.getText()
                        + "', birthday = ' "+tanggal+ "',gender='" + jk
                        +"' ,email='"+txtEmail.getText()+"',contact='"+txtContact.getText()+"',possition = '"+comboPossition.getSelectedItem().toString()+"' WHERE id_karyawan='"+idkaryawan+"'";
                st.execute(sql_up);
                JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal"+e);
        }
        tabel(tabelKaryawan);
    }
    }
    }
    public void delete(JTable tabelKaryawan){
        int row = tabelKaryawan.getSelectedRow();
        int update= JOptionPane.showOptionDialog(null,"apakah yakin hapus data?","Hapus Data",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
            if(update == JOptionPane.YES_OPTION){
            try{
                 Connection kon = connect.koneksiDb();
                 Statement st = kon.createStatement();
                 String sql_del = "DELETE from karyawan WHERE noktp='"+tabelKaryawan.getValueAt(row, 1).toString()+"' OR name='"+tabelKaryawan.getValueAt(row, 2).toString()+"'";
                 st.execute(sql_del);
                 JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
                 tabel(tabelKaryawan);
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Gagal"+e);
             }
            tabel(tabelKaryawan);
        }
    }
    public void startTimer(final JTable tabelKaryawan) {
    timer = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Pass the text fields to updateDateTime
            tabel(tabelKaryawan);
        }
    });
    timer.start();
}


    public void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }

}

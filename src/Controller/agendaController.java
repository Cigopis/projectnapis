/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import com.toedter.calendar.JDateChooser;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class agendaController {
    DefaultTableModel tabel = new DefaultTableModel();
    String idcategory,idteam,idklien,idagenda;
    int total,subtotal,sumsubtotal;
    private void combox1(JComboBox<String> comboKat){
        try{
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM agenda_category";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                comboKat.addItem(rs.getString("name"));
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void getIdkategori(JComboBox<String> comboKat){
           try{
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM agenda_category WHERE name ='" + comboKat.getSelectedItem() + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idcategory=rs.getString("id_kat_agenda");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void combox2(JComboBox<String> comboNamaInstansi){
        try{
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM klien";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                comboNamaInstansi.addItem(rs.getString("name_instansi"));
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void getIdKlien(JComboBox<String> comboNamaInstansi){
           try{
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM klien WHERE name_instansi ='" + comboNamaInstansi.getSelectedItem() + "';";
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
    private void combox3(JComboBox<String> comboNamaTeam){
        try{
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM team";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                comboNamaTeam.addItem(rs.getString("name"));
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void getIdTeam(JComboBox<String> comboNamaTeam){
           try{
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM team WHERE name ='" + comboNamaTeam.getSelectedItem() + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idteam=rs.getString("id_team");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void tanggal(JDateChooser tgl_mulai){
        Date now = new Date();  
        tgl_mulai.setDate(now);    
    }
    
    private void addAgenda(JTextField txtNamaAcara,JTextArea areaCatatan,JTextField txtBiaya, JDateChooser tgl_mulai, JDateChooser tgl_selesai, JComboBox<String> comboKat, JComboBox<String> comboNamaInstansi,JComboBox<String> comboNamaTeam){
        getIdkategori(comboKat);
        getIdTeam(comboNamaTeam);
        getIdKlien(comboNamaInstansi);
        try{
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_start = String.valueOf(date.format(tgl_mulai.getDate()));
            String tgl_end = String.valueOf(date.format(tgl_selesai.getDate()));
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("INSERT INTO agenda (id_team,id_kat_agenda,id_klien,name,information,price,date_start,date_end) VALUES(?,?,?,?,?,?,?,?)"); 
            prs.setString(1, idteam);
            prs.setString(2, idcategory);
            prs.setString(3, idklien);
            prs.setString(4, txtNamaAcara.getText());
            prs.setString(5, areaCatatan.getText());
             prs.setInt(6, Integer.parseInt(txtBiaya.getText()));
             prs.setString(7, tgl_start);
             prs.setString(8, tgl_end);
             prs.execute();
             JOptionPane.showMessageDialog(null, "Data Berhasil Di Masukan");
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
     private void getIdAgenda(JTextField txtNamaAcara) {
    try {
        Connection kon = connect.koneksiDb();
        PreparedStatement st = kon.prepareStatement("SELECT id_agenda FROM agenda WHERE name = ?");
        st.setString(1, txtNamaAcara.getText());
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            idagenda = rs.getString("id_agenda");
        }
        rs.close();
        st.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

private void addFinance(JTextField txtNamaAcara,JTextArea areaCatatan,JTextField txtBiaya, JDateChooser tgl_mulai, JDateChooser tgl_selesai, JComboBox<String> comboKat, JComboBox<String> comboNamaInstansi,JComboBox<String> comboNamaTeam) {
    getIdAgenda(txtNamaAcara);
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tgl_start = dateFormat.format(tgl_mulai.getDate());
        Connection kon = connect.koneksiDb();
        
        // Insert the data into the database
        String insertSql = "INSERT INTO finance_income (id_agenda, information, subtotal,total, date_income) VALUES (?, ?, ?, ? , ?)";
        PreparedStatement insertStmt = kon.prepareStatement(insertSql);
        
        insertStmt.setString(1, idagenda);
        insertStmt.setString(2, areaCatatan.getText());
        insertStmt.setString(3, txtBiaya.getText());
        insertStmt.setString(4, txtBiaya.getText());
        insertStmt.setString(5, tgl_start);
        
        // Execute the insert
        insertStmt.executeUpdate(); // Use executeUpdate() for INSERT
        
        // Close PreparedStatement
        insertStmt.close();
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
    }
    updatetotalFinance();
}
private void getsumsubtotal() {
    try {
        Connection conn = connect.koneksiDb();
        Statement st = conn.createStatement();
        String sql = "SELECT SUM(subtotal) as total FROM finance_income";
        ResultSet rs = st.executeQuery(sql);
        
        // Check if the result set has any rows
        if (rs.next()) {
            // Retrieve the sum of subtotals
            BigDecimal sum = rs.getBigDecimal("total");
            if (sum != null) {
                // Set the sum to the class-level variable
                sumsubtotal = sum.intValue(); // Or sum.doubleValue() if sumsubtotal is a double
            } else {
                // Handle the case where the sum is null
                sumsubtotal = 0; // Or any default value you prefer
            }
        } else {
            // Handle the case where no rows are returned
            sumsubtotal = 0; // Or any default value you prefer
        }
        
        // Close resources
        rs.close();
        st.close();
        conn.close();
    } catch (SQLException e) {
        // Handle any SQL exceptions
        JOptionPane.showMessageDialog(null, "Error retrieving sum of subtotals: " + e.getMessage());
    } catch (Exception e) {
        // Handle any other exceptions
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

private void updatetotalFinance() {
    try {
        getsumsubtotal();
        Connection kon = connect.koneksiDb();
        
        // Update the total in the database
        String updateSql = "UPDATE finance_income SET total = ? WHERE id_agenda = ?";
        PreparedStatement updateStmt = kon.prepareStatement(updateSql);
        
        updateStmt.setInt(1, sumsubtotal);
        updateStmt.setString(2, idagenda);
        
        // Execute the update
        updateStmt.executeUpdate(); // Use executeUpdate() for UPDATE
        
        // Close PreparedStatement
        updateStmt.close();
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
    }
}
 private void updateAgenda(JTextField txtNamaAcara,JTextArea areaCatatan,JTextField txtBiaya, JDateChooser tgl_mulai, JDateChooser tgl_selesai, JComboBox<String> comboKat, JComboBox<String> comboNamaInstansi,JComboBox<String> comboNamaTeam){
        getIdkategori(comboKat);
        getIdTeam(comboNamaTeam);
        getIdKlien(comboNamaInstansi);
        getIdAgenda(txtNamaAcara);
        try{
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_start = String.valueOf(date.format(tgl_mulai.getDate()));
            String tgl_end = String.valueOf(date.format(tgl_selesai.getDate()));
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("Update agenda set id_team = ?,id_kat_agenda = ?,id_klien = ?,name = ?,information = ?,price = ?,date_start = ?,date_end = ? WHERE id_agenda = ?"); 
            prs.setString(1, idteam);
            prs.setString(2, idcategory);
            prs.setString(3, idklien);
            prs.setString(4, txtNamaAcara.getText());
            prs.setString(5, areaCatatan.getText());
             prs.setInt(6, Integer.parseInt(txtBiaya.getText()));
             prs.setString(7, tgl_start);
             prs.setString(8, tgl_end);
             prs.setString(9, idagenda);
             prs.execute();
             JOptionPane.showMessageDialog(null, "Data Berhasil Di Masukan");
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
     

private void updateFinance(JTextField txtNamaAcara,JTextArea areaCatatan,JTextField txtBiaya, JDateChooser tgl_mulai, JDateChooser tgl_selesai) {
    getIdAgenda(txtNamaAcara);
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tgl_start = dateFormat.format(tgl_mulai.getDate());
        Connection kon = connect.koneksiDb();
        
        // Insert the data into the database
        String insertSql = "Update finance_income set information = ?, subtotal = ?,total = ?, date_income = ? WHERE id_agenda = ?";
        PreparedStatement insertStmt = kon.prepareStatement(insertSql);
        
        
        insertStmt.setString(1, areaCatatan.getText());
        insertStmt.setString(2, txtBiaya.getText());
        insertStmt.setString(3, txtBiaya.getText());
        insertStmt.setString(4, tgl_start);
        insertStmt.setString(5, idagenda);
        
        // Execute the insert
        insertStmt.executeUpdate(); // Use executeUpdate() for INSERT
        
        // Close PreparedStatement
        insertStmt.close();
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
    }
    updatetotalFinance();
}


    public void tabel(JTable tabelAgenda) {
    // Mengatur model tabel
    tabelAgenda.setModel(tabel);
    
    // Menambahkan kolom pada model tabel
    tabel.addColumn("NO");
    tabel.addColumn("NAME PROJECT");
    tabel.addColumn("CATEGORY PROJECT");
    tabel.addColumn("INFORMATION");
    tabel.addColumn("DATE START");
    tabel.addColumn("DATE END");
    
    // Mengosongkan tabel sebelum menambahkan data baru
    tabel.setRowCount(0);
   
    String query = "SELECT * FROM agenda INNER JOIN agenda_category ON agenda.id_kat_agenda = agenda_category.id_kat_agenda ORDER BY id_agenda ASC";

    try {
        Connection conn = connect.koneksiDb(); // Memanggil koneksi
        Statement sttmnt = conn.createStatement(); // Membuat statement
        ResultSet rslt = sttmnt.executeQuery(query); // Menjalankan query

        int no = 1; // Inisialisasi nomor baris
        while (rslt.next()) {
            // Menampung data sementara
            String d1 = rslt.getString("agenda.name");
            String d2 = rslt.getString("agenda_category.name");
            String d3 = rslt.getString("agenda.information");
            String d4 = rslt.getString("agenda.date_start");
            String d5 = rslt.getString("agenda.date_end");

            // Menambahkan nomor baris ke data
            String nomer = String.valueOf(no++);
            // Menambahkan semua data ke dalam array
            String[] data = {nomer, d1, d2, d3, d4, d5};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabel.addRow(data);
        }
    } catch (Exception e) {
        System.out.println("Error while populating table: " + e.getMessage());
    }
    
}
}

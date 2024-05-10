/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import static Controller.AbsensiController.timeFormatter;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yudo P
 */
public class salaryController {
    int idkaryawan,idagenda,subtotalagenda,subtotalgaji,totalgaji,jmlkaryawan,tunjangankaryawan;
    String subgaji,totgaji;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("id"));
    public void updateDateTime(JDateChooser tglnow) {
        LocalDateTime now = LocalDateTime.now();
        Date tanggal = Timestamp.valueOf(now);
        tglnow.setDate(tanggal);
        tglnow.setFocusable(false);
        tglnow.setSelectableDateRange(tanggal, tanggal);
    }
    
    public void combox1(JComboBox<String> comboKaryawan){
        try{
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM karyawan";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                comboKaryawan.addItem(rs.getString("name"));
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void combox2(JComboBox<String> comboKaryawan, JComboBox<String> comboAgenda) {
    try {
        getIdkaryawan(comboKaryawan);
        Connection kon = connect.koneksiDb();
        Statement st = kon.createStatement();
        String sql_tingkat = "SELECT * FROM ((agenda INNER JOIN team ON agenda.id_team = team.id_team) INNER JOIN team_details ON team.id_team = team_details.id_team) WHERE id_karyawan=" + idkaryawan;
        ResultSet rs = st.executeQuery(sql_tingkat);
        while (rs.next()) {
            comboAgenda.addItem(rs.getString("name"));
        }
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    public void comboagen(JComboBox<String> comboAgenda) {
    try {
        Connection kon = connect.koneksiDb();
        Statement st = kon.createStatement();
        String sql_tingkat = "SELECT * FROM ((agenda INNER JOIN team ON agenda.id_team = team.id_team) INNER JOIN team_details ON team.id_team = team_details.id_team)";
        ResultSet rs = st.executeQuery(sql_tingkat);
        while (rs.next()) {
            comboAgenda.addItem(rs.getString("name"));
        }
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

    public void getIdkaryawan(JComboBox<String> comboKaryawan){
           try{
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM karyawan WHERE name ='" + comboKaryawan.getSelectedItem() + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idkaryawan=rs.getInt("id_karyawan");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void getIdAgenda(JComboBox<String> comboAgenda){
           try{
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM (((agenda INNER JOIN team ON agenda.id_team = team.id_team) INNER JOIN team_details ON team.id_team = team_details.id_team)INNER JOIN finance_income ON agenda.id_agenda = finance_income.id_agenda) WHERE agenda.name ='" + comboAgenda.getSelectedItem() + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idagenda=rs.getInt("id_agenda");
                subtotalagenda=rs.getInt("subtotal");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void getIdJmlKaryawan(JComboBox<String> comboAgenda, JTextField subtotal, JTextField total) {
    try {
        getIdAgenda(comboAgenda); // Metode ini harus didefinisikan di tempat lain
        Connection kon = connect.koneksiDb();
        Statement st = kon.createStatement();
        String sql_tingkat = "SELECT COUNT(*) FROM agenda INNER JOIN team ON agenda.id_team = team.id_team INNER JOIN team_details ON team.id_team = team_details.id_team WHERE agenda.name ='" + comboAgenda.getSelectedItem() + "'";
        ResultSet rs = st.executeQuery(sql_tingkat);
        if (rs.next()) {
             jmlkaryawan = rs.getInt(1);
             subtotalgaji = subtotalagenda / jmlkaryawan;
             totalgaji = subtotalgaji + tunjangankaryawan;
            subtotal.setText(String.valueOf(subtotalgaji)); 
            total.setText(String.valueOf(totalgaji)); 
        }else{
            JOptionPane.showMessageDialog(null, "Maaf Data tidak ditemukan");
        }
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}   


    public void addSalary(JComboBox<String> comboKaryawan,JComboBox<String> comboAgenda,JTextField subtotal, JTextField total, JDateChooser tgl_salary){
        try{
            getIdkaryawan(comboKaryawan);
            getIdAgenda(comboAgenda);
             SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = String.valueOf(date.format(tgl_salary.getDate()));
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("INSERT INTO salary (id_agenda, id_karyawan, subtotal,total,date_salary) VALUES(?,?,?,?,?)"); 
            prs.setInt(1, idagenda);
            prs.setInt(2, idkaryawan);
            prs.setString(3, subtotal.getText());
            prs.setString(4, total.getText());
            prs.setString(5, tanggal);
             prs.execute();
              JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
    public void cekandconfirmDataSalary(JComboBox<String> comboKaryawan,JComboBox<String> comboAgenda,JTextField subtotal, JTextField total, JDateChooser tgl_salary) {
    try {
        getIdAgenda(comboAgenda);
        getIdkaryawan(comboKaryawan);// Metode ini harus didefinisikan di tempat lain
        Connection kon = connect.koneksiDb();
        Statement st = kon.createStatement();
        String sql_tingkat = "SELECT * FROM salary WHERE id_karyawan = " + idkaryawan + " AND id_agenda="+idagenda;
        ResultSet rs = st.executeQuery(sql_tingkat);
        if (rs.next()) {
             JOptionPane.showMessageDialog(null, "Maaf Telah Digaji");
        }else{
            addSalary(comboKaryawan,comboAgenda,subtotal,total,tgl_salary);
        }
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }
    public void updateSalary(JComboBox<String> comboKaryawan,JComboBox<String> comboAgenda,JTextField subtotal, JTextField total, JDateChooser tgl_salary){
        try{
            getIdkaryawan(comboKaryawan);
            getIdAgenda(comboAgenda);
             SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = String.valueOf(date.format(tgl_salary.getDate()));
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("Update salary set id_agenda = ?, id_karyawan = ?, subtotal = ?,total = ?,date_salary = ? WHERE id_karyawan = ? "); 
            prs.setInt(1, idagenda);
            prs.setInt(2, idkaryawan);
            prs.setString(3, subtotal.getText());
            prs.setString(4, total.getText());
            prs.setString(5, tanggal);
             prs.execute();
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
    DefaultTableModel tabel = new DefaultTableModel();

    public void tabel(JTable tabelSalary) {
    // Mengatur model tabel
    tabelSalary.setModel(tabel);
    
    // Menambahkan kolom pada model tabel
    tabel.addColumn("NAMA KARYAWAN");
    tabel.addColumn("NAMA AGENDA");
    tabel.addColumn("SUBTOTAL");
    tabel.addColumn("TOTAL");
    tabel.addColumn("TANGGAL");
    // Mengosongkan tabel sebelum menambahkan data baru
    tabel.setRowCount(0);
   
    String query = "SELECT karyawan.name,agenda.name, salary.subtotal,salary.total,salary.date_salary FROM salary INNER JOIN agenda ON salary.id_agenda = agenda.id_agenda INNER JOIN karyawan ON salary.id_karyawan = karyawan.id_karyawan ORDER BY karyawan.id_karyawan ASC";

    try {
        Connection conn = connect.koneksiDb(); // Memanggil koneksi
        Statement sttmnt = conn.createStatement(); // Membuat statement
        ResultSet rslt = sttmnt.executeQuery(query); // Menjalankan query

        // Inisialisasi nomor baris
        while (rslt.next()) {
            // Menampung data sementara
            String d1 = rslt.getString(1);
            String d2 = rslt.getString(2);
            String d3 = rslt.getString(3);
            String d4 = rslt.getString(4);
            String d5 = rslt.getString(5);

            // Menambahkan nomor baris ke data
            // Menambahkan semua data ke dalam array
            String[] data = {d1, d2, d3, d4, d5};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabel.addRow(data);
        }
    } catch (Exception e) {
        System.out.println("Error while populating table: " + e.getMessage());
    }
    
}
}

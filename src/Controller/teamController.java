/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yudo P
 */
public class teamController {
    private int radius;

//    public addTeam(int radius) {
//        super();
//        this.radius = 38;
//        setOpaque(false); // Tetapkan opasitas false agar latar belakang benar-benar transparan
//    }

    String idteam,idcategory;
    int[] idkaryawan,idkaryawanupdate;
    DefaultTableModel tabel = new DefaultTableModel();
    
    public void combox1(JComboBox<String> comboKategori){
        try{
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM team_category";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                comboKategori.addItem(rs.getString("name"));
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void getIdkategori(JComboBox<String> comboKategori){
           try{
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM team_category WHERE name ='" + comboKategori.getSelectedItem() + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idcategory=rs.getString("id_kat_team");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void addTeam(JComboBox<String> comboKategori, JTextField txtNameTeam, JTextField txtInformation, JTable tabelKaryawan){
        if(tabelKaryawan.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Maaf Tambah Anggota team dulu");
        }else if(txtNameTeam.getText()==null){
            JOptionPane.showMessageDialog(null, "Maaf isi nama team");
        }else{
        try{
            getIdkategori(comboKategori);
            
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("INSERT INTO team (name, information, id_kat_team) VALUES(?,?,?)"); 
            prs.setString(1, txtNameTeam.getText());
            prs.setString(2, txtInformation.getText());
            prs.setString(3, idcategory);
             prs.execute();
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
        }
    }
    private void getIdteam(JTextField txtNameTeam){
        try{
            java.sql.Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM team WHERE name ='" + txtNameTeam.getText() + "';";
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
        private void getIdkaryawan(JTextField txtNameTeam, JTable tabelKaryawan, JTextField jmlKaryawan ) {
    try {
        java.sql.Connection kon = connect.koneksiDb();
        int jml = Integer.parseInt(jmlKaryawan.getText());
        int row1 = tabelKaryawan.getRowCount();
        int jumlahKaryawan = Math.min(jml, row1); // Ambil nilai yang lebih kecil dari jml dan row1
        idkaryawan = new int[row1];
        if(row1>0){
        for (int i = 0; i < jumlahKaryawan; i++) {
            String namaKaryawan = tabelKaryawan.getValueAt(i, 1).toString(); // Ubah indeks kolom ke 1 jika nama karyawan ada di sana
            if (namaKaryawan != null) {
                
                String sql_tingkat = "SELECT id_karyawan FROM karyawan WHERE name = ?";
                PreparedStatement pstmt = kon.prepareStatement(sql_tingkat);
                pstmt.setString(1, namaKaryawan);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    idkaryawan[i] = rs.getInt("id_karyawan");
                } 
                rs.close();
                
            } 
        }}else {
            System.out.println("No rows in the table.");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
        private void getIdkaryawanupdate(JTextField txtNameTeam, JTable tabelKaryawan, JTextField jmlKaryawan ) {
    try {
        java.sql.Connection kon = connect.koneksiDb();
        int jml = Integer.parseInt(jmlKaryawan.getText());
        int row1 = tabelKaryawan.getRowCount();
        int jumlahKaryawan = Math.min(jml, row1); // Ambil nilai yang lebih kecil dari jml dan row1
        idkaryawanupdate = new int[row1];
        if(row1>0){
        for (int i = 0; i < jumlahKaryawan; i++) {
            idkaryawanupdate[i] = (int) tabelKaryawan.getValueAt(row1, i);
        }}else {
            System.out.println("No rows in the table.");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}




    private void addTeamdetail(JTextField txtNameTeam, JTable tabelKaryawan, JTextField jmlKaryawan,JComboBox<String> comboKategori,JTextField txtInformation){
        if(tabelKaryawan.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Maaf Tambah Anggota team dulu");
        }else if(txtNameTeam.getText()==null){
            JOptionPane.showMessageDialog(null, "Maaf isi nama team");
        }else{
        try{
            addTeam(comboKategori,txtNameTeam,txtInformation,tabelKaryawan);
            getIdteam(txtNameTeam);
            getIdkaryawan(txtNameTeam,tabelKaryawan,jmlKaryawan);
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("INSERT INTO team_details (id_karyawan,id_team) VALUES(?,?)"); 
           int row1 = tabelKaryawan.getRowCount();
        for(int i = 0; i<row1; i++){
            prs.setInt(1, idkaryawan[i]);
            prs.setString(2, idteam);
            prs.execute();
        }
            
             JOptionPane.showMessageDialog(null, "Data Berhasil Di Masukan");
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
           System.out.println(e.getMessage());
        }
        }
    }
     private void updateTeam(JComboBox<String> comboKategori, JTextField txtNameTeam, JTextField txtInformation, JTable tabelKaryawan){
        if(tabelKaryawan.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Maaf Tambah Anggota team dulu");
        }else if(txtNameTeam.getText()==null){
            JOptionPane.showMessageDialog(null, "Maaf isi nama team");
        }else{
        try{
            getIdkategori(comboKategori);
            
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("UPDATE team set name = ?, information = ?, id_kat_team = ? WHERE name = ? OR information = ?"); 
            prs.setString(1, txtNameTeam.getText());
            prs.setString(2, txtInformation.getText());
            prs.setString(3, idcategory);
            prs.setString(4, txtNameTeam.getText());
            prs.setString(5, txtInformation.getText());
             prs.execute();
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
        }
    }
     private void updateTeamDetail(JTextField txtNameTeam, JTable tabelKaryawan, JTextField jmlKaryawan,JComboBox<String> comboKategori,JTextField txtInformation) {
    if (tabelKaryawan.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Maaf, tambahkan anggota tim terlebih dahulu");
    } else if (txtNameTeam.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Maaf, isi nama tim");
    } else {
        
        Connection kon = null;
        PreparedStatement pstmt = null;
        try {
            getIdkategori(comboKategori);
            getIdteam(txtNameTeam);
            getIdkaryawan(txtNameTeam,tabelKaryawan,jmlKaryawan);
            getIdkaryawanupdate(txtNameTeam,tabelKaryawan,jmlKaryawan);
            kon = connect.koneksiDb();

            // Get the number of existing team members
            int existingMembers = 0;
            pstmt = kon.prepareStatement("SELECT COUNT(*) AS total FROM team_detail WHERE id_team = ?");
            pstmt.setString(1, idteam);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                existingMembers = rs.getInt("total");
            }

            // Insert new members if the number of team members in the table is greater than the existing members
            if (tabelKaryawan.getRowCount() > existingMembers) {
                pstmt = kon.prepareStatement("INSERT INTO team_detail (id_karyawan, id_team) VALUES (?, ?)");
                int row1 = tabelKaryawan.getRowCount();
                for (int i = existingMembers; i < row1; i++) {
                    pstmt.setInt(1, idkaryawan[i]);
                    pstmt.setString(2, idteam);
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            }else{
                pstmt = kon.prepareStatement("Update team_detail set id_karyawan =?, id_team=? WHERE id_karyawan=?");
                int row1 = tabelKaryawan.getRowCount();
                for (int i = existingMembers; i < row1; i++) {
                    pstmt.setInt(1, idkaryawan[i]);
                    pstmt.setString(2, idteam);
                    pstmt.setInt(3, idkaryawanupdate[i]);
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            }

            // Update existing team members
           

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (kon != null) kon.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
     }
}

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
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

    int idteam,idcategory,jmlkar;
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
                idcategory=rs.getInt("id_kat_team");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void addTeam(JComboBox<String> comboKategori, JTextField txtNameTeam, JTextField txtInformation, JTable tabelKaryawan){
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
            prs.setInt(3, idcategory);
             prs.execute();
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
        }
        
    }
    public void getIdteam(JTextField txtNameTeam){
        try{
            java.sql.Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM team WHERE name ='" + txtNameTeam.getText() + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idteam=rs.getInt("id_team");
              
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
        public void getIdkaryawan(JTextField txtNameTeam, JTable tabelKaryawan, JSpinner jmlKaryawan ) {
    try {
        java.sql.Connection kon = connect.koneksiDb();
        int jml = Integer.parseInt(jmlKaryawan.getValue().toString());
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
        JOptionPane.showMessageDialog(null, "asdfsdf" + e.getMessage());
    }
}
        
public void getIdteamupdate(JTable tabelTeam) {
    try {
        int selectedRow = tabelTeam.getSelectedRow();
        String teamName = tabelTeam.getValueAt(selectedRow, 0).toString(); // Assuming team name is in column index 0
        java.sql.Connection kon = connect.koneksiDb();
        String sql_tingkat = "SELECT id_team FROM team WHERE name = ?";
        PreparedStatement pstmt = kon.prepareStatement(sql_tingkat);
        pstmt.setString(1, teamName);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            idteam = rs.getInt("id_team");
        }
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
     public void setTabelteamupdate(JTable tabelTeam, JTable tabelKaryawan, JSpinner jmlkaryawan) {
    try {
        getIdteamupdate(tabelTeam);
        java.sql.Connection kon = connect.koneksiDb();
        int row1 = tabelTeam.getSelectedRowCount();
        if (row1 > 0) {
            // Initialize the table model
            DefaultTableModel tabelkarya = new DefaultTableModel();
            headerTabel(tabelkarya);
            
            String sql_tingkat = "SELECT COUNT(*) AS jmlkaryawan FROM team_details WHERE id_team = ?";
            PreparedStatement pstmt = kon.prepareStatement(sql_tingkat);
            pstmt.setInt(1, idteam);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                jmlkar = rs.getInt("jmlkaryawan");
                jmlkaryawan.setValue(jmlkar);
            }
            rs.close();

            // Loop through employee details and add them to the table model
            for (int i = 0; i < jmlkar; i++) {
                sql_tingkat = "SELECT * FROM karyawan WHERE id_karyawan = (SELECT id_karyawan FROM team_details WHERE id_team = ? LIMIT ?, 1)";
                pstmt = kon.prepareStatement(sql_tingkat);
                pstmt.setInt(1, idteam);
                pstmt.setInt(2, i);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    // Assuming karyawan name should be set in column index 1
                    String name = rs.getString("name");
                    String[] data = {String.valueOf(i + 1), name};
                    tabelkarya.addRow(data);
                }
                rs.close();
            }

            tabelKaryawan.setModel(tabelkarya); // Set the table model for tabelKaryawan
          
        } else {
            JOptionPane.showMessageDialog(null,"No rows in the table.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

    public void addTeamdetail(JTextField txtNameTeam, JTable tabelKaryawan, JSpinner jmlKaryawan,JComboBox<String> comboKategori){
        if(tabelKaryawan.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Maaf Tambah Anggota team dulu");
        }else if(txtNameTeam.getText()==null){
            JOptionPane.showMessageDialog(null, "Maaf isi nama team");
        }else{
        try{
            getIdteam(txtNameTeam);
            getIdkaryawan(txtNameTeam,tabelKaryawan,jmlKaryawan);
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); 
            PreparedStatement prs = kon.prepareStatement("INSERT INTO team_details (id_karyawan,id_team) VALUES(?,?)"); 
            int row1 = tabelKaryawan.getRowCount();
            for(int i = 0; i<row1; i++){
                prs.setInt(1, idkaryawan[i]);
                prs.setInt(2, idteam);
                prs.execute();
            }
            
             JOptionPane.showMessageDialog(null, "Data Berhasil Di Masukan");
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
        }
    }
     public void updateTeam(JComboBox<String> comboKategori, JTextField txtNameTeam, JTextField txtInformation, JTable tabelKaryawan){
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
            prs.setInt(3, idcategory);
            prs.setString(4, txtNameTeam.getText());
            prs.setString(5, txtInformation.getText());
             prs.execute();
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
        }
    }
     public void updateTeamDetail(JTextField txtNameTeam, JTable tabelKaryawan, JSpinner jmlKaryawan,JComboBox<String> comboKategori,JTextField txtInformation) {
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
            
            kon = connect.koneksiDb();

            // Get the number of existing team members
            int existingMembers = 0;
            pstmt = kon.prepareStatement("SELECT COUNT(*) AS total FROM team_detail WHERE id_team = ?");
            pstmt.setInt(1, idteam);
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
                    pstmt.setInt(2, idteam);
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            }else{
                pstmt = kon.prepareStatement("Update team_detail set id_karyawan =?, id_team=? WHERE id_karyawan=?");
                int row1 = tabelKaryawan.getRowCount();
                for (int i = existingMembers; i < row1; i++) {
                    pstmt.setInt(1, idkaryawan[i]);
                    pstmt.setInt(2, idteam);
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
    
    DefaultTableModel tabelteam = new DefaultTableModel();
    DefaultTableModel tabelkarya = new DefaultTableModel();
   
    DefaultTableModel tabelteamdetail = new DefaultTableModel();
    public void headerTeam(){
        tabelteam.addColumn("Nama Team");
        tabelteam.addColumn("Deskripsi");
        tabelteam.addColumn("Kategori");
    }
    public void tampilTeam(JTable tabelTeam){
    int rowCount = tabelteam.getRowCount(); // Periksa jumlah baris dalam model tabel
    for(int a = 0 ; a < rowCount ; a++){
        tabelteam.removeRow(0); // Hapus baris dari model tabel, bukan dari tabelnya
    }
    String query = "SELECT team.name,information, team_category.name FROM (team inner join team_category ON team.id_kat_team = team_category.id_kat_team) ORDER BY id_team ASC";

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
            
            // Menambahkan semua data ke dalam array
            String[] data = {d1, d2, d3};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabelteam.addRow(data);
        }
        // Mengeset nilai yang ditampung agar muncul di tabel
        tabelTeam.setModel(tabelteam);
    } catch (Exception e) {
        System.out.println(e);
    }
}
    public void cariTeam(JTable tabelTeam,JTextField cari){
    int rowCount = tabelteam.getRowCount(); // Periksa jumlah baris dalam model tabel
    for(int a = 0 ; a < rowCount ; a++){
        tabelteam.removeRow(0); // Hapus baris dari model tabel, bukan dari tabelnya
    }
    String query = "SELECT team.name,information, team_category.name FROM (team inner join team_category ON team.id_kat_team = team_category.id_kat_team) WHERE team.name ='"+cari.getText()+"'";

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
            
            // Menambahkan semua data ke dalam array
            String[] data = {d1, d2, d3};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabelteam.addRow(data);
        }
        // Mengeset nilai yang ditampung agar muncul di tabel
        tabelTeam.setModel(tabelteam);
    } catch (Exception e) {
        System.out.println(e);
    }
}
    public void headerTeamdetail(){
        tabelteamdetail.addColumn("Nama Karyawan");
    tabelteamdetail.addColumn("Posisi");
    tabelteamdetail.addColumn("Dalam Team");
    }
  public void tampilTeamdetail(JTable tabelTeamdetail) {
    int rowCount = tabelteamdetail.getRowCount(); // Periksa jumlah baris dalam model tabel
    for(int a = 0 ; a < rowCount ; a++){
        tabelteamdetail.removeRow(0); // Hapus baris dari model tabel, bukan dari tabelnya
    }

    String query = "SELECT karyawan.name, karyawan.possition, GROUP_CONCAT(team.name) AS team_names " +
                   "FROM karyawan " +
                   "LEFT JOIN team_details ON karyawan.id_karyawan = team_details.id_karyawan " +
                   "LEFT JOIN team ON team_details.id_team = team.id_team " +
                   "GROUP BY karyawan.id_karyawan " +
                   "ORDER BY karyawan.id_karyawan ASC;";

    try {
        Connection conn = connect.koneksiDb();
        Statement sttmnt = conn.createStatement();
        ResultSet rslt = sttmnt.executeQuery(query);

        while (rslt.next()) {
            String employeeName = rslt.getString("name");
            String position = rslt.getString("possition");
            String teamNames = rslt.getString("team_names");
            String teamStatus;

            if (teamNames == null || teamNames.isEmpty()) {
                teamStatus = "Tidak Bergabung";
            } else {
                teamStatus = teamNames;
            }

            String[] data = {employeeName, position, teamStatus};
            tabelteamdetail.addRow(data);
        }
        tabelTeamdetail.setModel(tabelteamdetail); // Set the model after iterating through the result set

    } catch (Exception e) {
        System.out.println(e);
    }
}
  public void cariDetail(JTable tabelTeamdetail,JTextField cari) {
    int rowCount = tabelteamdetail.getRowCount(); // Periksa jumlah baris dalam model tabel
    for(int a = 0 ; a < rowCount ; a++){
        tabelteamdetail.removeRow(0); // Hapus baris dari model tabel, bukan dari tabelnya
    }

    String query = "SELECT karyawan.name, karyawan.possition, GROUP_CONCAT(team.name) AS team_names " +
                   "FROM karyawan " +
                   "LEFT JOIN team_details ON karyawan.id_karyawan = team_details.id_karyawan " +
                   "LEFT JOIN team ON team_details.id_team = team.id_team WHERE team.name ='"+cari.getText()+"' OR karyawan.name ='"+cari.getText()+"'"+
                   "GROUP BY karyawan.id_karyawan " +
                   "ORDER BY karyawan.id_karyawan ASC;";

    try {
        Connection conn = connect.koneksiDb();
        Statement sttmnt = conn.createStatement();
        ResultSet rslt = sttmnt.executeQuery(query);

        while (rslt.next()) {
            String employeeName = rslt.getString("name");
            String position = rslt.getString("possition");
            String teamNames = rslt.getString("team_names");
            String teamStatus;

            if (teamNames == null || teamNames.isEmpty()) {
                teamStatus = "Tidak Bergabung";
            } else {
                teamStatus = teamNames;
            }

            String[] data = {employeeName, position, teamStatus};
            tabelteamdetail.addRow(data);
        }
        tabelTeamdetail.setModel(tabelteamdetail); // Set the model after iterating through the result set

    } catch (Exception e) {
        System.out.println(e);
    }
}
    public void headerTabel(DefaultTableModel tabelkarya){
    tabelkarya.addColumn("NO");
    tabelkarya.addColumn("Nama Karyawan");
}

    public void tambahTabel(JTable tabelKaryawan, JSpinner jmlKaryawan) {
    DefaultTableModel model = (DefaultTableModel) tabelKaryawan.getModel();

    if (model.getRowCount() == 0) {
        int jml = (int) jmlKaryawan.getValue();
        int no = 1; // Start the numbering from 1
        for (int i = 0; i < jml; i++) {
            model.addRow(new Object[]{no++});
        }
    } else {
        // Get the highest number from the existing rows
        int lastRow = model.getRowCount() - 1; // Index of the last row
        int lastNumber = Integer.parseInt(model.getValueAt(lastRow, 0).toString());

        int jml = (int) jmlKaryawan.getValue() - model.getRowCount();
        int no = lastNumber + 1; // Start numbering from the next number after the last one
        for (int i = 0; i < jml; i++) {
            model.addRow(new Object[]{no++});
        }
    }
}
    public void deleteTeamdetail(JTable tabelTeam){
       int update= JOptionPane.showOptionDialog(null,"apakah yakin hapus data?","Hapus Data",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
            if(update == JOptionPane.YES_OPTION){
            try{
                 getIdteamupdate(tabelTeam);
                 Connection kon = connect.koneksiDb();
                 Statement st = kon.createStatement();
                 int row1 = tabelTeam.getSelectedRow();
                 String sql_del = "DELETE from team_details WHERE id_team='"+idteam+"'";
                 st.execute(sql_del);
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Gagal"+e);
             }
        }
   }
   public void deleteTeam(JTable tabelTeam,JTable tabelTeamdetail){
            try{
                 deleteTeamdetail(tabelTeam);
                 Connection kon = connect.koneksiDb();
                 Statement st = kon.createStatement();
                 int row1 = tabelTeam.getSelectedRow();
                 String sql_del = "DELETE from team WHERE name='"+tabelTeam.getValueAt(row1, 0)+"'";
                 st.execute(sql_del);
                 JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
                  tampilTeam(tabelTeam);
                tampilTeamdetail(tabelTeamdetail);
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Gagal"+e);
             }
   }
   private Timer timer;
   public void startTimer(final JTable tabelTeam, final JTable tabelTeamdetail) {
    timer = new Timer(100000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Pass the text fields to updateDateTime
            tampilTeam(tabelTeam);
            tampilTeamdetail(tabelTeamdetail);
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

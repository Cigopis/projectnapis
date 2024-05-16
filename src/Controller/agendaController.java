/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import static Controller.AbsensiController.FILE_PATH;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Yudo P
 */
public class agendaController {
    DefaultTableModel tabel = new DefaultTableModel();
    
    int total,subtotal,sumsubtotal;
    public static final String FILE_PATH = "C:\\Users\\Yudo P\\Documents\\absensi\\formatinvoice.xlsx";
    String idcategory,idteam,idklien,idagenda;
    public void combox1(JComboBox<String> comboKat){
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
    public void combox2(JComboBox<String> comboNamaInstansi){
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
    public void combox3(JComboBox<String> comboNamaTeam){
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
    
    public void addAgenda(JTextField txtNamaAcara,JTextArea areaCatatan,JTextField txtBiaya, JDateChooser tgl_mulai, JDateChooser tgl_selesai, JComboBox<String> comboKat, JComboBox<String> comboNamaInstansi,JComboBox<String> comboNamaTeam){
        try{
            getIdkategori(comboKat);
        getIdTeam(comboNamaTeam);
        getIdKlien(comboNamaInstansi);
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_start = String.valueOf(date.format(tgl_mulai.getDate()));
            String tgl_end = String.valueOf(date.format(tgl_selesai.getDate()));
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("INSERT INTO agenda (id_team,id_kat_agenda,id_klien,name,information,price,status,date_start,date_end) VALUES(?,?,?,?,?,?,'unreceived payment',?,?)"); 
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

public void addFinance(JTextField txtNamaAcara,JTextArea areaCatatan,JTextField txtBiaya, JDateChooser tgl_mulai, JDateChooser tgl_selesai, JComboBox<String> comboKat, JComboBox<String> comboNamaInstansi,JComboBox<String> comboNamaTeam) {
    try {
        getIdAgenda(txtNamaAcara);
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

public void updatetotalFinance() {
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
 public void updateAgenda(JTextField txtNamaAcara,JTextArea areaCatatan,JTextField txtBiaya, JDateChooser tgl_mulai, JDateChooser tgl_selesai, JComboBox<String> comboKat, JComboBox<String> comboNamaInstansi,JComboBox<String> comboNamaTeam){
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
     

public void updateFinance(JTextField txtNamaAcara,JTextArea areaCatatan,JTextField txtBiaya, JDateChooser tgl_mulai, JDateChooser tgl_selesai) {
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

   public void headerAgenda(){
    tabel.addColumn("NO");
    tabel.addColumn("NAME PROJECT");
    tabel.addColumn("CATEGORY");
    tabel.addColumn("INFORMATION");
    tabel.addColumn("DATE START");
    tabel.addColumn("DATE END");
   }
   public void header(){
    tabel.addColumn("NO");
    tabel.addColumn("NAME PROJECT");
    tabel.addColumn("CATEGORY");
    tabel.addColumn("NAME TEAM");
    tabel.addColumn("NAME INSTANSI");
    tabel.addColumn("INFORMATION");
    tabel.addColumn("STATUS");
   }
    public void tabel(JTable tabelAgenda) {
    
    // Mengosongkan tabel sebelum menambahkan data baru
    int row = tabel.getRowCount();
        for(int a = 0 ; a < row ; a++){
            tabel.removeRow(0);
        }
   
    String query = "SELECT * FROM agenda INNER JOIN agenda_category ON agenda.id_kat_agenda = agenda_category.id_kat_agenda INNER JOIN team ON agenda.id_team = team.id_team INNER JOIN klien ON agenda.id_klien = klien.id_klien ORDER BY id_agenda ASC";

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
            String[] data = {nomer, d1, d2, d3,d4,d5};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabel.addRow(data);
        }
        tabelAgenda.setModel(tabel);
    } catch (Exception e) {
        System.out.println("Error while populating table: " + e.getMessage());
    }
}
    public void tabelAgenda(JTable tabelAgenda) {
    
    // Mengosongkan tabel sebelum menambahkan data baru
    int row = tabel.getRowCount();
        for(int a = 0 ; a < row ; a++){
            tabel.removeRow(0);
        }
   
    String query = "SELECT * FROM agenda INNER JOIN agenda_category ON agenda.id_kat_agenda = agenda_category.id_kat_agenda INNER JOIN team ON agenda.id_team = team.id_team INNER JOIN klien ON agenda.id_klien = klien.id_klien ORDER BY id_agenda ASC";

    try {
        Connection conn = connect.koneksiDb(); // Memanggil koneksi
        Statement sttmnt = conn.createStatement(); // Membuat statement
        ResultSet rslt = sttmnt.executeQuery(query); // Menjalankan query

        int no = 1; // Inisialisasi nomor baris
        while (rslt.next()) {
            // Menampung data sementara
            String d1 = rslt.getString("agenda.name");
            String d2 = rslt.getString("agenda_category.name");
            String d3 = rslt.getString("team.name");
            String d4 = rslt.getString("klien.name_instansi");
            String d5 = rslt.getString("agenda.information");
             String d6 = rslt.getString("agenda.status");
            // Menambahkan nomor baris ke data
            String nomer = String.valueOf(no++);
            // Menambahkan semua data ke dalam array
            String[] data = {nomer, d1, d2, d3,d4,d5,d6};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabel.addRow(data);
        }
        tabelAgenda.setModel(tabel);
    } catch (Exception e) {
        System.out.println("Error while populating table: " + e.getMessage());
    }
}
   public void cariAgenda(JTable tabelAgenda, JTextField cari) {
    
    // Mengosongkan tabel sebelum menambahkan data baru
    int row = tabel.getRowCount();
        for(int a = 0 ; a < row ; a++){
            tabel.removeRow(0);
        }
   
    String query = "SELECT * FROM agenda INNER JOIN agenda_category ON agenda.id_kat_agenda = agenda_category.id_kat_agenda INNER JOIN team ON agenda.id_team = team.id_team INNER JOIN klien ON agenda.id_klien = klien.id_klien WHERE agenda.name='"+cari.getText()+"' OR klien.name_instansi='"+cari.getText()+"' OR klien.name_klien='"+cari.getText()+"' OR team.name='"+cari.getText()+"'";

    try {
        Connection conn = connect.koneksiDb(); // Memanggil koneksi
        Statement sttmnt = conn.createStatement(); // Membuat statement
        ResultSet rslt = sttmnt.executeQuery(query); // Menjalankan query

        int no = 1; // Inisialisasi nomor baris
        while (rslt.next()) {
            // Menampung data sementara
            String d1 = rslt.getString("agenda.name");
            String d2 = rslt.getString("agenda_category.name");
            String d3 = rslt.getString("team.name");
            String d4 = rslt.getString("klien.name_instansi");
            String d5 = rslt.getString("agenda.information");
             String d6 = rslt.getString("agenda.status");
            // Menambahkan nomor baris ke data
            String nomer = String.valueOf(no++);
            // Menambahkan semua data ke dalam array
            String[] data = {nomer, d1, d2, d3,d4,d5,d6};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabel.addRow(data);
        }
        tabelAgenda.setModel(tabel);
    } catch (Exception e) {
        System.out.println("Error while populating table: " + e.getMessage());
    }
}
     private int nextNumber = 1; // Menyimpan nomor urut berikutnya
    
    public void simpanDataKeExcel(JTextField namaAcara, JComboBox<String> comboNamaInstansi, JTextArea alamat, JDateChooser tanggal, JTextField txtsubharga, JTextField txtTotalbiaya) {
        try {
            // Membuat objek JFileChooser
            JFileChooser fileChooser = new JFileChooser();

            // Menambahkan filter untuk hanya memilih file Excel
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xlsx", "xls");
            fileChooser.setFileFilter(filter);

            // Menampilkan dialog untuk memilih lokasi dan nama file
            int returnValue = fileChooser.showSaveDialog(null);

            // Jika pengguna memilih file dan menekan tombol "Simpan"
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();

                // Membuat direktori jika belum ada
                File parentDir = selectedFile.getParentFile();
                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }

                // Jika pengguna tidak memasukkan ekstensi file, tambahkan ekstensi ".xlsx"
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                // Membuat workbook baru jika file belum ada, atau menggunakan yang sudah ada jika sudah ada
                XSSFWorkbook workbook;
                if (selectedFile.exists()) {
                    FileInputStream fis = new FileInputStream(selectedFile);
                    workbook = new XSSFWorkbook(fis);
                } else {
                    workbook = new XSSFWorkbook();
                }

                XSSFSheet sheet = workbook.getSheetAt(0); // Mengambil sheet pertama atau buat sheet baru jika belum ada
                if (sheet == null) {
                    sheet = workbook.createSheet("Data");
                }

                // Ambil data dari komponen GUI
                String namaacara=namaAcara.getText();
                String namaInstansi = (String) comboNamaInstansi.getSelectedItem();
                String alamatInstansi = alamat.getText();
                String nomor = generateNomorSurat(tanggal.getDate());

                // Add the total price to the Excel sheet
                addDataToSheet(sheet, comboNamaInstansi, alamat, nomor, tanggal, txtsubharga, txtTotalbiaya);

                // Generate nama file baru dengan format yang ditentukan
                String newFilePath = generateNewFilePath(parentDir.getAbsolutePath(), namaacara, namaInstansi, nomor);

                // Simpan workbook ke file Excel baru
                FileOutputStream outputStream = new FileOutputStream(newFilePath);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private String generateNomorSurat(Date tanggal) {
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");

        String year = sdfYear.format(tanggal);
        int monthNumber = Integer.parseInt(sdfMonth.format(tanggal));
        String monthRoman = convertToRoman(monthNumber);

        // Format nomor surat: "KP-X.Y/CV.MKN-Z/MM/YYYY"
        String nomorSurat = "KP-" + nextNumber + ".3/CV.MKN-18.1/" + monthRoman + "/" + year;
        nextNumber++; // Increment nomor untuk urutan berikutnya

        return nomorSurat.replace("/", "-"); // Replace invalid characters with valid ones
    }

    private String convertToRoman(int monthNumber) {
        String[] romanMonths = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};
        return romanMonths[monthNumber - 1];
    }

    public void addDataToSheet(XSSFSheet sheet, JComboBox<String> comboNamaInstansi, JTextArea alamat, String nomor, JDateChooser tanggal, JTextField txtsubharga, JTextField txtTotalbiaya) {
        // Mengambil baris yang telah ditentukan
        int rowNumKlien = 22; // Baris untuk klien (G23)
        int rowNumAlamat = 25; // Baris untuk alamat (G26)
        int colNumKlien = 6; // Kolom untuk klien (G)
        int colNumAlamat = 6; // Kolom untuk alamat (G)
        int colNumNomor = 13; // Kolom untuk nomor (N)
        int colNumTanggal = 13; // Kolom untuk tanggal (N)
        int colNumHarga = 14;
        int rowJml = 50;
        int rowPpn = 51;
        int rowTot = 52;
        int rowPembilang = 37;

        // Membuat cell style untuk mengatur tampilan sel
        XSSFCellStyle style = sheet.getWorkbook().createCellStyle();

        // Memasukkan data klien
        XSSFRow rowKlien = sheet.getRow(rowNumKlien);
        if (rowKlien == null) {
            rowKlien = sheet.createRow(rowNumKlien);
        }
        rowKlien.createCell(colNumKlien).setCellValue(comboNamaInstansi.getSelectedItem().toString());
        rowKlien.getCell(colNumKlien).setCellStyle(style);

        // Memasukkan data alamat
        XSSFRow rowAlamat = sheet.getRow(rowNumAlamat);
        if (rowAlamat == null) {
            rowAlamat = sheet.createRow(rowNumAlamat);
        }
        rowAlamat.createCell(colNumAlamat).setCellValue(alamat.getText());
        rowAlamat.getCell(colNumAlamat).setCellStyle(style);

        // Memasukkan data nomor
        XSSFRow rowNomor = sheet.getRow(rowNumKlien);
        if (rowNomor == null) {
            rowNomor = sheet.createRow(rowNumKlien);
        }
        rowNomor.createCell(colNumNomor).setCellValue(nomor);
        rowNomor.getCell(colNumNomor).setCellStyle(style);

        // Memasukkan data tanggal
        XSSFRow rowTanggal = sheet.getRow(rowNumAlamat);
        if (rowTanggal == null) {
            rowTanggal = sheet.createRow(rowNumAlamat);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tgl = dateFormat.format(tanggal.getDate());
        rowTanggal.createCell(colNumTanggal).setCellValue(tgl);
        rowTanggal.getCell(colNumTanggal).setCellStyle(style);

        // Menghitung subharga, total harga, dan PPN
        double subharga = Double.parseDouble(txtsubharga.getText());
        double totalharga = Double.parseDouble(txtTotalbiaya.getText());
 double totalRounded = Math.round(totalharga);
        double ppn = totalharga - subharga;

        // Memasukkan data subharga
        XSSFRow rowSubBiaya = sheet.getRow(rowJml);
        if (rowSubBiaya == null) {
            rowSubBiaya = sheet.createRow(rowJml);
        }
        rowSubBiaya.createCell(colNumHarga).setCellValue(subharga);
        rowSubBiaya.getCell(colNumHarga).setCellStyle(style);

        // Memasukkan data PPN
        XSSFRow rowPpnBiaya = sheet.getRow(rowPpn);
        if (rowPpnBiaya == null) {
            rowPpnBiaya = sheet.createRow(rowPpn);
        }
        rowPpnBiaya.createCell(colNumHarga).setCellValue(ppn);
        rowPpnBiaya.getCell(colNumHarga).setCellStyle(style);

        // Memasukkan data total harga
        XSSFRow rowTotalBiaya = sheet.getRow(rowTot);
        if (rowTotalBiaya == null) {
            rowTotalBiaya = sheet.createRow(rowTot);
        }
        rowTotalBiaya.createCell(colNumHarga).setCellValue(totalharga);
        rowTotalBiaya.getCell(colNumHarga).setCellStyle(style);

        // Memasukkan data total harga dalam format mata uang
        XSSFRow rowPembilangan = sheet.getRow(rowPembilang);
        if (rowPembilangan == null) {
            rowPembilangan = sheet.createRow(rowPembilang);
        }
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID")); // Set lokal ke Bahasa Indonesia
        String totalHargaString = format.format(totalRounded); // Ubah totalharga menjadi format mata uang dengan lokal Indonesia
        rowPembilangan.createCell(colNumNomor).setCellValue(totalHargaString);
        rowPembilangan.getCell(colNumNomor).setCellStyle(style);
    }

    private String generateNewFilePath(String parentDir, String namaAcara, String namaInstansi, String nomorSurat) {
        // Menggabungkan path direktori dan nama file baru dengan mengganti karakter yang tidak valid
        String fileName = namaAcara + "_" + namaInstansi + "_" + nomorSurat.replace("/", "-") + ".xlsx";
        return new File(parentDir, fileName).getAbsolutePath();
    }
    
    private int nextNumberKwitansi = 1; // Inisialisasi nilai nextNumberKwitansi

    public void simpanDataKeExcelKwitansi(JTable tabelagenda) {
        try {
            // Membuat objek JFileChooser
            JFileChooser fileChooser = new JFileChooser();

            // Menambahkan filter untuk hanya memilih file Excel
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xlsx", "xls");
            fileChooser.setFileFilter(filter);

            // Menampilkan dialog untuk memilih lokasi dan nama file
            int returnValue = fileChooser.showSaveDialog(null);

            // Jika pengguna memilih file dan menekan tombol "Simpan"
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();

                // Membuat direktori jika belum ada
                File parentDir = selectedFile.getParentFile();
                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }

                // Jika pengguna tidak memasukkan ekstensi file, tambahkan ekstensi ".xlsx"
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                // Membuat workbook baru jika file belum ada, atau menggunakan yang sudah ada jika sudah ada
                XSSFWorkbook workbook;
                if (selectedFile.exists()) {
                    FileInputStream fis = new FileInputStream(selectedFile);
                    workbook = new XSSFWorkbook(fis);
                } else {
                    workbook = new XSSFWorkbook();
                }

                XSSFSheet sheet = workbook.getSheetAt(0); // Mengambil sheet pertama atau buat sheet baru jika belum ada
                if (sheet == null) {
                    sheet = workbook.createSheet("Data");
                }

                // Ambil data dari komponen GUI
                int row = tabelagenda.getSelectedRow();
                String namaacara= tabelagenda.getValueAt(row, 1).toString();
                String namaInstansi = tabelagenda.getValueAt(row, 2).toString();
                String alamatInstansi = tabelagenda.getValueAt(row, 3).toString();
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                Date tanggal = new Date();
                
                String nomorkwi = generateNomorSuratKwitansi(tanggal);
                // Add the total price to the Excel sheet
                addDataToSheetKwitansi(sheet,nomorkwi);

                // Generate nama file baru dengan format yang ditentukan
                String newFilePath = generateNewFilePath(parentDir.getAbsolutePath(), namaacara, namaInstansi, nomorkwi);

                // Simpan workbook ke file Excel baru
                FileOutputStream outputStream = new FileOutputStream(newFilePath);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
            
            System.out.println(e.getMessage());
        }
    }

    public String generateNomorSuratKwitansi(Date tanggal) {
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");

        String year = sdfYear.format(tanggal);
        int monthNumber = Integer.parseInt(sdfMonth.format(tanggal));
        String monthRoman = convertToRomanKwitansi(monthNumber);

        // Format nomor surat: "KP-X.Y/CV.MKN-Z/MM/YYYY"
        String nomorSurat = "KP-" + nextNumberKwitansi + ".2/CV.MKN-18.1/" + monthRoman + "/" + year;
        nextNumberKwitansi++; // Increment nomor untuk urutan berikutnya

        return nomorSurat.replace("/", "-"); // Replace invalid characters with valid ones
    }

    private String convertToRomanKwitansi(int monthNumber) {
        String[] romanMonths = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};
        return romanMonths[monthNumber - 1];
    }

    public void addDataToSheetKwitansi(XSSFSheet sheet, String nomorkwi) {
        // Mengambil baris yang telah ditentukan
        int rowNumkwi = 1; // Baris yang ingin Anda akses (baris 1)
        int colNumkwi = 1; // Kolom yang ingin Anda akses (kolom B)

        // Membuat cell style untuk mengatur tampilan sel

        // Mendapatkan atau membuat baris yang diinginkan
        XSSFRow rowKwi = sheet.getRow(rowNumkwi);
        if (rowKwi == null) {
            rowKwi = sheet.createRow(rowNumkwi);
        }

        // Mendapatkan atau membuat sel di kolom yang diinginkan
        XSSFCell cellKwi = rowKwi.getCell(colNumkwi);
        if (cellKwi == null) {
            cellKwi = rowKwi.createCell(colNumkwi);
        }

        // Menyimpan nilai ke sel pada baris yang telah Anda pilih atau dibuat
        cellKwi.setCellValue(nomorkwi);
    }

    private String generateNewFilePathKwitansi(String parentDir, String namaAcara, String namaInstansi, String nomorSurat) {
        // Menggabungkan path direktori dan nama file baru dengan mengganti karakter yang tidak valid
        String fileName = namaAcara + "_" + namaInstansi + "_" + nomorSurat.replace("/", "-") + ".xlsx";
        return new File(parentDir, fileName).getAbsolutePath();
    }
private Timer timer;
public void startTimer(final JTable tabelAgenda) {
    timer = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Pass the text fields to updateDateTime
            tabel(tabelAgenda);
        }
    });
    timer.start();
}
public void startTimerAgenda(final JTable tabelAgenda,final JTextField datestart,final JTextField dateend, final JTextField price) {
    timer = new Timer(100000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Pass the text fields to updateDateTime
            tabelAgenda(tabelAgenda);
            datestart.setText("");
            dateend.setText("");
            price.setText("");
        }
    });
    timer.start();
}

    public void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
    public void getDataprice(JTable tabelagenda,JTextField datestart,JTextField dateend,JTextField price){
           try{
               int row1 = tabelagenda.getSelectedRow();
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM agenda WHERE name ='" + tabelagenda.getValueAt(row1, 1) + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                String start =rs.getString("date_start");
                String end = rs.getString("date_end");
                String total = rs.getString("price");
                datestart.setText(start);
                dateend.setText(end);
                price.setText(total);
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void getIdAgendastatus(JTable tabelagenda) {
    try {
        int row1= tabelagenda.getSelectedRow();
        Connection kon = connect.koneksiDb();
        PreparedStatement st = kon.prepareStatement("SELECT id_agenda FROM agenda WHERE name = ?");
        st.setString(1, tabelagenda.getValueAt(row1, 1).toString());
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
    public void updateStatus(JTable tabelagenda){
        try{
            int row1= tabelagenda.getSelectedRow();
            getIdAgendastatus(tabelagenda);
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("Update agenda set status = ? WHERE id_agenda = ?"); 
            prs.setString(1, "Received Payment");
             prs.setString(2, idagenda);
             prs.execute();
             JOptionPane.showMessageDialog(null, "Data Berhasil Di Masukan");
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
}


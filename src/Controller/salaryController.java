/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import static Controller.AbsensiController.timeFormatter;
import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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


    public void addSalary(JComboBox<String> comboKaryawan,JTextField gajipokok,JTextField tunjangan,JTextField bpjs,JTextField pph,JTextField totaldapat, JTextField totalpotong, JDateChooser tgl_salary){
        try{
            getIdkaryawan(comboKaryawan);
             SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = String.valueOf(date.format(tgl_salary.getDate()));
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("INSERT INTO salary (id_karyawan,gaji_pokok,tunjangan,bpjs, pph, totaldapat,totalpotong,date_salary) VALUES(?,?,?,?,?,?,?,?)");
            prs.setInt(1, idkaryawan);
            prs.setString(2, gajipokok.getText());
            prs.setString(3, tunjangan.getText());
            prs.setString(4, bpjs.getText());
            prs.setString(5, pph.getText());
            prs.setString(6, totaldapat.getText());
            prs.setString(7, totalpotong.getText());
            prs.setString(8, tanggal);
             prs.execute();
              JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
    public void cekandconfirmDataSalary(JComboBox<String> comboKaryawan,JTextField gajipokok,JTextField tunjangan,JTextField bpjs,JTextField pph,JTextField totaldapat, JTextField totalpotong, JDateChooser tgl_salary) {
    try {
        getIdkaryawan(comboKaryawan); // Pastikan metode ini telah didefinisikan sebelumnya
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = date.format(tgl_salary.getDate()); // Mengambil nilai tanggal yang benar

        Connection kon = connect.koneksiDb();
        Statement st = kon.createStatement();

        // Periksa apakah data gaji sudah ada untuk karyawan dengan id tertentu pada tanggal tertentu
        String sql_tingkat = "SELECT * FROM salary WHERE id_karyawan = " + idkaryawan + " AND date_salary='" + tanggal + "'";
        ResultSet rs = st.executeQuery(sql_tingkat);

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Maaf Telah Digaji");
        } else {
            // Jika data gaji belum ada, tambahkan data gaji baru
            addSalary(comboKaryawan, gajipokok, tunjangan, bpjs, pph, totaldapat, totalpotong, tgl_salary);
        }

        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
    }
}

    
    DefaultTableModel tabel = new DefaultTableModel();

    public void tabel(JTable tabelSalary) {
    // Mengatur model tabel
    tabelSalary.setModel(tabel);
    
    // Menambahkan kolom pada model tabel
    tabel.addColumn("NAMA KARYAWAN");
    tabel.addColumn("TOTAL PENDAPATAN");
    tabel.addColumn("TOTAL POTONGAN");
    tabel.addColumn("TANGGAL PENGAJIAN");
    // Mengosongkan tabel sebelum menambahkan data baru
    tabel.setRowCount(0);
   
    String query = "SELECT karyawan.name,salary.totaldapat,salary.totalpotong,salary.date_salary FROM salary INNER JOIN karyawan ON salary.id_karyawan = karyawan.id_karyawan ORDER BY karyawan.id_karyawan ASC";

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

            // Menambahkan nomor baris ke data
            // Menambahkan semua data ke dalam array
            String[] data = {d1, d2, d3, d4};
            // Menambahkan baris sesuai dengan data yang tersimpan di array
            tabel.addRow(data);
        }
    } catch (Exception e) {
        System.out.println("Error while populating table: " + e.getMessage());
    }
}
    String nik,jabatan;
     public void getdatakar(JComboBox<String> comboNamaKaryawan) {
    try {
        Connection kon = connect.koneksiDb();
        Statement st = kon.createStatement();
        String sql_tingkat = "SELECT * FROM karyawan WHERE name='" + comboNamaKaryawan.getSelectedItem().toString() + "'";
        ResultSet rs = st.executeQuery(sql_tingkat);
        if (rs.next()) {
            nik = rs.getString("noktp");
            jabatan = rs.getString("possition");
        }
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal: " + e.getMessage());
    }
}
    public void simpanDataKeExcel(JComboBox<String> comboNamaKaryawan, JDateChooser tanggal,  JTextField gajipokok, JTextField tunjangan,JTextField bpjs, JTextField pph,JTextField totaldapat, JTextField totalpotong) {
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
                String namakaryawan=(String) comboNamaKaryawan.getSelectedItem();

                // Add the total price to the Excel sheet
                addDataToSheet(sheet, comboNamaKaryawan, gajipokok, tunjangan, bpjs, pph, totaldapat,  totalpotong, tanggal);

                // Generate nama file baru dengan format yang ditentukan
                String newFilePath = generateNewFilePath(parentDir.getAbsolutePath(), namakaryawan);

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

   

public void addDataToSheet(XSSFSheet sheet, JComboBox<String> comboKaryawan,JTextField gajipokok,JTextField tunjangan,JTextField bpjs,JTextField pph,JTextField totaldapat, JTextField totalpotong, JDateChooser tgl_salary) {
    // Mengambil baris yang telah ditentukan
    getdatakar(comboKaryawan);
    int rowNumNik = 9;
    int rowNumName = 10;
    int rowNumJabat = 11;
    int cellNumGaji = 16;
    int cellNumTunjang = 17;
    int cellNumBpjs = 16; // Kolom D
    int cellNumPph = 17; // Kolom D

    // Memasukkan data karyawan
    XSSFRow rowNik = sheet.getRow(rowNumNik);
    if (rowNik == null) {
        rowNik = sheet.createRow(rowNumNik);
    }
    rowNik.createCell(1).setCellValue(nik);

    XSSFRow rowName = sheet.getRow(rowNumName);
    if (rowName == null) {
        rowName = sheet.createRow(rowNumName);
    }
    rowName.createCell(1).setCellValue(comboKaryawan.getSelectedItem().toString());

    XSSFRow rowJabat = sheet.getRow(rowNumJabat);
    if (rowJabat == null) {
        rowJabat = sheet.createRow(rowNumJabat);
    }
    rowJabat.createCell(1).setCellValue(jabatan);

    // Memasukkan data gaji
    XSSFRow rowGaji = sheet.getRow(cellNumGaji);
    if (rowGaji == null) {
        rowGaji = sheet.createRow(cellNumGaji);
    }
    rowGaji.createCell(1).setCellValue(gajipokok.getText());

    XSSFRow rowTunjang = sheet.getRow(cellNumTunjang);
    if (rowTunjang == null) {
        rowTunjang = sheet.createRow(cellNumTunjang);
    }
    rowTunjang.createCell(1).setCellValue(tunjangan.getText());

    // Memasukkan data potongan (BPJS dan PPH)
    XSSFRow rowBpjs = sheet.getRow(cellNumBpjs);
    if (rowBpjs == null) {
        rowBpjs = sheet.createRow(cellNumBpjs);
    }
    rowBpjs.createCell(3).setCellValue(bpjs.getText());

    XSSFRow rowPph = sheet.getRow(cellNumPph);
    if (rowPph == null) {
        rowPph = sheet.createRow(cellNumPph);
    }
    rowPph.createCell(3).setCellValue(pph.getText());
}


    private String generateNewFilePath(String parentDir, String namaKaryawan) {
        // Menggabungkan path direktori dan nama file baru dengan mengganti karakter yang tidak valid
        String fileName = namaKaryawan + ".xlsx";
        return new File(parentDir, fileName).getAbsolutePath();
    }
}

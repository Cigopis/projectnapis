package Controller;

import Connection.connect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.Timer;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Model.karyawan.absensiKaryawan;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AbsensiController {
    public static final String FILE_PATH = "C:\\Users\\Yudo P\\Documents\\absensi\\Absensi.xlsx";
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("id"));
    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Timer timer;
    // Other fields and methods remain the same

  



    public void addAbsenceToSheet(XSSFSheet sheet, String nama, String tanggal, String status) {
        int rowNum = sheet.getLastRowNum() + 1;
        XSSFRow row = sheet.createRow(rowNum);
        XSSFCellStyle style = sheet.getWorkbook().createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        row.createCell(0).setCellValue(nama);
        row.createCell(1).setCellValue(tanggal);
        row.createCell(2).setCellValue(status);
        for (int i = 0; i < 3; i++) {
            row.getCell(i).setCellStyle(style);
        }
    }

   public void updateDateTime(JTextField tglnow, JTextField timenow) {
    LocalDateTime now = LocalDateTime.now();
    String tanggal = now.format(dateFormatter);
    String waktu = now.format(timeFormatter);
    tglnow.setText(tanggal);
    timenow.setText(waktu);
}


public void startTimer(final JTextField tglnow, final JTextField timenow) {
    timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateDateTime(tglnow, timenow); // Pass the text fields to updateDateTime
        }
    });
    timer.start();
}

    public void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
     public void simpanDataKeExcel(String nama, String tanggal, String status) {
        try {
            File file = new File(FILE_PATH);
            XSSFWorkbook workbook;
   if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } else {
            workbook = new XSSFWorkbook();
        }

        XSSFSheet sheet = workbook.getSheetAt(0); // Mengambil sheet pertama
        
        // Ambil data dari TextField dan simpan ke Excel
        
        addAbsenceToSheet(sheet, nama, tanggal, status);

        FileOutputStream outputStream = new FileOutputStream(FILE_PATH);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
            // Sisipkan logika untuk menyimpan data ke Excel
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getIdteam(JTextField id, JTextField name, JTextField nik, JTextField jabatan, JTextField jamabsen, JTextField status) {
        try {
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM karyawan WHERE norfid ='" + id.getText() + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()) {
                name.setText(rs.getString("name"));
                nik.setText(rs.getString("noktp"));
                jabatan.setText(rs.getString("possition"));
                LocalDateTime now = LocalDateTime.now();
                String waktu = now.format(timeFormatter);
                jamabsen.setText(waktu);
                status.setText("Hadir");
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
}

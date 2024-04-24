/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Model.karyawan;

import Connection.*;
import Controller.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.Locale;
import javax.swing.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 *
 * @author Yudo P
 */
public class absensiKaryawan extends javax.swing.JFrame {

    /**
     * Creates new form absensiKaryawan
     */
    private AbsensiController control;

    public absensiKaryawan(AbsensiController controller) {
        this.control = controller; // Assign the provided controller instance
        initComponents();
        control.updateDateTime(tglnow, timenow);
        control.startTimer(tglnow, timenow);
        control.focuableField(name, nik, jabatan, jamabsen, status);
    }

    

    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        jabatan = new javax.swing.JTextField();
        jamabsen = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        tglnow = new javax.swing.JTextField();
        timenow = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setBackground(new java.awt.Color(127, 199, 217));
        name.setFont(new Font("Montserrat", Font.PLAIN, 25));
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setBorder(null);
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 420, 310, 50));

        nik.setBackground(new java.awt.Color(127, 199, 217));
        nik.setFont(new Font("Montserrat", Font.PLAIN, 25));
        nik.setForeground(new java.awt.Color(255, 255, 255));
        nik.setBorder(null);
        getContentPane().add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 480, 310, 40));

        jabatan.setBackground(new java.awt.Color(127, 199, 217));
        jabatan.setFont(new Font("Montserrat", Font.PLAIN, 25));
        jabatan.setForeground(new java.awt.Color(255, 255, 255));
        jabatan.setBorder(null);
        getContentPane().add(jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 530, 310, 40));

        jamabsen.setBackground(new java.awt.Color(127, 199, 217));
        jamabsen.setFont(new Font("Montserrat", Font.PLAIN, 25));
        jamabsen.setForeground(new java.awt.Color(255, 255, 255));
        jamabsen.setBorder(null);
        getContentPane().add(jamabsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 580, 310, 40));

        status.setBackground(new java.awt.Color(127, 199, 217));
        status.setFont(new Font("Montserrat", Font.PLAIN, 25));
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setBorder(null);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 630, 310, 40));

        id.setBackground(new java.awt.Color(127, 199, 217));
        id.setFont(new Font("Montserrat", Font.PLAIN, 25));
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setBorder(null);
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idKeyReleased(evt);
            }
        });
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 370, 310, 40));

        tglnow.setFont(new Font("Montserrat", Font.BOLD, 26));
        tglnow.setForeground(new java.awt.Color(127, 199, 217));
        tglnow.setBorder(null);
        getContentPane().add(tglnow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 100, 260, 50));

        timenow.setFont(new Font("Montserrat", Font.BOLD, 74));
        timenow.setForeground(new java.awt.Color(127, 199, 217));
        timenow.setBorder(null);
        getContentPane().add(timenow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 150, 300, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/absensi.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyReleased
        // TODO add your handling code here:
                                    
    // TODO add your handling code here:
    if(id.getText().isEmpty()){
        id.setFocusable(true);
    } else {
        // Panggil metode getIdteam() dari objek control saat key release terjadi
        control.getIdteam(id, name, nik, jabatan, jamabsen, status);
        control.simpanDataKeExcel(name.getText(), tglnow.getText(), status.getText());
        id.setFocusable(false);
    }


    }//GEN-LAST:event_idKeyReleased

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    /**
     * @param args the command line arguments
     */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            AbsensiController controller = new AbsensiController();
            absensiKaryawan frame = new absensiKaryawan(controller);
            frame.setVisible(true);
        }
    });
}





    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JTextField jabatan;
    public javax.swing.JTextField jamabsen;
    public javax.swing.JTextField name;
    public javax.swing.JTextField nik;
    public javax.swing.JTextField status;
    public javax.swing.JTextField tglnow;
    public javax.swing.JTextField timenow;
    // End of variables declaration//GEN-END:variables
}

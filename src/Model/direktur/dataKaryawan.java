/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Model.direktur;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Connection.*;
import Controller.karyawanController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.table.DefaultTableModel;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Yudo P
 */
public class dataKaryawan extends javax.swing.JFrame {

    /**
     * Creates new form dataKaryawan
     */
     private karyawanController control;
    public dataKaryawan(karyawanController Controller) {
    initComponents();
    this.control = Controller;
    control.tabel(tabelKaryawan);
}

    
        
        
    

   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKaryawan = new Component.Table();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonradius1 = new Component.buttonradius();
        button2 = new Component.button();
        button1 = new Component.button();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        buttonradius2 = new Component.buttonradius();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        tabelKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelKaryawan.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabelKaryawan);

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(160, 240, 1600, 470);

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(54, 84, 134));
        jLabel5.setText("Tambah Karyawan");
        jDesktopPane1.add(jLabel5);
        jLabel5.setBounds(1460, 750, 230, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Group 103.png"))); // NOI18N
        jDesktopPane1.add(jLabel4);
        jLabel4.setBounds(1700, 740, 48, 50);

        buttonradius1.setBorder(null);
        buttonradius1.setBorderColor(new java.awt.Color(255, 255, 255));
        jDesktopPane1.add(buttonradius1);
        buttonradius1.setBounds(1430, 730, 330, 70);

        button2.setBackground(new java.awt.Color(220, 242, 241));
        button2.setBorder(null);
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Group.png"))); // NOI18N
        button2.setBorderColor(new java.awt.Color(220, 242, 241));
        button2.setColor(new java.awt.Color(220, 242, 241));
        jDesktopPane1.add(button2);
        button2.setBounds(1720, 180, 40, 50);

        button1.setBackground(new java.awt.Color(220, 242, 241));
        button1.setBorder(null);
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Rectangle 51.png"))); // NOI18N
        button1.setBorderColor(new java.awt.Color(220, 242, 241));
        button1.setColor(new java.awt.Color(220, 242, 241));
        jDesktopPane1.add(button1);
        button1.setBounds(1680, 180, 40, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/person.png"))); // NOI18N
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(1640, 40, 40, 60);

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(54, 84, 134));
        jLabel3.setText("Yudo Lasprianto");
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(1690, 50, 110, 16);

        jTextField1.setText("Karyawan");
        jTextField1.setBorder(null);
        jDesktopPane1.add(jTextField1);
        jTextField1.setBounds(1690, 70, 110, 20);

        buttonradius2.setBorder(null);
        buttonradius2.setBorderColor(new java.awt.Color(54, 84, 134));
        jDesktopPane1.add(buttonradius2);
        buttonradius2.setBounds(1620, 40, 270, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Desktop - 7.png"))); // NOI18N
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKaryawanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelKaryawanMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dataKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 karyawanController control = new karyawanController();
                dataKaryawan frame = new dataKaryawan(control);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Component.button button1;
    private Component.button button2;
    private Component.buttonradius buttonradius1;
    private Component.buttonradius buttonradius2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private Component.Table tabelKaryawan;
    // End of variables declaration//GEN-END:variables
}

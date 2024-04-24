/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Model.direktur;

import Controller.klienController;

/**
 *
 * @author LENOVO
 */
public class dataKlien extends javax.swing.JFrame {

    /**
     * Creates new form dataKlien
     */
    private klienController control;
    public dataKlien(klienController controller) {
        this.control = controller;
        initComponents();
        control.tabel(tabelklien);
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
        hapus1 = new Component.buttonradius();
        hapus = new Component.buttonradius();
        tampil = new Component.buttonradius();
        tambahteam = new Component.buttonradius();
        kembali = new Component.buttonradius();
        rekapteam = new Component.buttonradius();
        rekapacara = new Component.buttonradius();
        rekapkeuangan = new Component.buttonradius();
        finance = new Component.buttonradius();
        dataclient = new Component.buttonradius();
        dataacara = new Component.buttonradius();
        datateam = new Component.buttonradius();
        absensi = new Component.buttonradius();
        salaryrecap = new Component.buttonradius();
        salary = new Component.buttonradius();
        karyawanrecap = new Component.buttonradius();
        buttonradius2 = new Component.buttonradius();
        karyawan = new Component.buttonradius();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelklien = new Component.Table();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hapus1.setBackground(new java.awt.Color(127, 199, 217));
        hapus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/tp edit.png"))); // NOI18N
        hapus1.setBorderColor(new java.awt.Color(127, 199, 217));
        hapus1.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(hapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 720, 60, 60));

        hapus.setBackground(new java.awt.Color(127, 199, 217));
        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/tp delete.png"))); // NOI18N
        hapus.setBorderColor(new java.awt.Color(127, 199, 217));
        hapus.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 720, 60, 60));

        tampil.setBackground(new java.awt.Color(127, 199, 217));
        tampil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/tp view.png"))); // NOI18N
        tampil.setBorderColor(new java.awt.Color(127, 199, 217));
        tampil.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(tampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 720, 60, 60));

        tambahteam.setBackground(new java.awt.Color(127, 199, 217));
        tambahteam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/tambah klien.png"))); // NOI18N
        tambahteam.setBorderColor(new java.awt.Color(127, 199, 217));
        tambahteam.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(tambahteam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 720, 310, 60));

        kembali.setBackground(new java.awt.Color(220, 242, 241));
        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/kembali.png"))); // NOI18N
        kembali.setBorderColor(new java.awt.Color(220, 242, 241));
        kembali.setColor(new java.awt.Color(220, 242, 241));
        jDesktopPane1.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 40));

        rekapteam.setBackground(new java.awt.Color(220, 242, 241));
        rekapteam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/rekap team.png"))); // NOI18N
        rekapteam.setBorderColor(new java.awt.Color(220, 242, 241));
        rekapteam.setColor(new java.awt.Color(220, 242, 241));
        jDesktopPane1.add(rekapteam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 920, 120, 80));

        rekapacara.setBackground(new java.awt.Color(220, 242, 241));
        rekapacara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/rekap acara.png"))); // NOI18N
        rekapacara.setBorderColor(new java.awt.Color(220, 242, 241));
        rekapacara.setColor(new java.awt.Color(220, 242, 241));
        jDesktopPane1.add(rekapacara, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 920, 120, 80));

        rekapkeuangan.setBackground(new java.awt.Color(220, 242, 241));
        rekapkeuangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/rekap keuangan.png"))); // NOI18N
        rekapkeuangan.setBorderColor(new java.awt.Color(220, 242, 241));
        rekapkeuangan.setColor(new java.awt.Color(220, 242, 241));
        jDesktopPane1.add(rekapkeuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 920, 140, 80));

        finance.setBackground(new java.awt.Color(127, 199, 217));
        finance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/finance.png"))); // NOI18N
        finance.setBorderColor(new java.awt.Color(127, 199, 217));
        finance.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(finance, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 910, -1, 80));

        dataclient.setBackground(new java.awt.Color(127, 199, 217));
        dataclient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/data client.png"))); // NOI18N
        dataclient.setBorderColor(new java.awt.Color(127, 199, 217));
        dataclient.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(dataclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 910, -1, 80));

        dataacara.setBackground(new java.awt.Color(127, 199, 217));
        dataacara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/data acara.png"))); // NOI18N
        dataacara.setBorderColor(new java.awt.Color(127, 199, 217));
        dataacara.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(dataacara, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 910, 80, 80));

        datateam.setBackground(new java.awt.Color(127, 199, 217));
        datateam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/data team.png"))); // NOI18N
        datateam.setBorderColor(new java.awt.Color(127, 199, 217));
        datateam.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(datateam, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 910, 80, 80));

        absensi.setBackground(new java.awt.Color(127, 199, 217));
        absensi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/absensi.png"))); // NOI18N
        absensi.setBorderColor(new java.awt.Color(127, 199, 217));
        absensi.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(absensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 910, 80, 80));

        salaryrecap.setBackground(new java.awt.Color(220, 242, 241));
        salaryrecap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/salary recap.png"))); // NOI18N
        salaryrecap.setBorderColor(new java.awt.Color(220, 242, 241));
        salaryrecap.setColor(new java.awt.Color(220, 242, 241));
        jDesktopPane1.add(salaryrecap, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 920, 100, 60));

        salary.setBackground(new java.awt.Color(220, 242, 241));
        salary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/salary.png"))); // NOI18N
        salary.setBorderColor(new java.awt.Color(220, 242, 241));
        salary.setColor(new java.awt.Color(220, 242, 241));
        jDesktopPane1.add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 920, 80, 60));

        karyawanrecap.setBackground(new java.awt.Color(220, 242, 241));
        karyawanrecap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/karyawan recap new.png"))); // NOI18N
        karyawanrecap.setBorderColor(new java.awt.Color(220, 242, 241));
        karyawanrecap.setColor(new java.awt.Color(220, 242, 241));
        jDesktopPane1.add(karyawanrecap, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 910, 190, 80));

        buttonradius2.setBackground(new java.awt.Color(127, 199, 217));
        buttonradius2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/karyawan recap.png"))); // NOI18N
        buttonradius2.setBorderColor(new java.awt.Color(127, 199, 217));
        buttonradius2.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(buttonradius2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 910, 190, 80));

        karyawan.setBackground(new java.awt.Color(127, 199, 217));
        karyawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/karyawan.png"))); // NOI18N
        karyawan.setBorderColor(new java.awt.Color(127, 199, 217));
        karyawan.setColor(new java.awt.Color(127, 199, 217));
        jDesktopPane1.add(karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 910, 80, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/bg salary.png"))); // NOI18N
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 910, -1, -1));

        tabelklien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelklien);

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 1710, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/data client form.png"))); // NOI18N
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(dataKlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataKlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataKlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataKlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 klienController control = new klienController();
                dataKlien frame = new dataKlien(control);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Component.buttonradius absensi;
    private Component.buttonradius buttonradius2;
    private Component.buttonradius dataacara;
    private Component.buttonradius dataclient;
    private Component.buttonradius datateam;
    private Component.buttonradius finance;
    private Component.buttonradius hapus;
    private Component.buttonradius hapus1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Component.buttonradius karyawan;
    private Component.buttonradius karyawanrecap;
    private Component.buttonradius kembali;
    private Component.buttonradius rekapacara;
    private Component.buttonradius rekapkeuangan;
    private Component.buttonradius rekapteam;
    private Component.buttonradius salary;
    private Component.buttonradius salaryrecap;
    private Component.Table tabelklien;
    private Component.buttonradius tambahteam;
    private Component.buttonradius tampil;
    // End of variables declaration//GEN-END:variables
}

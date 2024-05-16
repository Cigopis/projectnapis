/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Model.karyawan;

import Model.direktur.*;
import Controller.*;
import java.awt.Font;

/**
 *
 * @author Yudo P
 */
public class reportIncome extends javax.swing.JFrame {

    /**
     * Creates new form reportIncome
     */
    private graphicController control;
    public reportIncome(graphicController controller) {
        initComponents();
        control = controller;
        control.showLineChartIncome(incomePanel);
        control.harianIncome(incomeHarian);
        control.bulananIncome(incomeBulanan);
       control.startTimerIncome(incomePanel, incomeHarian, incomeBulanan);
       control.lostFokus(incomeHarian, incomeBulanan, incomeHarian, incomeBulanan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        incomePanel = new javax.swing.JPanel();
        incomeHarian = new javax.swing.JTextField();
        incomeBulanan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        incomeTable = new Component.Table();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        incomePanel.setLayout(new java.awt.BorderLayout());
        jPanel1.add(incomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 950, 340));

        incomeHarian.setFont(new Font("Montserrat", Font.BOLD, 18));
        incomeHarian.setForeground(new java.awt.Color(127, 199, 217));
        incomeHarian.setBorder(null);
        jPanel1.add(incomeHarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 190, 640, 60));

        incomeBulanan.setFont(new Font("Montserrat", Font.BOLD, 18));
        incomeBulanan.setForeground(new java.awt.Color(127, 199, 217));
        incomeBulanan.setBorder(null);
        jPanel1.add(incomeBulanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 380, 640, 60));

        incomeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(incomeTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 1680, 330));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Desktop - 17.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
            java.util.logging.Logger.getLogger(reportIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reportIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reportIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reportIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                graphicController control = new graphicController();
                reportIncome frame = new reportIncome(control);
                        frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField incomeBulanan;
    private javax.swing.JTextField incomeHarian;
    private javax.swing.JPanel incomePanel;
    private Component.Table incomeTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
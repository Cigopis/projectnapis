/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Model.karyawan;

import Controller.*;

/**
 *
 * @author Yudo P
 */
public class reportOutcome extends javax.swing.JFrame {

    /**
     * Creates new form reportOutcome
     */
    private graphicController control;
    public reportOutcome(graphicController controller) {
        initComponents();
        control=controller;
        control.showLineChartOutcome(outcomePanel);
        control.startTimerOutcome(outcomePanel);
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
        outcomePanel = new javax.swing.JPanel();
        txtSubtotal = new Component.TextField();
        txtTotalbiaya = new Component.TextField();
        tgl_outcome = new com.toedter.calendar.JDateChooser();
        buttonradius1 = new Component.buttonradius();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDeskripsi = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new Component.Table();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        outcomePanel.setLayout(new java.awt.BorderLayout());
        jPanel1.add(outcomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 950, 350));

        txtSubtotal.setLabelText("");
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 620, 170, 40));

        txtTotalbiaya.setLabelText("");
        txtTotalbiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalbiayaActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotalbiaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 650, 170, 40));
        jPanel1.add(tgl_outcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 700, 170, 40));

        buttonradius1.setText("TAMBAH PENGELUARAN");
        buttonradius1.setRadius(15);
        buttonradius1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonradius1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonradius1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 750, 310, 70));

        areaDeskripsi.setColumns(20);
        areaDeskripsi.setRows(5);
        jScrollPane2.setViewportView(areaDeskripsi);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 520, 320, 100));

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 950, 350));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Desktop - 58.png"))); // NOI18N
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

    private void txtTotalbiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalbiayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalbiayaActionPerformed

    private void buttonradius1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonradius1ActionPerformed
        // TODO add your handling code here:
        control.addOutcome(areaDeskripsi, txtSubtotal, txtTotalbiaya, tgl_outcome);
    }//GEN-LAST:event_buttonradius1ActionPerformed

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
            java.util.logging.Logger.getLogger(reportOutcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reportOutcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reportOutcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reportOutcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                graphicController control = new graphicController();
                reportOutcome frame = new reportOutcome(control);
                        frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDeskripsi;
    private Component.buttonradius buttonradius1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel outcomePanel;
    private Component.Table table1;
    private com.toedter.calendar.JDateChooser tgl_outcome;
    private Component.TextField txtSubtotal;
    private Component.TextField txtTotalbiaya;
    // End of variables declaration//GEN-END:variables
}
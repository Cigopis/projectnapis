/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Model.karyawan;

import Controller.registerkarController;
import Model.direktur.loginDirectors;

/**
 *
 * @author Yudo P
 */
public class registerKaryawan extends javax.swing.JFrame {

    /**
     * Creates new form registerKaryawan
     */
    private registerkarController control;
    public registerKaryawan(registerkarController controller) {
        this.control = controller;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtConfirmPass = new javax.swing.JPasswordField();
        txtPass = new javax.swing.JPasswordField();
        txtMail = new javax.swing.JTextField();
        txtMail1 = new javax.swing.JTextField();
        txtPass1 = new javax.swing.JPasswordField();
        txtConfirmPass1 = new javax.swing.JPasswordField();
        buttonradius1 = new Component.buttonradius();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 820, 50, 30));

        txtConfirmPass.setBackground(new java.awt.Color(127, 199, 217));
        txtConfirmPass.setBorder(null);
        getContentPane().add(txtConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, 380, 40));

        txtPass.setBackground(new java.awt.Color(127, 199, 217));
        txtPass.setBorder(null);
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 380, 40));

        txtMail.setBackground(new java.awt.Color(127, 199, 217));
        txtMail.setBorder(null);
        getContentPane().add(txtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 370, 40));

        txtMail1.setBackground(new java.awt.Color(127, 199, 217));
        txtMail1.setBorder(null);
        getContentPane().add(txtMail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 370, 40));

        txtPass1.setBackground(new java.awt.Color(127, 199, 217));
        txtPass1.setBorder(null);
        getContentPane().add(txtPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 380, 40));

        txtConfirmPass1.setBackground(new java.awt.Color(127, 199, 217));
        txtConfirmPass1.setBorder(null);
        getContentPane().add(txtConfirmPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, 380, 40));

        buttonradius1.setForeground(new java.awt.Color(170, 187, 232));
        buttonradius1.setText("DAFTAR");
        buttonradius1.setBorderColor(new java.awt.Color(54, 84, 134));
        buttonradius1.setColor(new java.awt.Color(54, 84, 134));
        buttonradius1.setColorClick(new java.awt.Color(127, 199, 217));
        buttonradius1.setColorOver(new java.awt.Color(220, 242, 241));
        buttonradius1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        buttonradius1.setRadius(50);
        buttonradius1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonradius1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonradius1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 740, 190, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Group 8.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new loginDirectors().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonradius1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonradius1ActionPerformed
        // TODO add your handling code here:
        control.register(txtMail.getText(),txtPass.getText(),txtConfirmPass.getText());
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
            java.util.logging.Logger.getLogger(registerKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                registerkarController control = new registerkarController();
                registerKaryawan frame = new registerKaryawan(control);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Component.buttonradius buttonradius1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JPasswordField txtConfirmPass1;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtMail1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass1;
    // End of variables declaration//GEN-END:variables
}
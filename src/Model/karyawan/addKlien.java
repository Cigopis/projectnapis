/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Model.karyawan;

import Model.direktur.*;
import Controller.klienController;
import java.awt.Font;

/**
 *
 * @author Yudo P
 */
public class addKlien extends javax.swing.JPanel {

    /**
     * Creates new form addKlien
     */
    private klienController control;
    public addKlien(klienController controller) {
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

        txtNameInstansi = new javax.swing.JTextField();
        txtNameClient = new javax.swing.JTextField();
        txtPossition = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaAddress = new javax.swing.JTextArea();
        txtContact = new javax.swing.JTextField();
        buttonradius1 = new Component.buttonradius();
        check = new Component.JCheckBoxCustom();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNameInstansi.setBackground(new java.awt.Color(54, 84, 134));
        txtNameInstansi.setForeground(new java.awt.Color(255, 255, 255));
        txtNameInstansi.setBorder(null);
        add(txtNameInstansi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 250, 20));

        txtNameClient.setBackground(new java.awt.Color(54, 84, 134));
        txtNameClient.setForeground(new java.awt.Color(255, 255, 255));
        txtNameClient.setBorder(null);
        add(txtNameClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 250, 20));

        txtPossition.setBackground(new java.awt.Color(54, 84, 134));
        txtPossition.setForeground(new java.awt.Color(255, 255, 255));
        txtPossition.setBorder(null);
        add(txtPossition, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 250, 20));

        txtEmail.setBackground(new java.awt.Color(54, 84, 134));
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(null);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 250, 20));

        areaAddress.setBackground(new java.awt.Color(54, 84, 134));
        areaAddress.setColumns(20);
        areaAddress.setForeground(new java.awt.Color(255, 255, 255));
        areaAddress.setRows(5);
        jScrollPane1.setViewportView(areaAddress);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 290, 80));

        txtContact.setBackground(new java.awt.Color(54, 84, 134));
        txtContact.setForeground(new java.awt.Color(255, 255, 255));
        txtContact.setBorder(null);
        add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 502, 250, 30));

        buttonradius1.setText("ADD");
        buttonradius1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonradius1ActionPerformed(evt);
            }
        });
        add(buttonradius1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, 200, 40));

        check.setBackground(new java.awt.Color(222, 229, 228));
        check.setForeground(new java.awt.Color(54, 84, 134));
        check.setText("    Apakah sudah yakin?");
        check.setBorderPainted(true);
        check.setBorderPaintedFlat(true);
        check.setFont(new Font("Montserrat", Font.BOLD, 15));
        check.setOpaque(true);
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, 200, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Group 36.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void buttonradius1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonradius1ActionPerformed
        // TODO add your handling code here:
        control.addKlien(txtNameInstansi, txtNameClient, txtPossition, areaAddress, txtEmail, txtContact);
    }//GEN-LAST:event_buttonradius1ActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaAddress;
    private Component.buttonradius buttonradius1;
    private Component.JCheckBoxCustom check;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNameClient;
    private javax.swing.JTextField txtNameInstansi;
    private javax.swing.JTextField txtPossition;
    // End of variables declaration//GEN-END:variables
}

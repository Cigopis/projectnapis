/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Model.direktur;

import Model.karyawan.*;
import Controller.karyawanController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Yudo P
 */

public class updateKaryawan extends javax.swing.JPanel {
    private karyawanController Control;

    public updateKaryawan(karyawanController Controller) {
        this.Control = Controller;
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

        jk = new javax.swing.ButtonGroup();
        txtEmail = new Component.TextField();
        comboJabatan = new Component.Combobox();
        txtName = new Component.TextField();
        txtRfid = new Component.TextField();
        txtContact = new Component.TextField();
        L = new Component.RadioButtonCustom();
        P = new Component.RadioButtonCustom();
        txtNoktp = new Component.TextField();
        check = new Component.JCheckBoxCustom();
        buttonradius1 = new Component.buttonradius();
        tgl_birth = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setOpaque(false);

        txtEmail.setBackground(new java.awt.Color(54, 84, 134));
        txtEmail.setBorder(null);
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setLabelText("");
        txtEmail.setLineColor(new java.awt.Color(255, 255, 255));

        comboJabatan.setBackground(new java.awt.Color(54, 84, 134));
        comboJabatan.setBorder(null);
        comboJabatan.setForeground(new java.awt.Color(255, 255, 255));
        comboJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        comboJabatan.setSelectedIndex(-1);
        comboJabatan.setLabeText("Pilih");
        comboJabatan.setLineColor(new java.awt.Color(54, 84, 134));
        comboJabatan.setOpaque(false);

        txtName.setBackground(new java.awt.Color(54, 84, 134));
        txtName.setBorder(null);
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setLabelText("");
        txtName.setLineColor(new java.awt.Color(255, 255, 255));

        txtRfid.setBackground(new java.awt.Color(54, 84, 134));
        txtRfid.setBorder(null);
        txtRfid.setForeground(new java.awt.Color(255, 255, 255));
        txtRfid.setLabelText("");
        txtRfid.setLineColor(new java.awt.Color(255, 255, 255));

        txtContact.setBackground(new java.awt.Color(54, 84, 134));
        txtContact.setBorder(null);
        txtContact.setForeground(new java.awt.Color(255, 255, 255));
        txtContact.setLabelText("");
        txtContact.setLineColor(new java.awt.Color(255, 255, 255));

        L.setBackground(new java.awt.Color(54, 84, 134));
        jk.add(L);
        L.setForeground(new java.awt.Color(255, 255, 255));
        L.setText("Laki-Laki");
        L.setBorderRadius(20);

        P.setBackground(new java.awt.Color(54, 84, 134));
        jk.add(P);
        P.setForeground(new java.awt.Color(255, 255, 255));
        P.setText("Perempuan");
        P.setBorderRadius(20);

        txtNoktp.setBackground(new java.awt.Color(54, 84, 134));
        txtNoktp.setBorder(null);
        txtNoktp.setForeground(new java.awt.Color(255, 255, 255));
        txtNoktp.setLabelText("");
        txtNoktp.setLineColor(new java.awt.Color(255, 255, 255));

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

        buttonradius1.setBackground(new java.awt.Color(54, 84, 134));
        buttonradius1.setForeground(new java.awt.Color(255, 255, 255));
        buttonradius1.setText("EDIT");
        buttonradius1.setToolTipText("");
        buttonradius1.setBorderColor(new java.awt.Color(54, 84, 134));
        buttonradius1.setColor(new java.awt.Color(54, 84, 134));
        buttonradius1.setColorClick(new java.awt.Color(220, 242, 241));
        buttonradius1.setColorOver(new java.awt.Color(127, 199, 217));
        buttonradius1.setFont(new Font("Montserrat", Font.BOLD, 20));
        buttonradius1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonradius1ActionPerformed(evt);
            }
        });

        tgl_birth.setLocale(new Locale("id"));
        tgl_birth.setBackground(new java.awt.Color(54, 84, 134));
        tgl_birth.setForeground(new java.awt.Color(54, 84, 134));
        tgl_birth.setDateFormatString("EEEE, dd MMMM yyyy");
        tgl_birth.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Group 137.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(txtRfid, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(txtNoktp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(comboJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(buttonradius1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(L, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(tgl_birth, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(txtRfid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtNoktp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(comboJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(680, 680, 680)
                .addComponent(buttonradius1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(L, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(tgl_birth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkActionPerformed

    private void buttonradius1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonradius1ActionPerformed
        // TODO add your handling code here:
        if(check.isSelected()){
            karyawanController control = new karyawanController();
            dataKaryawan frame = new dataKaryawan(control);
           Control.edit(txtRfid, txtNoktp, txtName, tgl_birth, L, P, txtEmail, txtContact, comboJabatan, frame.tabelKaryawan);
        Control.clear(txtRfid, txtNoktp, txtName, tgl_birth,jk, txtEmail, txtContact, comboJabatan);
        }else{
            JOptionPane.showMessageDialog(null, "CHECKLIST DAHULU !", "Warning", JOptionPane.WARNING_MESSAGE);
        }
         
    }//GEN-LAST:event_buttonradius1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Component.RadioButtonCustom L;
    public Component.RadioButtonCustom P;
    private Component.buttonradius buttonradius1;
    private Component.JCheckBoxCustom check;
    public Component.Combobox comboJabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.ButtonGroup jk;
    public com.toedter.calendar.JDateChooser tgl_birth;
    public Component.TextField txtContact;
    public Component.TextField txtEmail;
    public Component.TextField txtName;
    public Component.TextField txtNoktp;
    public Component.TextField txtRfid;
    // End of variables declaration//GEN-END:variables
}

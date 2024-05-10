/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Model.karyawan;

import Model.direktur.*;
import Controller.teamController;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Yudo P
 */
public class addTeam extends javax.swing.JPanel {

    /**
     * Creates new form addTeam
     */
    private teamController control;
    public addTeam(teamController controller) {
        this.control = controller;
        initComponents();
        control.combox1(comboCategory);
        control.headerTabel(tabelKaryawan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboCategory = new Component.Combobox();
        txtInformation = new javax.swing.JTextField();
        buttonradius2 = new Component.buttonradius();
        check = new Component.JCheckBoxCustom();
        txtnamaTeam = new javax.swing.JTextField();
        buttonradius3 = new Component.buttonradius();
        jmlKaryawan = new Component.Spinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKaryawan = new Component.Table();
        jLabel1 = new javax.swing.JLabel();

        comboCategory.setBackground(new java.awt.Color(54, 84, 134));
        comboCategory.setBorder(null);
        comboCategory.setForeground(new java.awt.Color(255, 255, 255));

        txtInformation.setBackground(new java.awt.Color(54, 84, 134));
        txtInformation.setForeground(new java.awt.Color(255, 255, 255));
        txtInformation.setBorder(null);

        buttonradius2.setForeground(new java.awt.Color(255, 255, 255));
        buttonradius2.setText("Create Team");
        buttonradius2.setBorderColor(new java.awt.Color(54, 84, 134));
        buttonradius2.setColor(new java.awt.Color(54, 84, 134));
        buttonradius2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonradius2ActionPerformed(evt);
            }
        });

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

        txtnamaTeam.setBackground(new java.awt.Color(54, 84, 134));
        txtnamaTeam.setForeground(new java.awt.Color(255, 255, 255));
        txtnamaTeam.setBorder(null);
        txtnamaTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaTeamActionPerformed(evt);
            }
        });

        buttonradius3.setForeground(new java.awt.Color(255, 255, 255));
        buttonradius3.setText("ADD");
        buttonradius3.setBorderColor(new java.awt.Color(54, 84, 134));
        buttonradius3.setColor(new java.awt.Color(54, 84, 134));
        buttonradius3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonradius3ActionPerformed(evt);
            }
        });

        jmlKaryawan.setBackground(new java.awt.Color(54, 84, 134));
        jmlKaryawan.setBorder(null);
        jmlKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        jmlKaryawan.setLabelText("");

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
        jScrollPane2.setViewportView(tabelKaryawan);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Group 37 (4).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(buttonradius2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(txtnamaTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(txtInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(buttonradius3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jmlKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(654, 654, 654)
                .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(684, 684, 684)
                .addComponent(buttonradius2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(txtnamaTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(txtInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(buttonradius3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jmlKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkActionPerformed

    private void buttonradius2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonradius2ActionPerformed
        // TODO add your handling code here:
        control.addTeam(comboCategory, txtnamaTeam, txtInformation, tabelKaryawan);
        control.addTeamdetail(txtnamaTeam, tabelKaryawan, jmlKaryawan, comboCategory);
    }//GEN-LAST:event_buttonradius2ActionPerformed

    private void buttonradius3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonradius3ActionPerformed
        // TODO add your handling code here:
          control.tambahTabel(tabelKaryawan, jmlKaryawan);
    }//GEN-LAST:event_buttonradius3ActionPerformed

    private void txtnamaTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaTeamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaTeamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Component.buttonradius buttonradius2;
    private Component.buttonradius buttonradius3;
    private Component.JCheckBoxCustom check;
    private Component.Combobox comboCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private Component.Spinner jmlKaryawan;
    private Component.Table tabelKaryawan;
    private javax.swing.JTextField txtInformation;
    private javax.swing.JTextField txtnamaTeam;
    // End of variables declaration//GEN-END:variables
}

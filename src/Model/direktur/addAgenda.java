/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Model.direktur;

import Controller.*;

/**
 *
 * @author Yudo P
 */
public class addAgenda extends javax.swing.JPanel {

    /**
     * Creates new form addAgenda
     */
    private agendaController control;
    public addAgenda(agendaController controller) {
        initComponents();
        this.control = controller;
        control.combox1(comboCategory);
        control.combox2(comboInstansi);
        control.combox3(comboTeam);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tgl_start = new com.toedter.calendar.JDateChooser();
        txtNameAcara = new Component.TextField();
        txtTotalbiaya = new Component.TextField();
        txtSubharga = new Component.TextField();
        comboCategory = new Component.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaInformation = new javax.swing.JTextArea();
        tgl_end = new com.toedter.calendar.JDateChooser();
        comboInstansi = new Component.Combobox();
        comboTeam = new Component.Combobox();
        buttonradius1 = new Component.buttonradius();
        jLabel1 = new javax.swing.JLabel();

        tgl_start.setBackground(new java.awt.Color(54, 84, 134));
        tgl_start.setForeground(new java.awt.Color(255, 255, 255));

        txtNameAcara.setBackground(new java.awt.Color(54, 84, 134));
        txtNameAcara.setForeground(new java.awt.Color(255, 255, 255));
        txtNameAcara.setLabelText("");

        txtTotalbiaya.setBackground(new java.awt.Color(54, 84, 134));
        txtTotalbiaya.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalbiaya.setLabelText("");

        txtSubharga.setBackground(new java.awt.Color(54, 84, 134));
        txtSubharga.setForeground(new java.awt.Color(255, 255, 255));
        txtSubharga.setLabelText("");

        comboCategory.setBackground(new java.awt.Color(54, 84, 134));
        comboCategory.setForeground(new java.awt.Color(255, 255, 255));
        comboCategory.setLabeText("");
        comboCategory.setOpaque(false);

        areaInformation.setBackground(new java.awt.Color(54, 84, 134));
        areaInformation.setColumns(20);
        areaInformation.setForeground(new java.awt.Color(255, 255, 255));
        areaInformation.setRows(5);
        jScrollPane1.setViewportView(areaInformation);

        tgl_end.setBackground(new java.awt.Color(54, 84, 134));
        tgl_end.setForeground(new java.awt.Color(255, 255, 255));

        comboInstansi.setBackground(new java.awt.Color(54, 84, 134));
        comboInstansi.setForeground(new java.awt.Color(255, 255, 255));
        comboInstansi.setLabeText("");
        comboInstansi.setOpaque(false);

        comboTeam.setBackground(new java.awt.Color(54, 84, 134));
        comboTeam.setForeground(new java.awt.Color(255, 255, 255));
        comboTeam.setLabeText("");
        comboTeam.setOpaque(false);

        buttonradius1.setBackground(new java.awt.Color(54, 84, 134));
        buttonradius1.setForeground(new java.awt.Color(255, 255, 255));
        buttonradius1.setText("ADD");
        buttonradius1.setBorderColor(new java.awt.Color(222, 229, 228));
        buttonradius1.setColor(new java.awt.Color(54, 84, 134));
        buttonradius1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonradius1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/addAgenda.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(txtNameAcara, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(txtSubharga, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(txtTotalbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(tgl_start, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(buttonradius1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(tgl_end, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(comboInstansi, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(txtNameAcara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtSubharga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtTotalbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(tgl_start, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(buttonradius1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(710, 710, 710)
                .addComponent(tgl_end, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(comboInstansi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonradius1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonradius1ActionPerformed
        // TODO add your handling code here:
        String nomer = "KP-1.2/CV.MKN-18.1/IV/2024";
        control.addAgenda(txtNameAcara, areaInformation, txtSubharga, tgl_start, tgl_end, comboCategory, comboInstansi, comboTeam);
        control.addFinance(txtNameAcara, areaInformation, txtSubharga, tgl_start, tgl_end, comboCategory, comboInstansi, comboTeam);
        control.simpanDataKeExcel(comboInstansi, areaInformation, nomer, tgl_start,txtTotalbiaya);
    }//GEN-LAST:event_buttonradius1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaInformation;
    private Component.buttonradius buttonradius1;
    private Component.Combobox comboCategory;
    private Component.Combobox comboInstansi;
    private Component.Combobox comboTeam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser tgl_end;
    private com.toedter.calendar.JDateChooser tgl_start;
    private Component.TextField txtNameAcara;
    private Component.TextField txtSubharga;
    private Component.TextField txtTotalbiaya;
    // End of variables declaration//GEN-END:variables
}

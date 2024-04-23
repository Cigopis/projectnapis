/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Yudo P
 */
public class salaryController {
    int idkaryawan,idagenda;
    public void combox1(JComboBox<String> comboKaryawan){
        try{
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM karyawan";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                comboKaryawan.addItem(rs.getString("name"));
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void combox2(JComboBox<String> comboKaryawan,JComboBox<String> comboAgenda){
        try{
            getIdkaryawan(comboKaryawan);
            Connection kon = connect.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM ((agendainner join team on agenda.id_team = team.id_team) team inner join team_details on team.id_team =team_details.id_team) WHERE id_karyawan="+idkaryawan;
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                comboAgenda.addItem(rs.getString("name"));
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void getIdkaryawan(JComboBox<String> comboKaryawan){
           try{
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM karyawan WHERE name ='" + comboKaryawan.getSelectedItem() + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idkaryawan=rs.getInt("id_karyawan");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void getIdAgenda(JComboBox<String> comboAgenda){
           try{
           Connection kon = connect.koneksiDb();
           Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM agenda WHERE name ='" + comboAgenda.getSelectedItem() + "';";
            ResultSet rs = st.executeQuery(sql_tingkat);
            while (rs.next()){
                idagenda=rs.getInt("id_agenda");
            }
            rs.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void addSalary(JComboBox<String> comboKaryawan,JComboBox<String> comboAgenda,JTextField subtotal, JTextField total, JDateChooser tgl_salary){
        try{
            getIdkaryawan(comboKaryawan);
            getIdAgenda(comboAgenda);
             SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = String.valueOf(date.format(tgl_salary.getDate()));
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("INSERT INTO salary (id_agenda, id_karyawan, subtotal,total,date_salary) VALUES(?,?,?,?,?)"); 
            prs.setInt(1, idagenda);
            prs.setInt(2, idkaryawan);
            prs.setString(3, subtotal.getText());
            prs.setString(4, total.getText());
            prs.setString(5, tanggal);
             prs.execute();
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
    public void updateSalary(JComboBox<String> comboKaryawan,JComboBox<String> comboAgenda,JTextField subtotal, JTextField total, JDateChooser tgl_salary){
        try{
            getIdkaryawan(comboKaryawan);
            getIdAgenda(comboAgenda);
             SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = String.valueOf(date.format(tgl_salary.getDate()));
            Connection kon= connect.koneksiDb();
            Statement st = kon.createStatement(); PreparedStatement prs = kon.prepareStatement("Update salary set id_agenda = ?, id_karyawan = ?, subtotal = ?,total = ?,date_salary = ? WHERE id_karyawan = ? "); 
            prs.setInt(1, idagenda);
            prs.setInt(2, idkaryawan);
            prs.setString(3, subtotal.getText());
            prs.setString(4, total.getText());
            prs.setString(5, tanggal);
             prs.execute();
            }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.connect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.*;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author Yudo P
 */
public class graphicController {
    public void showPieChart(JPanel panelBarChart){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "IPhone 5s" , new Double( 20 ) );  
      barDataset.setValue( "SamSung Grand" , new Double( 20 ) );   
      barDataset.setValue( "MotoG" , new Double( 40 ) );    
      barDataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("mobile sales",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }

    /*=============================================================================*/
    int jan,feb,mar,apr,mey,jun,jul,aug,sep,okt,nov,des,hari,bulan;
    public void harianIncome(JTextField harian) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = connect.koneksiDb();
        String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE DAY(date_income) = DAY(CURRENT_DATE)"; // Ambil total subtotal hanya untuk hari ini
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        if (rs.next()) {
            int hari = rs.getInt("total");
            String formattedHari = "Rp." + NumberFormat.getInstance().format(hari); // Format jumlah menjadi mata uang
            harian.setText(formattedHari);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        // Tutup koneksi, statement, dan result set
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
public void lostFokus(JTextField hariin,JTextField bulanin, JTextField hariout, JTextField bulanout){
    hariin.setFocusable(false);
    bulanin.setFocusable(false);
    hariout.setFocusable(false);
    bulanout.setFocusable(false);
}


public void bulananIncome(JTextField bulanan) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = connect.koneksiDb();
        String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) BETWEEN 1 AND 12"; // Tidak perlu ORDER BY atau LIMIT di sini
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        if (rs.next()) {
            bulan = rs.getInt("total");
            String bul = "Rp."+ NumberFormat.getInstance().format(bulan);
            bulanan.setText(bul);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        // Tutup koneksi, statement, dan result set
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}

      public void januari() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "01"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                jan = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
      public void februari() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "02"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                feb = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
      public void maret() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "03"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                mar = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
      public void april() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "04"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                apr = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
      
      public void mey() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "05"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                mey = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
      public void juni() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "06"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                jun = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
      public void juli() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "07"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                jul = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void agustus() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "08"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                aug = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void september() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "09"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                sep = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void oktober() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "10"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                okt = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void november() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "11"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                nov = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void desember() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connect.koneksiDb();
            String sql = "SELECT SUM(subtotal) AS total FROM finance_income WHERE MONTH(date_income) = ? ORDER BY date_income DESC LIMIT 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "12"); // Gunakan "01" untuk bulan Januari
            rs = ps.executeQuery();

            if (rs.next()) {
                des = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Tutup koneksi, statement, dan result set
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void showLineChartIncome(JPanel panelLineChart) {
        //create dataset for the graph
        januari();
        februari();
        maret();
        april();
        mey();
        juni();
        juli();
        agustus();
        september();
        oktober();
        november();
        desember();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(jan, "Amount", "Jan");
        dataset.setValue(feb, "Amount", "Feb");
        dataset.setValue(mar, "Amount", "Mar");
        dataset.setValue(apr, "Amount", "Apr");
        dataset.setValue(mey, "Amount", "May");
        dataset.setValue(jun, "Amount", "Jun");
        dataset.setValue(jul, "Amount", "Jul");
        dataset.setValue(aug, "Amount", "Aug");
        dataset.setValue(sep, "Amount", "Sep");
        dataset.setValue(okt, "Amount", "Oct");
        dataset.setValue(nov, "Amount", "Nov");
        dataset.setValue(des, "Amount", "Dec");

        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Income Finance", "monthly", "amount",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(new Color(127, 199, 217));

        //create render object to change the modify the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(54, 84, 134);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }

    public void showLineChartOutcome(JPanel panelLineChart) {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "Jan");
        dataset.setValue(150, "Amount", "Feb");
        dataset.setValue(18, "Amount", "Mar");
        dataset.setValue(100, "Amount", "Apr");
        dataset.setValue(80, "Amount", "May");
        dataset.setValue(250, "Amount", "Jun");
        dataset.setValue(200, "Amount", "Jul");
        dataset.setValue(150, "Amount", "Aug");
        dataset.setValue(18, "Amount", "Sep");
        dataset.setValue(100, "Amount", "Oct");
        dataset.setValue(80, "Amount", "Nov");
        dataset.setValue(250, "Amount", "Dec");

        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Outcome Finance", "monthly", "amount",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(new Color(127, 199, 217));

        //create render object to change the modify the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(54, 84, 134);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }

    /*========================================================================================*/
    
    public void showHistogram(JPanel jPanel3){
        
         double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                            77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
                          };
 
 
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, 20);
        
         JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram","Data", "Frequency", dataset,PlotOrientation.VERTICAL, false,true,false);
            XYPlot plot= chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);

        
        
        ChartPanel barpChartPanel2 = new ChartPanel(chart);
        jPanel3.removeAll();
        jPanel3.add(barpChartPanel2, BorderLayout.CENTER);
        jPanel3.validate();
    }

    /*========================================================================================*/
    
    public void showBarChart(JPanel jPanel1){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        JFreeChart chart = ChartFactory.createBarChart("contribution","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        jPanel1.removeAll();
        jPanel1.add(barpChartPanel, BorderLayout.CENTER);
        jPanel1.validate();
        
        
    }
    
}

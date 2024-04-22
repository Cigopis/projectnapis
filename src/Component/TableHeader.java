package Component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel {

    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(54, 84, 134)); // Mengubah warna latar belakang menjadi biru tua
        setFont(new Font("Times New Roman", Font.BOLD, 18)); // Mengatur font menjadi bold
        setForeground(Color.WHITE);
        setBorder(new EmptyBorder(10, 5, 10, 5));
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        // Menggambar garis di bagian bawah header
        grphcs.setColor(new Color(54, 84, 134));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}

package pl.travelbrowser.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SearchPanel extends JPanel {
    
    private final Image background;

    public SearchPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Theme.CARD_BG);
        setPreferredSize(new java.awt.Dimension(0, 400));
        
        URL url = getClass().getResource("/images/search_background.jpg");
        background = (url != null) ? new ImageIcon(url).getImage() : null;

        
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background == null) {
            return;
        }

        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }

        Graphics2D g2 = (Graphics2D) g;
        int gradientHeight = 80;                          
        int top = getHeight() - gradientHeight;

        Color end = Theme.CARD_BG;                     
        Color start = new Color(end.getRed(), end.getGreen(), end.getBlue(), 0);

        g2.setPaint(new GradientPaint(0, top, start, 0, getHeight(), end));
        g2.fillRect(0, top, getWidth(), gradientHeight);
    }
}

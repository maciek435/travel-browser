package pl.travelbrowser.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.net.URL;
import javax.swing.ImageIcon;


public class SearchPanel extends ImagePanel {
    
    public SearchPanel() {
        setLayout(new GridBagLayout());
        setBackground(Theme.BACKGROUND);
        setPreferredSize(new Dimension(0, 400));
        
        URL url = getClass().getResource("/images/search_background.jpg");
        if (url != null) {
            setImage(new ImageIcon(url).getImage());
        }
    }
    //gradient
    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int gradientHeight = 90;                          
        int top = getHeight() - gradientHeight;

        Color end = Theme.BACKGROUND;                     
        Color start = new Color(end.getRed(), end.getGreen(), end.getBlue(), 0);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new GradientPaint(0, top, start, 0, getHeight(), end));
        g2.fillRect(0, top, getWidth(), gradientHeight);   
    }
}

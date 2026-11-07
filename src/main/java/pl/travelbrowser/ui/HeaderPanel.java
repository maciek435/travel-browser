package pl.travelbrowser.ui;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class HeaderPanel extends JPanel {

    public HeaderPanel() {
        setLayout(new BorderLayout());
        setBackground(Theme.HEADER_BG);
        setBorder(new EmptyBorder(10, 36, 10, 36)); 
        
        //logo prawa strona
        URL logoUrl = getClass().getResource("/images/logo.png");
        ImageIcon original = new ImageIcon(logoUrl);
        Image scaled = original.getImage().getScaledInstance(-1, 60, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaled));
        add(logoLabel, BorderLayout.WEST);

        //linki prawa strona
        JPanel nav = new JPanel(new FlowLayout(FlowLayout.RIGHT, 24, 0));
        nav.setOpaque(false);
        nav.add(Theme.navButton("Odkrywaj"));
        nav.add(Theme.navButton("Okazje"));
        nav.add(Theme.navButton("Zapisane"));

        JPanel navWrapper = new JPanel(new GridBagLayout());
        navWrapper.setOpaque(false);
        navWrapper.add(nav);
        add(navWrapper, BorderLayout.EAST);  
    }
}



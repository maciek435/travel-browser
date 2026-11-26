package pl.travelbrowser.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends ImagePanel {

    private final JButton startButton = Theme.accentButton("Zaczynamy");

    public StartPanel() {
        setLayout(new GridBagLayout());          
        setBackground(Theme.HEADER_BG);          

        URL url = getClass().getResource("/images/search_background.jpg");
        if (url != null) {
            setImage(new ImageIcon(url).getImage());
        }

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setOpaque(false);

        JLabel title = new JLabel("Travel Browser");
        title.setFont(Theme.LOGO_FONT.deriveFont(56f));   
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Znajdź swoją wymarzoną podróż");
        subtitle.setFont(Theme.NAV_FONT.deriveFont(22f));
        subtitle.setForeground(Color.WHITE);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.setPreferredSize(new Dimension(220, 50));
        startButton.setMaximumSize(new Dimension(220, 50));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        content.add(title);
        content.add(Box.createVerticalStrut(12));
        content.add(subtitle);
        content.add(Box.createVerticalStrut(32));
        content.add(startButton);

        add(content);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);                       
        g.setColor(new Color(0, 0, 0, 90));            
        g.fillRect(0, 0, getWidth(), getHeight());     
    }

    public void addStartListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
}
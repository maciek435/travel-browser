package pl.travelbrowser.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.travelbrowser.model.Offer;

public class MainWindow extends JFrame {

    private final List<Offer> offers;

    public MainWindow(List<Offer> offers) {
        super("Travel Browser");                                  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setSize(1920, 1080);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        this.offers = offers;

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel resultsPanel = new JPanel(new FlowLayout());

        add(topPanel, BorderLayout.NORTH);
        add(resultsPanel, BorderLayout.CENTER);
    }
}
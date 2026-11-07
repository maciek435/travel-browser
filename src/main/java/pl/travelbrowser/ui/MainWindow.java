package pl.travelbrowser.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.travelbrowser.model.Offer;

public class MainWindow extends JFrame {

    private final List<Offer> offers;
    private final ResultsPanel resultsPanel;

    public MainWindow(List<Offer> offers) {
        super("Travel Browser");                                  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setSize(1920, 1080);
        setBackground(Theme.BACKGROUND);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        this.offers = offers;

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new HeaderPanel(), BorderLayout.NORTH);
        topPanel.add(new SearchPanel(), BorderLayout.CENTER);

        resultsPanel = new ResultsPanel();
        resultsPanel.setBackground(Theme.BACKGROUND);
        add(resultsPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(resultsPanel, BorderLayout.CENTER);

        resultsPanel.setBackground(Color.RED);
        getContentPane().setBackground(Color.GREEN);
    }
}
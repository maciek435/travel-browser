package pl.travelbrowser.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pl.travelbrowser.model.Offer;


public class ResultsPanel extends JPanel {

    private final JTextArea resultsArea = new JTextArea();

    public ResultsPanel() {
        setLayout(new BorderLayout());
        resultsArea.setEditable(false);
        setBackground(Theme.CARD_BG);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void showOffers(List<Offer> offers) {
        // wyczyść pole, wpisz liczbę wyników i każdą ofertę w nowej linii
    }
}
package pl.travelbrowser.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import pl.travelbrowser.model.Offer;


public class ResultsPanel extends JPanel {

    private final JLabel titleLabel = new JLabel();
    private final JPanel grid = new JPanel(new GridLayout(0, 4, 24, 24));


    public ResultsPanel() {
        setLayout(new BorderLayout());
        setBackground(Theme.BACKGROUND);
        setBorder(new EmptyBorder(0, 60, 0, 60));

        titleLabel.setFont(Theme.SECTION_TITLE_FONT);
        titleLabel.setForeground(Theme.TEXT);
        titleLabel.setBorder(new EmptyBorder(0, 0, 16, 0));
        add(titleLabel, BorderLayout.NORTH);

        grid.setOpaque(false);

        JPanel gridHolder = new JPanel(new BorderLayout());
        gridHolder.setOpaque(false);
        gridHolder.add(grid, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(gridHolder);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Theme.BACKGROUND);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);  
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void showOffers(List<Offer> offers) {
        titleLabel.setText("Znaleziono " + offers.size() + " ofert\n\n");
        grid.removeAll();
        for (Offer offer : offers) {
           grid.add(new OfferCard(offer));
        }
        grid.revalidate();
        grid.repaint();
    }
}